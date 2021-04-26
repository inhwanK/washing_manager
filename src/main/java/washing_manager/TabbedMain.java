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
import washing_manager.status.StatusPanel;

@SuppressWarnings("serial")
public class TabbedMain extends JFrame implements ActionListener {

	private OrderPanel pOrder = OrderPanel.getInstance();
	private SearchPanel pSearch = SearchPanel.getInstance();
	
	private JPanel contentPane;
	private JTabbedPane tabMain;
	private StatusPanel pStatus;
	
	public OrderPanel getpOrder() {
		return pOrder;
	}		

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

	public TabbedMain() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600 );
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		tabMain = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabMain, BorderLayout.CENTER);
		
		pSearch = new SearchPanel();
		tabMain.addTab("검색", null, pSearch, null);
		pSearch.setTabMain(tabMain);
		
		pOrder = new OrderPanel();
		tabMain.addTab("주문", null, pOrder, null);
		pSearch.setpOrder(pOrder);
		
		pStatus = new StatusPanel();
		tabMain.addTab("현황", null, pStatus, null); // 현황 탭 눌렸을 때 setbounds 더 크게 설정해보자.
		
		
	}

	public void actionPerformed(ActionEvent e) {
		
	}

}
