package washing_manager;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import javax.swing.BoxLayout;

public class WashingMain extends JFrame {

	private JPanel contentPane;
	private JTextField tfLnCode;
	private JTextField tfLnName;
	private JTextField tfLnPrice;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField tfDiscount;
	private JTextField tfOrderPrice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WashingMain frame = new WashingMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WashingMain() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 456, 316);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 5));
		setContentPane(contentPane);
		
		JPanel pLaundry = new JPanel();
		contentPane.add(pLaundry, BorderLayout.NORTH);
		pLaundry.setLayout(new GridLayout(0, 2, 10, 0));
		
		JPanel pLnCode = new JPanel();
		pLaundry.add(pLnCode);
		pLnCode.setLayout(new GridLayout(0, 2, 10, 10));
		
		JLabel lblLnCode = new JLabel("세탁물코드 :");
		lblLnCode.setHorizontalAlignment(SwingConstants.RIGHT);
		pLnCode.add(lblLnCode);
		
		tfLnCode = new JTextField();
		pLnCode.add(tfLnCode);
		tfLnCode.setColumns(10);
		
		JPanel pLnName = new JPanel();
		pLaundry.add(pLnName);
		pLnName.setLayout(new GridLayout(2, 2, 10, 5));
		
		JLabel lblLnName = new JLabel("제품명 :");
		lblLnName.setHorizontalAlignment(SwingConstants.RIGHT);
		pLnName.add(lblLnName);
		
		tfLnName = new JTextField();
		tfLnName.setEditable(false);
		pLnName.add(tfLnName);
		tfLnName.setColumns(10);
		
		JLabel lblLnPrice = new JLabel("세탁단가 :");
		lblLnPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		pLnName.add(lblLnPrice);
		
		tfLnPrice = new JTextField();
		tfLnPrice.setEditable(false);
		pLnName.add(tfLnPrice);
		tfLnPrice.setColumns(10);
		
		JPanel pOrder = new JPanel();
		contentPane.add(pOrder, BorderLayout.CENTER);
		pOrder.setLayout(new GridLayout(0, 2, 10, 0));
		
		JPanel pOrder_1 = new JPanel();
		pOrder.add(pOrder_1);
		pOrder_1.setLayout(new GridLayout(2, 0, 0, 10));
		
		JPanel pOrderTop = new JPanel();
		pOrder_1.add(pOrderTop);
		pOrderTop.setLayout(new GridLayout(0, 2, 10, 10));
		
		JLabel lblConName = new JLabel("고객명 :");
		lblConName.setHorizontalAlignment(SwingConstants.RIGHT);
		pOrderTop.add(lblConName);
		
		textField = new JTextField();
		pOrderTop.add(textField);
		textField.setColumns(10);
		
		JLabel lblEA = new JLabel("세탁수량 :");
		lblEA.setHorizontalAlignment(SwingConstants.RIGHT);
		pOrderTop.add(lblEA);
		
		textField_1 = new JTextField();
		pOrderTop.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblGrade = new JLabel("등급 :");
		lblGrade.setHorizontalAlignment(SwingConstants.RIGHT);
		pOrderTop.add(lblGrade);
		
		textField_2 = new JTextField();
		pOrderTop.add(textField_2);
		textField_2.setColumns(10);
		
		JPanel pOrderBottom = new JPanel();
		pOrder_1.add(pOrderBottom);
		pOrderBottom.setLayout(new GridLayout(2, 1, 0, 20));
		
		JPanel panel = new JPanel();
		pOrderBottom.add(panel);
		panel.setLayout(new GridLayout(0, 2, 10, 0));
		
		JLabel lblDiscount = new JLabel("할인율 :");
		lblDiscount.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblDiscount);
		
		tfDiscount = new JTextField();
		tfDiscount.setEditable(false);
		tfDiscount.setColumns(10);
		panel.add(tfDiscount);
		
		JPanel panel_1 = new JPanel();
		pOrderBottom.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 10, 0));
		
		JLabel lblOrderPrice = new JLabel("세탁가격 :");
		lblOrderPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(lblOrderPrice);
		
		tfOrderPrice = new JTextField();
		tfOrderPrice.setEditable(false);
		tfOrderPrice.setColumns(10);
		panel_1.add(tfOrderPrice);
		
		JPanel pOrderPrice = new JPanel();
		pOrder.add(pOrderPrice);
		pOrderPrice.setLayout(new GridLayout(2, 2, 0, 20));
		
		JPanel pBtn = new JPanel();
		contentPane.add(pBtn, BorderLayout.SOUTH);
		pBtn.setLayout(new GridLayout(0, 3, 0, 0));
		
		JButton btnInput = new JButton("[입력]");
		pBtn.add(btnInput);
		
		JButton btnOuput1 = new JButton("[출력1]");
		pBtn.add(btnOuput1);
		
		JButton btnOutput2 = new JButton("[출력2]");
		pBtn.add(btnOutput2);
	}

}
