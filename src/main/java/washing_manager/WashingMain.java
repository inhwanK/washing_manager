package washing_manager;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import washing_manager.content.ConsumerGradePanel;
import washing_manager.content.ConsumerListPanel;
import washing_manager.content.LaundryPanel;
import javax.swing.JSeparator;
import javax.swing.border.TitledBorder;
import java.awt.Rectangle;
import javax.swing.UIManager;
import java.awt.Color;

public class WashingMain extends JFrame {

	private JPanel contentPane;
	private JTextField tfEach;
	private JTextField tfOrderPrice;
	private Color defColor = new Color(240,240,240);

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
		setBounds(100, 100, 573, 316);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 5));
		setContentPane(contentPane);
		
		JPanel pOrder = new JPanel();
		contentPane.add(pOrder, BorderLayout.CENTER);
		pOrder.setLayout(new BorderLayout(0, 0));
		
		JPanel pOrderPrice = new JPanel();
		pOrder.add(pOrderPrice, BorderLayout.SOUTH);
		pOrderPrice.setLayout(new GridLayout(0, 2, 10, 0));
		
		JPanel pEach = new JPanel();
		pOrderPrice.add(pEach);
		pEach.setLayout(new GridLayout(0, 3, 10, 0));
		
		JLabel lblEach = new JLabel("세탁수량 :");
		lblEach.setHorizontalAlignment(SwingConstants.RIGHT);
		pEach.add(lblEach);
		
		tfEach = new JTextField();
		pEach.add(tfEach);
		tfEach.setColumns(10);
		
		JLabel lblOrderPrice = new JLabel("세탁가격 :");
		lblOrderPrice.setFont(new Font("굴림", Font.BOLD, 15));
		lblOrderPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		pEach.add(lblOrderPrice);
		
		tfOrderPrice = new JTextField();
		tfOrderPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		tfOrderPrice.setText("123124");
		tfOrderPrice.setFont(new Font("굴림", Font.BOLD, 18));
		tfOrderPrice.setEditable(false);
		pOrderPrice.add(tfOrderPrice);
		tfOrderPrice.setColumns(10);
		
		JPanel pInfo = new JPanel();
		pOrder.add(pInfo, BorderLayout.CENTER);
		pInfo.setLayout(new BorderLayout(0, 0));
		
		ConsumerListPanel pConList = new ConsumerListPanel();
		pInfo.add(pConList, BorderLayout.CENTER);
		
		JLabel label = new JLabel("");
		
		JLabel label_1 = new JLabel("");
		
		JPanel pBtn = new JPanel();
		contentPane.add(pBtn, BorderLayout.SOUTH);
		pBtn.setLayout(new GridLayout(0, 3, 0, 0));
		
		JButton btnInput = new JButton("[입력]");
		pBtn.add(btnInput);
		
		JButton btnOuput1 = new JButton("[출력1]");
		pBtn.add(btnOuput1);
		
		JButton btnOutput2 = new JButton("[출력2]");
		pBtn.add(btnOutput2);
		
		JPanel pCon = new JPanel();
		pCon.setBackground(UIManager.getColor("defColor"));
		pCon.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uC815\uBCF4 \uC785\uB825", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(pCon, BorderLayout.NORTH);
		pCon.setLayout(new GridLayout(2, 1, 0, 2));
		
		ConsumerGradePanel pGrade = new ConsumerGradePanel();
		pGrade.setBackground(UIManager.getColor("defColor"));
		pCon.add(pGrade);
		
		LaundryPanel panel = new LaundryPanel();
		pCon.add(panel);
	}

}
