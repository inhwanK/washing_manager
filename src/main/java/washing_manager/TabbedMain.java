package washing_manager;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import washing_manager.order.OrderPanel;
import washing_manager.search.SearchPanel;
import washing_manager.status.StatusPanel;
import washing_manager.turnlist.TurnListPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;

@SuppressWarnings("serial")
public class TabbedMain extends JFrame implements ActionListener {

	private OrderPanel pOrder = OrderPanel.getInstance();
	private SearchPanel pSearch = SearchPanel.getInstance();	
	private JPanel contentPane;
	private JTabbedPane tabMain;
//	private TurnListPanel pStatus = TurnListPanel.getInstance();
	private TurnListPanel pTurnList;
	private StatusPanel pStatistics;
	private JPanel pTool;
	private JButton btnRenew;
	
	public SearchPanel getpSearch() {
		return pSearch;
	}

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
		setTitle("지금까지 이런 세탁소는 없었다. 이것은 방역인가 세탁인가. 영남세탁소");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 700 );
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 5));
		setContentPane(contentPane);
		
		tabMain = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabMain, BorderLayout.CENTER);
		
		pSearch = new SearchPanel();
		tabMain.addTab("검색", null, pSearch, null);
		pSearch.setTabMain(tabMain);
		
		pOrder = new OrderPanel();
		tabMain.addTab("주문", null, pOrder, null);
		pSearch.setpOrder(pOrder);
		pOrder.setTabMain(tabMain);
		
		pTurnList = new TurnListPanel();
		tabMain.addTab("목록", null, pTurnList, null); // 현황 탭 눌렸을 때 setbounds 더 크게 설정해보자.
		pOrder.setpTurnList(pTurnList);
		
		pStatistics = new StatusPanel();
		tabMain.addTab("통계", null, pStatistics, null);
		pTurnList.setpStatistics(pStatistics);
		pOrder.setpStatistics(pStatistics);
		pOrder.getpResult().setOrderPanel(pOrder);
		
		pTool = new JPanel();
		pTool.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		contentPane.add(pTool, BorderLayout.SOUTH);
		pTool.setLayout(new GridLayout(0, 12, 0, 0));
		
		btnRenew = new JButton("@");
		btnRenew.setPreferredSize(new Dimension(33, 50));
		btnRenew.addActionListener(this);
		pTool.add(btnRenew);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		pSearch.getpTable().setConName(null);
		pSearch.getpTable().loadData();
	}
}
