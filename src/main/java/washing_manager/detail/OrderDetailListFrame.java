package washing_manager.detail;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;

@SuppressWarnings("serial")
public class OrderDetailListFrame extends JFrame {

	private JPanel contentPane;
	private OrderDetailListPanel pTable;

	public OrderDetailListFrame(int turnNo) {
		initialize(turnNo);
	}
	private void initialize(int turnNo) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		pTable = new OrderDetailListPanel(turnNo);
		panel.add(pTable);
	}

}
