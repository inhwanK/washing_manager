package washing_manager.turnlist;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

import washing_manager.detail.OrderDetailListFrame;
import washing_manager.service.OrderListService;
import washing_manager.status.StatusPanel;

@SuppressWarnings("serial")
public class TurnListPanel extends JPanel implements ActionListener {
	private OrderTurnListPanel pTurnStatus;
	private StatusPanel pStatistics;
	private JMenuItem mntmOrderDetail;
	private JMenuItem mntmDelOrder;
	private OrderListService service = new OrderListService();
	private static TurnListPanel instance = new TurnListPanel();
	private TurnTotalResultPanel pResult;

	
	public static TurnListPanel getInstance() {
		return instance;
	}

	
	public TurnTotalResultPanel getpResult() {
		return pResult;
	}

	public JMenuItem getMntmDelOrder() {
		return mntmDelOrder;
	}

	public OrderTurnListPanel getpTurnStatus() {
		return pTurnStatus;
	}

	public void setpStatistics(StatusPanel pStatistics) {
		this.pStatistics = pStatistics;
	}
	public TurnListPanel() {

		initialize();
	}

	private void initialize() {
		setBorder(new EmptyBorder(0, 5, 0, 5));
		setLayout(new BorderLayout(0, 0));

		pTurnStatus = new OrderTurnListPanel();
		add(pTurnStatus);

		JPopupMenu popupMenu = new JPopupMenu();
		pTurnStatus.setPopupMenu(popupMenu);

		mntmOrderDetail = new JMenuItem("상세 주문 목록");
		mntmOrderDetail.addActionListener(this);
		popupMenu.add(mntmOrderDetail);

		mntmDelOrder = new JMenuItem("주문취소 또는 삭제?");
		mntmDelOrder.addActionListener(this);
		popupMenu.add(mntmDelOrder);
		
		pResult = new TurnTotalResultPanel();
		pResult.setPreferredSize(new Dimension(232, 60));
		add(pResult, BorderLayout.SOUTH);
		pResult.setLayout(new GridLayout(0, 1, 0, 0));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmOrderDetail) {
			int turnNo = pTurnStatus.getItem();
			OrderDetailListFrame frame = new OrderDetailListFrame(turnNo);
			frame.setVisible(true);
		}

		if (e.getSource() == mntmDelOrder) {
			actionPerformedMntmDelOrder(e);
		}

	}

	private void actionPerformedMntmDelOrder(ActionEvent e) {
		/*
		선택한 행의 순번 가져오기.
		순번으로 삭제 서비스 수행.
	 	orderlist auto_increment 초기화 쿼리 수행.
		가져왔던 순번삭제 
		orderturn auto_increment 초기화 쿼리 수행.
		*/
		
		int turnNo = pTurnStatus.getItem();
		service.removeOrderByTurn(turnNo); 
		service.removeTurn(turnNo);
		// 서비스에 정렬까지 때려박음.
		pTurnStatus.loadData();
		pStatistics.actionPerformedRenewStatistics(e);
		pResult.actionPerformedSetTfTotalPrice(e);
	}

	

}
