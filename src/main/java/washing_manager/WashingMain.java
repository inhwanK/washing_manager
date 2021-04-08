package washing_manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import washing_manager.content.ConsumerGradePanel;
import washing_manager.content.ConsumerListPanel;
import washing_manager.content.LaundryPanel;
import washing_manager.output.Ouput1;

@SuppressWarnings("serial")
public class WashingMain extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfEach;
	private JTextField tfOrderPrice;
	private JButton btnOuput1;


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
		setBounds(100, 100, 550, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 5));
		setContentPane(contentPane);
		
		JPanel pOrder = new JPanel();
		contentPane.add(pOrder, BorderLayout.CENTER);
		pOrder.setLayout(new BorderLayout(0, 0));
		
		JPanel pOrderPrice = new JPanel();
		pOrderPrice.setBorder(new LineBorder(Color.GREEN, 3, true));
		pOrder.add(pOrderPrice, BorderLayout.SOUTH);
		pOrderPrice.setLayout(new GridLayout(0, 2, 10, 0));
		
		JPanel pEach = new JPanel();
		pOrderPrice.add(pEach);
		pEach.setLayout(new GridLayout(0, 3, 10, 0));
		
		JLabel lblEach = new JLabel("세탁수량");
		lblEach.setHorizontalAlignment(SwingConstants.CENTER);
		pEach.add(lblEach);
		
		tfEach = new JTextField();
		pEach.add(tfEach);
		tfEach.setColumns(10);
		
		JLabel lblOrderPrice = new JLabel("세탁가격");
		lblOrderPrice.setFont(new Font("굴림", Font.BOLD, 15));
		lblOrderPrice.setHorizontalAlignment(SwingConstants.CENTER);
		pEach.add(lblOrderPrice);
		
		tfOrderPrice = new JTextField();
		tfOrderPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		tfOrderPrice.setText("123124");
		tfOrderPrice.setFont(new Font("굴림", Font.BOLD, 18));
		tfOrderPrice.setEditable(false);
		pOrderPrice.add(tfOrderPrice);
		tfOrderPrice.setColumns(10);
		
		JPanel pInfo = new JPanel();
		pInfo.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		pOrder.add(pInfo, BorderLayout.CENTER);
		pInfo.setLayout(new BorderLayout(0, 0));
		
		ConsumerListPanel pConList = new ConsumerListPanel();
		pConList.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		pInfo.add(pConList, BorderLayout.CENTER);
		
		JPanel pBtn = new JPanel();
		pBtn.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		contentPane.add(pBtn, BorderLayout.SOUTH);
		pBtn.setLayout(new GridLayout(0, 3, 0, 0));
		
		JButton btnInput = new JButton("[입력]");
		pBtn.add(btnInput);
		
		btnOuput1 = new JButton("[출력1]");
		btnOuput1.addActionListener(this);
		pBtn.add(btnOuput1);
		
		JButton btnOutput2 = new JButton("[출력2]");
		pBtn.add(btnOutput2);
		
		JPanel pCon = new JPanel();
		pCon.setBackground(UIManager.getColor("defColor"));
		contentPane.add(pCon, BorderLayout.NORTH);
		pCon.setLayout(new GridLayout(2, 1, 0, 2));
		
		JPanel pConLine = new JPanel();
		pConLine.setBorder(new LineBorder(Color.BLACK, 2, true));
		pCon.add(pConLine);
		pConLine.setLayout(new GridLayout(0, 1, 0, 0));
		
		ConsumerGradePanel pConGrade = new ConsumerGradePanel();
		pConGrade.setBorder(new EmptyBorder(2, 2, 2, 2));
		pConGrade.setBackground((Color) null);
		pConLine.add(pConGrade);
		
		JPanel pCodeLine = new JPanel();
		pCodeLine.setBorder(new LineBorder(Color.BLACK, 2));
		pCon.add(pCodeLine);
		pCodeLine.setLayout(new GridLayout(0, 1, 0, 0));
		
		LaundryPanel pLn = new LaundryPanel();
		pLn.setBorder(new EmptyBorder(2, 2, 2, 2));
		pCodeLine.add(pLn);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOuput1) {
			actionPerformedBtnOuput1(e);
		}
	}
	protected void actionPerformedBtnOuput1(ActionEvent e) {
		Ouput1 frame = new Ouput1();
		frame.setVisible(true);
	}
}
