package washing_manager.turnlist;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import washing_manager.service.OrderViewService;

@SuppressWarnings("serial")
public class TurnTotalResultPanel extends JPanel implements ActionListener {
	private JTextField tfTotalPrice;
	private OrderViewService service = new OrderViewService();
	
	public JTextField getTfTotalPrice() {
		return tfTotalPrice;
	}
	public TurnTotalResultPanel() {

		initialize();
	}
	private void initialize() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblTotalPrice = new JLabel("전체결제금액");
		lblTotalPrice.setFont(new Font("굴림", Font.BOLD, 25));
		lblTotalPrice.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblTotalPrice);
		
		tfTotalPrice = new JTextField();
		int sum = service.showSumOrderTotalPrice();
		DecimalFormat df = new DecimalFormat();
		tfTotalPrice.setText(df.format(sum) + " 원");
		tfTotalPrice.setFont(new Font("굴림", Font.BOLD, 35));
		tfTotalPrice.setBackground(Color.WHITE);
		tfTotalPrice.setEditable(false);
		tfTotalPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(tfTotalPrice);
		tfTotalPrice.setColumns(10);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public void actionPerformedSetTfTotalPrice(ActionEvent e) {
		int sum = service.showSumOrderTotalPrice();
		DecimalFormat df = new DecimalFormat();
		tfTotalPrice.setText(df.format(sum)+" 원");
	}
}
