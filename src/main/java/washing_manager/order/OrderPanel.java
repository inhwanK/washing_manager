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
import washing_manager.dto.GradeDc;
import washing_manager.dto.Laundry;
import washing_manager.dto.OrderList;
import washing_manager.search.SearchPanel;
import washing_manager.service.ConsumerService;
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
	private ConsumerService conService = new ConsumerService();
	private TurnListPanel pTurnList;
	private StatusPanel pStatistics;
	private JTabbedPane tabMain;
	private OrderResultPanel pResult;
	private SearchPanel pSearch;
	
	

	public void setpSearch(SearchPanel pSearch) {
		this.pSearch = pSearch;
	}

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

	// loadData??? ????????? ??????

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
		btnAddOrder.setFont(new Font("??????", Font.BOLD, 60));
		btnAddOrder.addActionListener(this);
		pBtn.add(btnAddOrder);

		pOrderItem = new JPanel();
		pOrderItem.setBorder(new EmptyBorder(10, 0, 10, 0));
		pOrderEdit.add(pOrderItem, BorderLayout.CENTER);
		pOrderItem.setLayout(new GridLayout(5, 1, 0, 5));

		// ????????? ?????? ????????? ?????????.

		pSouth = new JPanel();
		pSouth.setBorder(new EmptyBorder(0, 0, 0, 0));
		add(pSouth, BorderLayout.SOUTH);
		pSouth.setLayout(new GridLayout(2, 1, 0, 0));

		btnOrderExe = new JButton("??????");
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

	// ?????? ?????? ??????
	private void actionPerformedBtnAddOrder(ActionEvent e) {
		int comCount = pOrderItem.getComponentCount();
		OrderItemPanel item = new OrderItemPanel(comCount + 1);

		if (pOrderItem.getComponentCount() == 5) {
			JOptionPane.showMessageDialog(null, "??? ?????? ????????? ??? ????????????.");
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

	// ?????? ?????? ??????
	public void actionPerformedRemoveOrder(ActionEvent e) {

		pOrderItem.remove(labelNumber - 1);

		int itemCount = pOrderItem.getComponentCount();
		System.out.println(itemCount);
		for (int i = 0; i < itemCount; i++) {
			((OrderItemPanel) pOrderItem.getComponent(i)).setpOrderItem(pOrderItem);
			((OrderItemPanel) pOrderItem.getComponent(i)).setLabelNumber(i + 1); // ????????? ?????? ?????? ...?
		}

		pOrderItem.revalidate();
		pOrderEdit.revalidate();

	}

	// ?????? ??????
	protected void actionPerformedBtnOrderExe(ActionEvent e) {
		
		if (pResult.getTfDisOrdPrice().getText().equals("")) {
			JOptionPane.showMessageDialog(null, "?????? ?????? ?????? ?????? ????????? ????????????.");
		} else {
			String conPhone = pConInfo.getTfConPhone().getText();
			Consumer consumer = conService.showConsumerByPhone(conPhone);
			System.out.println(consumer);
			if(consumer == null) {
				consumer = new Consumer();
				consumer.setConGrade(new GradeDc((String) pConInfo.getCbConGrade().getSelectedItem()));
				consumer.setConName(pConInfo.getTfConName().getText().trim());
				consumer.setConPhone(pConInfo.getTfConPhone().getText().trim());
				conService.addConsumer(consumer);
			}
			
			int res = JOptionPane.showConfirmDialog(null, "?????????????????????????", "???????????????", JOptionPane.YES_NO_OPTION,
					JOptionPane.WARNING_MESSAGE, null);

			if (res == JOptionPane.YES_OPTION) {
				orderService.insertTurn();

				int itemCount = pOrderItem.getComponentCount();

				for (int i = 0; i < itemCount; i++) {
					OrderItemPanel item = ((OrderItemPanel) pOrderItem.getComponent(i));
					OrderList orderList = new OrderList();

					orderList.setConPhone(new Consumer(pConInfo.getTfConPhone().getText())); // ?????? ?????? ????????????

					// ??????????????? ?????? ????????? ????????? ????????????
					String lndName = ((String) item.getCbLnName().getSelectedItem());
					Laundry laundry = lndService.showLaundryByName(lndName);
					orderList.setLndCode(laundry);

					// ???????????? ???????????? ????????????
					orderList.setLndEa((int) item.getSpEach().getValue());

					orderService.insertOrderList(orderList);
				}

				pTurnList.getpTurnStatus().loadData();
				pSearch.getpTable().loadData();
				pStatistics.actionPerformedRenewStatistics(e);

				pOrderItem.removeAll();
				pConInfo.setConInfoAll("", "D", "");

				pResult.getTfDisOrdPrice().setText("");
				pResult.getTfTotalOrdPrice().setText("");

				pTurnList.getpResult().actionPerformedSetTfTotalPrice(e);
				tabMain.setSelectedIndex(2);
			}
			if (res == JOptionPane.NO_OPTION) {

			}
			if (res == -1) {

			}
		}

		// ?????? ??? revalidate() ?????????.
	}

}
