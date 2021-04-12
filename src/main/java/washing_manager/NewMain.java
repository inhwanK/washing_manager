package washing_manager;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import washing_manager.content.SearchPanel;

public class NewMain extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewMain frame = new NewMain();
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
	public NewMain() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 513, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabMain = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabMain, BorderLayout.CENTER);
		
		SearchPanel pSearch = new SearchPanel();
		tabMain.addTab("검색", null, pSearch, null);
		
		JPanel pOrder = new JPanel();
		pOrder.setToolTipText("");
		tabMain.addTab("주문", null, pOrder, null);
		
		JLabel lblNewLabel = new JLabel("장바구니처럼 + 버튼과 주문하기 버튼 구현");
		pOrder.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		tabMain.addTab("현황", null, panel, null);
		
		JLabel label = new JLabel("주문현황 라디오 버튼으로 두가지 구현");
		panel.add(label);
	}

}
