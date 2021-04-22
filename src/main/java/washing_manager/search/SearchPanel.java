package washing_manager.search;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
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

@SuppressWarnings("serial")
public class SearchPanel extends JPanel implements ActionListener{
	private JButton btnSearch;
	private ConsumerService service;
	private ConsumerListPanel pTable;
	private ConsumerInputPanel pTextInput;
	private JMenuItem mntmChoice;
	private ChoiceConsumerPanel pChoiceConInfo;
	private JButton btnCancel;
	private JTabbedPane tabMain;
	private ChoiceConsumerPanel pConInfo;
	private static OrderPanel pOrder = OrderPanel.getInstance();

	private static SearchPanel instance = new SearchPanel();
	
	
	public static SearchPanel getInstance() {
		return instance;
	}

	public void setTabMain(JTabbedPane tabMain) {
		this.tabMain = tabMain;
	}
	
	
	public void setpConInfo(ChoiceConsumerPanel pConInfo) {
		this.pConInfo = pConInfo;
	}

	public SearchPanel() {

		initialize();
	}
	private void initialize() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel pSearch = new JPanel();
		add(pSearch, BorderLayout.NORTH);
		pSearch.setLayout(new GridLayout(2, 1, 0, 0));
		
		pTextInput = new ConsumerInputPanel();
		pSearch.add(pTextInput);
		
		JPanel pSearchBtn = new JPanel();
		pSearchBtn.setBorder(new EmptyBorder(3, 3, 3, 3));
		pSearch.add(pSearchBtn);
		pSearchBtn.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnSearch = new JButton("검색");
		btnSearch.addActionListener(this);
		btnSearch.setFont(new Font("나눔고딕", Font.BOLD, 15));
		pSearchBtn.add(btnSearch);
		
		pTable = new ConsumerListPanel();
		add(pTable, BorderLayout.CENTER);
		
		// 팝업메뉴
		JPopupMenu popupMenu = new JPopupMenu();
		pTable.setPopupMenu(popupMenu);
		
		mntmChoice = new JMenuItem("선택");
		mntmChoice.addActionListener(this);
		popupMenu.add(mntmChoice);
		
		JMenuItem mntmConInfo = new JMenuItem("고객정보");
		popupMenu.add(mntmConInfo);
		
		JMenuItem mntmConOrderList = new JMenuItem("고객 주문 현황");
		popupMenu.add(mntmConOrderList);
		
		JPanel pConChoice = new JPanel();
		pConChoice.setBorder(new EmptyBorder(2, 2, 2, 2));
		add(pConChoice, BorderLayout.SOUTH);
		pConChoice.setLayout(new GridLayout(0, 1, 10, 0));
		
		pChoiceConInfo = new ChoiceConsumerPanel();
		pConChoice.add(pChoiceConInfo);
		
		JPanel pBtn = new JPanel();
		pConChoice.add(pBtn);
		pBtn.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnOrder = new JButton("주문하기");
		pBtn.add(btnOrder);
		
		btnCancel = new JButton("선택취소");
		btnCancel.addActionListener(this);
		pBtn.add(btnCancel);
		
		JButton btnConOrderList = new JButton("고객주문목록");
		pBtn.add(btnConOrderList);
		
		JButton btnUpdate = new JButton("고객정보수정");
		pBtn.add(btnUpdate);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel) {
			actionPerformedBtnNewButton_1(e);
		}
		if (e.getSource() == btnSearch) {
			actionPerformedBtnSearch(e);
		}
		if (e.getSource() == mntmChoice) {
			actionPerformedMntmChoice(e);
		}
	}
	private void actionPerformedMntmChoice(ActionEvent e) {
//		String name;
//		String grade;
//		String phone;
		Consumer choCon = new Consumer();
		choCon = pTable.getItem();
		String name = choCon.getConName();
		String grade = choCon.getConGrade().getGrade();
		String phone = choCon.getConPhone();
//		getTfAll();
		
		pChoiceConInfo.setTfAll(name, grade, phone);

		tabMain.setSelectedIndex(1);
//		pOrder.setpConInfo(pChoiceConInfo);
		//물어보기 하 ...
//		tabMain.getComponent(1);
	}
//	너무어려워
//	private void getTfAll() {
//		getTfName();
//		getTfGrade();
//		getTfPhone();
//	}
//
//	public void getTfName() {
//		name = choCon.getConName();
//	}
//	public void getTfGrade() {
//		grade = choCon.getConGrade().getGrade();
//	}
//	public void getTfPhone() {
//		phone = choCon.getConPhone();
//	}
	
	protected void actionPerformedBtnSearch(ActionEvent e) {
		String name = pTextInput.getTfConsumer().getText();
		pTable.setConName(name);
		pTable.loadData();
	}

	protected void actionPerformedBtnNewButton_1(ActionEvent e) {
		pChoiceConInfo.setTfAll("", "", "");
	}
}
