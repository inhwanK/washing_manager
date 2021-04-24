package washing_manager.detail;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class OrderDetailListFrame extends JFrame {

	private OrderDetailListPanel contentPane;
	private int turnNo = 0;

	public OrderDetailListFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		contentPane = new OrderDetailListPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

	public void setTurnNo(int turnNo) {
		this.turnNo = turnNo;
		contentPane.setTurnNo(turnNo);
	}

}
