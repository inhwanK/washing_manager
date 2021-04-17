package washing_manager.content;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class OrderItemPanel extends JPanel implements ActionListener {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnDelOrder;
	private OrderPanel order = OrderPanel.getInstance();
	/**
	 * Create the panel.
	 */
	public OrderItemPanel() {

		initialize();
	}
	private void initialize() {
		setBorder(new LineBorder(null, 1, true));
		setLayout(new GridLayout(0, 5, 10, 0));
		
		JPanel pLnCode = new JPanel();
		add(pLnCode);
		pLnCode.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("세탁코드");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pLnCode.add(lblNewLabel);
		
		textField = new JTextField();
		pLnCode.add(textField);
		textField.setColumns(10);
		
		JPanel pEach = new JPanel();
		add(pEach);
		pEach.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("세탁수량");
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		pEach.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		pEach.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel pPrice = new JPanel();
		add(pPrice);
		pPrice.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("세탁단가");
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		pPrice.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		pPrice.add(textField_2);
		textField_2.setColumns(10);
		
		JPanel pWhat = new JPanel();
		add(pWhat);
		pWhat.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("세탁물별가격?");
		lblNewLabel_3.setBackground(Color.WHITE);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		pWhat.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		pWhat.add(textField_3);
		textField_3.setColumns(10);
		
		JPanel pDelBtn = new JPanel();
		pDelBtn.setBorder(new EmptyBorder(5, 17, 5, 17));
		add(pDelBtn);
		pDelBtn.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnDelOrder = new JButton("-");
		btnDelOrder.addActionListener(this);
		btnDelOrder.setFont(new Font("굴림", Font.BOLD, 20));
		btnDelOrder.setPreferredSize(new Dimension(50, 50));
		pDelBtn.add(btnDelOrder);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnDelOrder) {
			order.delListOrderitem(i);
		}
	}

}
