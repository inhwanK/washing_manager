package washing_manager;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import washing_manager.order.OrderPanel;
import washing_manager.search.SearchPanel;
import washing_manager.status.OrderPriceStatusPanel;
import washing_manager.status.OrderTurnStatusPanel;

@SuppressWarnings("serial")
public class TabbedMain extends JFrame implements ActionListener {

	private OrderPanel pOrder = OrderPanel.getInstance();
	private SearchPanel pSearch = SearchPanel.getInstance();
	
	private JPanel contentPane;
	private JTabbedPane tabMain;
	
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
		setBounds(100, 100, 513, 387);
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
		pOrder.setToolTipText("");
		tabMain.addTab("주문", null, pOrder, null);
		pSearch.setpOrder(pOrder);
		
		JPanel pStatus = new JPanel();
		pStatus.setToolTipText("");
		tabMain.addTab("현황", null, pStatus, null);
		pStatus.setLayout(new GridLayout(2, 0, 0, 10));
		
		JPanel pTurnList = new OrderTurnStatusPanel();
		pStatus.add(pTurnList);
		
		OrderPriceStatusPanel pPriceList = new OrderPriceStatusPanel();
		pStatus.add(pPriceList);
		
		
	}

	public void actionPerformed(ActionEvent e) {
			
	}

}
