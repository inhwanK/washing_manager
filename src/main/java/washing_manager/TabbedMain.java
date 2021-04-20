package washing_manager;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import washing_manager.order.OrderPanel;
import washing_manager.search.SearchPanel;
import washing_manager.status.OrderTurnStatusPanel;

@SuppressWarnings("serial")
public class TabbedMain extends JFrame implements ActionListener {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TabbedMain frame = new TabbedMain();
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
	public TabbedMain() {
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
		
		OrderPanel pOrder = new OrderPanel();
		pOrder.setToolTipText("");
		tabMain.addTab("주문", null, pOrder, null);
		
		JPanel pStatus = new JPanel();
		pStatus.setToolTipText("");
		tabMain.addTab("현황", null, pStatus, null);
		pStatus.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.RIGHT);
		pStatus.add(tabbedPane, BorderLayout.CENTER);
		
		OrderTurnStatusPanel panel_1 = new OrderTurnStatusPanel();
		tabbedPane.addTab("순번", null, panel_1, null);
		
		//패널 따로 만들어서 Morph 해야함. 
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("순위", null, panel_2, null);
	}

	public void actionPerformed(ActionEvent e) {
	}
}
