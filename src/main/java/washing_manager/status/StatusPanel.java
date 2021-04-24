package washing_manager.status;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.EmptyBorder;

import washing_manager.detail.OrderDetailListFrame;

@SuppressWarnings("serial")
public class StatusPanel extends JPanel implements ActionListener{

	private OrderPriceStatusPanel pPriceStatus;
	private OrderTurnStatusPanel pTurnStatus;
	private JMenuItem mntmOrderDetail;
	private OrderDetailListFrame frame = new OrderDetailListFrame();
	/**
	 * Create the panel.
	 */
	public StatusPanel() {

		initialize();
	}
	private void initialize() {
		setBorder(new EmptyBorder(0, 10, 0, 10));
		setLayout(new GridLayout(1, 2, 10, 0));
		
		pTurnStatus = new OrderTurnStatusPanel();
		add(pTurnStatus);
		
		pPriceStatus = new OrderPriceStatusPanel();
		add(pPriceStatus);
		
		JPopupMenu popupMenu = new JPopupMenu();
		pTurnStatus.setPopupMenu(popupMenu);
		
		mntmOrderDetail = new JMenuItem("상세 주문 목록");
		mntmOrderDetail.addActionListener(this);
		popupMenu.add(mntmOrderDetail);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == mntmOrderDetail) {
			int turnNo = pTurnStatus.getItem();
			frame.setTurnNo(turnNo);
			frame.setVisible(true);
		}
		
	}

}
