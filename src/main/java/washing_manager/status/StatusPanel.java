package washing_manager.status;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

import washing_manager.detail.OrderDetailListFrame;
import washing_manager.dto.OrderList;
import washing_manager.service.OrderListService;

@SuppressWarnings("serial")
public class StatusPanel extends JPanel implements ActionListener {

	private OrderPriceStatusPanel pPriceStatus;
	private OrderTurnStatusPanel pTurnStatus;
	private JMenuItem mntmOrderDetail;
	private JMenuItem mntmDelOrder;
	private OrderListService service = new OrderListService();
	private static StatusPanel instance = new StatusPanel();

	public static StatusPanel getInstance() {
		return instance;
	}

	public OrderPriceStatusPanel getpPriceStatus() {
		return pPriceStatus;
	}

	public OrderTurnStatusPanel getpTurnStatus() {
		return pTurnStatus;
	}

	public StatusPanel() {

		initialize();
	}

	private void initialize() {
		setBorder(new EmptyBorder(0, 5, 0, 5));
		setLayout(new GridLayout(2, 1, 0, 10));

		pTurnStatus = new OrderTurnStatusPanel();
		add(pTurnStatus);

		pPriceStatus = new OrderPriceStatusPanel();
		add(pPriceStatus);

		JPopupMenu popupMenu = new JPopupMenu();
		pTurnStatus.setPopupMenu(popupMenu);

		mntmOrderDetail = new JMenuItem("상세 주문 목록");
		mntmOrderDetail.addActionListener(this);
		popupMenu.add(mntmOrderDetail);

		mntmDelOrder = new JMenuItem("주문취소 또는 삭제?");
		mntmDelOrder.addActionListener(this);
		popupMenu.add(mntmDelOrder);
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
		pPriceStatus.loadData();
		
	}

}
