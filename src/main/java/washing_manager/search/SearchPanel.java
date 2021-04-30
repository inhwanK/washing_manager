package washing_manager.search;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import washing_manager.content.ChoiceConsumerPanel;
import washing_manager.dto.Consumer;
import washing_manager.order.OrderPanel;
import washing_manager.service.ConsumerService;
import java.awt.Dimension;

@SuppressWarnings("serial")
public class SearchPanel extends JPanel implements ActionListener {
	private JButton btnSearch;
	private ConsumerService service;
	private ConsumerListPanel pTable;
	private ConsumerInputPanel pTextInput;
	private JMenuItem mntmOrder;
	private JButton btnCancel;
	private JTabbedPane tabMain;
	private ChoiceConsumerPanel pConInfo;
	private static OrderPanel pOrder;
	private static SearchPanel instance = new SearchPanel();
	private JPanel pRenew;
	private JButton btnRenew;

	public ConsumerInputPanel getpTextInput() {
		return pTextInput;
	}

	public static void setpOrder(OrderPanel pOrder) {
		SearchPanel.pOrder = pOrder;
	}

	public static SearchPanel getInstance() {
		return instance;
	}

	public void setTabMain(JTabbedPane tabMain) {// 필수
		this.tabMain = tabMain;
	}

	public ConsumerListPanel getpTable() {
		return pTable;
	}

	public void setpTable(ConsumerListPanel pTable) {
		this.pTable = pTable;
	}

	public void setpConInfo(ChoiceConsumerPanel pConInfo) {
		this.pConInfo = pConInfo;
	}

	public SearchPanel() {

		initialize();
	}

	private void initialize() {
		setLayout(new BorderLayout(0, 5));

		JPanel pSearch = new JPanel();
		add(pSearch, BorderLayout.NORTH);
		pSearch.setLayout(new GridLayout(2, 1, 0, 0));

		pTextInput = new ConsumerInputPanel();
		pTextInput.setPreferredSize(new Dimension(234, 30));
		pTextInput.getTfConsumer().addActionListener(this);
		pSearch.add(pTextInput);

		JPanel pSearchBtn = new JPanel();
		pSearchBtn.setBorder(new EmptyBorder(3, 3, 3, 3));
		pSearch.add(pSearchBtn);
		pSearchBtn.setLayout(new GridLayout(0, 1, 0, 0));

		btnSearch = new JButton("검색");
		btnSearch.setPreferredSize(new Dimension(57, 40));
		btnSearch.addActionListener(this);
		btnSearch.setFont(new Font("나눔고딕", Font.BOLD, 15));
		pSearchBtn.add(btnSearch);

		pTable = new ConsumerListPanel();
		add(pTable, BorderLayout.CENTER);

		// 팝업메뉴
		JPopupMenu popupMenu = new JPopupMenu();
		pTable.setPopupMenu(popupMenu);

		mntmOrder = new JMenuItem("주문");
		mntmOrder.addActionListener(this);
		popupMenu.add(mntmOrder);

	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSearch) {
			actionPerformedBtnSearch(e);
		}
		if (e.getSource() == mntmOrder) {
			actionPerformedMntmChoice(e);
		}
	}

	private void actionPerformedMntmChoice(ActionEvent e) {

		Consumer choCon = new Consumer();
		choCon = pTable.getItem();
		String name = choCon.getConName();
		String grade = choCon.getConGrade().getGrade();
		String phone = choCon.getConPhone();

		tabMain.setSelectedIndex(1);
		(pOrder.getpOrderItem()).removeAll();
		pOrder.getpConInfo().setConInfoAll(name, grade, phone);

	}

	protected void actionPerformedBtnSearch(ActionEvent e) {
		String name = pTextInput.getTfConsumer().getText();
		pTable.setConName(name + "%");
		pTable.loadData();
	}
}
