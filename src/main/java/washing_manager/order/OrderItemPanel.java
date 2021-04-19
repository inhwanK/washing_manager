package washing_manager.order;

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
	private JTextField tfLnCode;
	private JTextField tfEach;
	private JTextField tfPrice;
	private JTextField textField_3;
	private JButton btnDelOrder;
	private OrderPanel order = OrderPanel.getInstance();
	private JPanel pOrderList;
	private int a;
	private int b;
	
	
	
	public OrderItemPanel(int a) {
		this.a = a;
		initialize(a);
	}
	private void initialize(int a) {
		setBorder(new LineBorder(null, 1, true));
		setLayout(new GridLayout(0, 6, 10, 0));
		
		JPanel pLabel = new JPanel();
		pLabel.setBorder(new EmptyBorder(10, 10, 10, 10));
		add(pLabel);
		pLabel.setLayout(new GridLayout(0, 1, 0, 0));
		
		b = a+1;
		JLabel lblNumber = new JLabel(b+"");
		
		lblNumber.setFont(new Font("굴림", Font.BOLD, 20));
		lblNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumber.setPreferredSize(new Dimension(30, 30));
		pLabel.add(lblNumber);
		
		JPanel pLnCode = new JPanel();
		add(pLnCode);
		pLnCode.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblLnCode = new JLabel("세탁코드");
		lblLnCode.setBackground(Color.WHITE);
		lblLnCode.setHorizontalAlignment(SwingConstants.CENTER);
		pLnCode.add(lblLnCode);
		
		tfLnCode = new JTextField();
		pLnCode.add(tfLnCode);
		tfLnCode.setColumns(10);
		
		JPanel pEach = new JPanel();
		add(pEach);
		pEach.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblEach = new JLabel("세탁수량");
		lblEach.setBackground(Color.WHITE);
		lblEach.setHorizontalAlignment(SwingConstants.CENTER);
		pEach.add(lblEach);
		
		tfEach = new JTextField();
		pEach.add(tfEach);
		tfEach.setColumns(10);
		
		JPanel pPrice = new JPanel();
		add(pPrice);
		pPrice.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblPrice = new JLabel("세탁단가");
		lblPrice.setBackground(Color.WHITE);
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		pPrice.add(lblPrice);
		
		tfPrice = new JTextField();
		pPrice.add(tfPrice);
		tfPrice.setColumns(10);
		
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
			
			pOrderList.remove(a);
			
			order.actionPerformedItemCheck(e);
			pOrderList.revalidate();
			setpOrderList(pOrderList);
		}
	}

	public void setpOrderList(JPanel pOrderList) {
		this.pOrderList = pOrderList;
	}

}
