package washing_manager.detail;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class OrderDetailListFrame extends JFrame {

	private JPanel contentPane;

	public OrderDetailListFrame(int turnNo) {
		initialize(turnNo);
	}
	private void initialize(int turnNo) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		OrderDetailListPanel pTable = new OrderDetailListPanel(turnNo);
		contentPane.add(pTable, BorderLayout.CENTER);
	}

}
