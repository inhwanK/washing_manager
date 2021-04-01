package washing_manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import washing_manager.content.ConsumerPanel;
import washing_manager.content.GradePanel;
import washing_manager.content.LaundryPanel;
import washing_manager.content.ConsumerListPanel;

public class WashingMain extends JFrame {

	private JPanel contentPane;
	private JTextField tfEach;
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
		setBounds(100, 100, 573, 316);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 5));
		setContentPane(contentPane);
		
		JPanel pOrder = new JPanel();
		pOrder.setBorder(new EmptyBorder(5, 5, 5, 5));
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
		tfOrderPrice.setFont(new Font("굴림", Font.BOLD, 18));
		tfOrderPrice.setEditable(false);
		pOrderPrice.add(tfOrderPrice);
		tfOrderPrice.setColumns(10);
		
		LaundryPanel pLninfo = new LaundryPanel();
		pOrder.add(pLninfo, BorderLayout.CENTER);
		
		ConsumerListPanel pList = new ConsumerListPanel();
		pOrder.add(pList, BorderLayout.NORTH);
		pList.setLayout(new GridLayout(1, 0, 0, 0));
		
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
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uACE0\uAC1D\uC815\uBCF4", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLUE));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 10, 0));
		
		ConsumerPanel panel_3 = new ConsumerPanel();
		panel_1.add(panel_3);
		
		GradePanel panel_2 = new GradePanel();
		panel.add(panel_2);
	}

}
