package washing_manager.order;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import washing_manager.content.ChoiceConsumerPanel;
import washing_manager.dto.Consumer;
import washing_manager.dto.Laundry;
import washing_manager.dto.OrderList;
import washing_manager.service.GradeDcService;
import washing_manager.service.LaundryService;
import washing_manager.service.OrderListService;
import washing_manager.service.OrderViewService;
import washing_manager.status.StatusPanel;
import washing_manager.turnlist.TurnListPanel;

@SuppressWarnings("serial")
public class OrderPanel extends JPanel implements ActionListener {
	private JPanel pOrderEdit;
	private ChoiceConsumerPanel pConInfo;
	private static OrderPanel instance = new OrderPanel();
	private JButton btnAddOrder;
	private JPanel pOrderItem;
	private int labelNumber;
	private JPanel pBtn;
	private JPanel pSouth;
	private JButton btnOrderExe;
	private OrderListService orderService = new OrderListService();
	private LaundryService lndService = new LaundryService();
	private OrderViewService viewService = new OrderViewService();
	private GradeDcService gradeService = new GradeDcService();
	private TurnListPanel pTurnList;
	private StatusPanel pStatistics;
	private JTabbedPane tabMain;
	private OrderResultPanel pResult;

	public OrderResultPanel getpResult() {
		return pResult;
	}

	public void setTabMain(JTabbedPane tabMain) {
		this.tabMain = tabMain;
	}

	public void setpStatistics(StatusPanel pStatistics) {
		this.pStatistics = pStatistics;
	}

	public void setpTurnList(TurnListPanel pTurnList) {
		this.pTurnList = pTurnList;
	}

	public void setpBtn(JPanel pBtn) {
		this.pBtn = pBtn;
	}

	public void setItemLbl(int labelNumber) {
		this.labelNumber = labelNumber;
	}

	public JPanel getpOrderItem() {
		return pOrderItem;
	}

	public void setpOrderItem(JPanel pOrderItem) {
		this.pOrderItem = pOrderItem;
	}

	public static OrderPanel getInstance() {
		return instance;
	}

	public ChoiceConsumerPanel getpConInfo() {
		return pConInfo;
	}

	// loadData와 비슷한 기능

	public OrderPanel() {

		initialize();

	}

	private void initialize() {
		setLayout(new BorderLayout(0, 5));

		pConInfo = new ChoiceConsumerPanel();
		pConInfo.setPreferredSize(new Dimension(494, 100));
		pConInfo.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uACE0\uAC1D \uC815\uBCF4",
				TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		add(pConInfo, BorderLayout.NORTH);

		pOrderEdit = new JPanel();
		pOrderEdit.setBorder(new EmptyBorder(5, 5, 5, 5));
		add(pOrderEdit, BorderLayout.CENTER);
		pOrderEdit.setLayout(new BorderLayout(0, 0));

		pBtn = new JPanel();
		pOrderEdit.add(pBtn, BorderLayout.SOUTH);

		btnAddOrder = new JButton("+");
		btnAddOrder.setFont(new Font("굴림", Font.BOLD, 60));
		btnAddOrder.addActionListener(this);
		pBtn.add(btnAddOrder);

		pOrderItem = new JPanel();
		pOrderItem.setBorder(new EmptyBorder(10, 0, 10, 0));
		pOrderEdit.add(pOrderItem, BorderLayout.CENTER);
		pOrderItem.setLayout(new GridLayout(5, 1, 0, 5));

		// 버튼을 생성 그리고 초기화.

		pSouth = new JPanel();
		pSouth.setBorder(new EmptyBorder(0, 0, 0, 0));
		add(pSouth, BorderLayout.SOUTH);
		pSouth.setLayout(new GridLayout(2, 1, 0, 0));

		btnOrderExe = new JButton("주문");
		btnOrderExe.setBorder(new EmptyBorder(5, 5, 5, 5));
		btnOrderExe.setPreferredSize(new Dimension(57, 40));
		btnOrderExe.addActionListener(this);

		pResult = new OrderResultPanel();
		pResult.setPreferredSize(new Dimension(464, 40));
		pSouth.add(pResult);
		pSouth.add(btnOrderExe);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOrderExe) {
			actionPerformedBtnOrderExe(e);
		}
		if (e.getSource() == btnAddOrder) {
			actionPerformedBtnAddOrder(e);
		}
	}

	// 패널 추가 버튼
	private void actionPerformedBtnAddOrder(ActionEvent e) {
		int comCount = pOrderItem.getComponentCount();
		OrderItemPanel item = new OrderItemPanel(comCount + 1);

		if (pOrderItem.getComponentCount() == 5) {
			JOptionPane.showMessageDialog(null, "더 이상 주문할 수 없습니다.");
		} else {
			pOrderItem.add(item);
		}

		comCount = pOrderItem.getComponentCount();
		for (int i = 0; i < comCount; i++) {
			((OrderItemPanel) pOrderItem.getComponent(i)).setpOrderItem(pOrderItem);
			((OrderItemPanel) pOrderItem.getComponent(i)).setpResult(pResult);
		}

		pOrderItem.revalidate();
		pOrderEdit.revalidate();
	}

	// 삭제 액션 수행
	public void actionPerformedRemoveOrder(ActionEvent e) {

		pOrderItem.remove(labelNumber - 1);

		int itemCount = pOrderItem.getComponentCount();
		System.out.println(itemCount);
		for (int i = 0; i < itemCount; i++) {
			((OrderItemPanel) pOrderItem.getComponent(i)).setpOrderItem(pOrderItem);
			((OrderItemPanel) pOrderItem.getComponent(i)).setLabelNumber(i + 1); // 레이블 새로 세팅 ...?
		}

		pOrderItem.revalidate();
		pOrderEdit.revalidate();

	}

	// 주문 버튼
	protected void actionPerformedBtnOrderExe(ActionEvent e) {
		System.out.println("주문 실행");

		int res = JOptionPane.showConfirmDialog(null, "주문하시겠습니까?","영남세탁소",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE,null);
		if(res ==JOptionPane.YES_OPTION) {
			orderService.insertTurn();

			int itemCount = pOrderItem.getComponentCount();

			for (int i = 0; i < itemCount; i++) {
				OrderItemPanel item = ((OrderItemPanel) pOrderItem.getComponent(i));
				OrderList orderList = new OrderList();

				orderList.setConPhone(new Consumer(pConInfo.getTfConPhone().getText())); // 고객 번호 가져오기

				// 세탁물명에 따른 세탁물 데이터 가져오기
				String lndName = ((String) item.getCbLnName().getSelectedItem());
				Laundry laundry = lndService.showLaundryByName(lndName);
				orderList.setLndCode(laundry);

				// 세탁수량 스피너로 가져오기
				orderList.setLndEa((int) item.getSpEach().getValue());

				orderService.insertOrderList(orderList);
			}

			pTurnList.getpTurnStatus().loadData();
			pStatistics.actionPerformedRenewStatistics(e);

			pOrderItem.removeAll();
			pConInfo.setTfAll("", "", "");
			
			pResult.getTfDisOrdPrice().setText("");
			pResult.getTfTotalOrdPrice().setText("");
			
			pTurnList.getpResult().actionPerformedSetTfTotalPrice(e);
			tabMain.setSelectedIndex(2);
		}
		if(res == JOptionPane.NO_OPTION) {
			
		}
		if(res == -1) {
			
		}
		

		// 현황 탭 revalidate() 필요함.
	}
}
