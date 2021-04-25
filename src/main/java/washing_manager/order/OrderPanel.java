package washing_manager.order;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import washing_manager.content.ChoiceConsumerPanel;
import washing_manager.search.SearchPanel;

@SuppressWarnings("serial")
public class OrderPanel extends JPanel implements ActionListener {
	private JPanel pOrderEdit;

	private List<JPanel> listOrderitem = new ArrayList<>();
	private ChoiceConsumerPanel pConInfo;
	private SearchPanel pSearch = SearchPanel.getInstance();

	private static OrderPanel instance = new OrderPanel();
	private JPanel pBtn;
	private JButton btnAddOrd;
	private JPanel pOrderItem;
	private int labelNumber;

	public void setpOrderItem(JPanel pOrderItem) {
		this.pOrderItem = pOrderItem;
	}

	public static OrderPanel getInstance() {
		return instance;
	}

	public ChoiceConsumerPanel getpConInfo() {
		return pConInfo;
	}

	// 추가 삭제는 구현했음... 아마?
	public List<JPanel> addListOrderitem(OrderItemPanel item) {
		listOrderitem.add(item);
		return listOrderitem;
	}

	public void delListOrderitem(int i) {

		if (listOrderitem.get(i + 1) != null) {
			listOrderitem.set(i, listOrderitem.get(i + 1));
			listOrderitem.set(i + 1, null);
		} else {
			listOrderitem.set(i, null);
		}
	}

	// loadData와 비슷한 기능

	public OrderPanel() {

		initialize();

	}

	private void initialize() {
		setLayout(new BorderLayout(0, 10));

		pConInfo = new ChoiceConsumerPanel();
		pConInfo.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uACE0\uAC1D\uC815\uBCF4",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		add(pConInfo, BorderLayout.NORTH);

		pOrderEdit = new JPanel();
		pOrderEdit.setBorder(new EmptyBorder(5, 5, 5, 5));
		add(pOrderEdit, BorderLayout.CENTER);
		pOrderEdit.setLayout(new BorderLayout(0, 0));

		pBtn = new JPanel();
		pOrderEdit.add(pBtn, BorderLayout.SOUTH);

		btnAddOrd = new JButton("+");
		btnAddOrd.setFont(new Font("굴림", Font.BOLD, 60));
		btnAddOrd.addActionListener(this);
		pBtn.add(btnAddOrd);

		pOrderItem = new JPanel();
		pOrderEdit.add(pOrderItem, BorderLayout.CENTER);

		// 버튼을 생성 그리고 초기화.
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAddOrd) {
			actionPerformedBtnAddOrd(e);
		}
	}

	private void actionPerformedBtnAddOrd(ActionEvent e) {
		int comCount = pOrderItem.getComponentCount();
		OrderItemPanel2 item = new OrderItemPanel2(comCount + 1);

		pOrderItem.add(item);

		if (pOrderItem.getComponentCount() == 5) {
			pOrderEdit.remove(pBtn);
		}

		comCount = pOrderItem.getComponentCount();
		for (int i = 0; i < comCount; i++) {
			((OrderItemPanel2) pOrderItem.getComponent(i)).setpOrderItem(pOrderItem);
		}

		pOrderItem.revalidate();
		pOrderEdit.revalidate();
	}

	private void actionPerformedSortComponent(ActionEvent e) {
		int itemCount = pOrderItem.getComponentCount();

		for (int i = 0; i < itemCount; i++) {

//			((OrderItemPanel2) pOrderItem.getComponent(i)).setLabelNumber(i + 1);
			pOrderItem.revalidate();

		}
	}

	public void actionPerformedRemoveOrder(ActionEvent e) {

		pOrderItem.remove(labelNumber - 1);

		int itemCount = pOrderItem.getComponentCount();
		for (int i = 0; i < itemCount; i++) {
			((OrderItemPanel2) pOrderItem.getComponent(i)).setpOrderItem(pOrderItem);
			((OrderItemPanel2) pOrderItem.getComponent(i)).setLabelNumber(i + 1); //레이블 새로 세팅 ...?
		}
		
		if (itemCount == 4) {
			pBtn = new JPanel();
			pOrderEdit.add(pBtn, BorderLayout.SOUTH);

			btnAddOrd = new JButton("+");
			btnAddOrd.setFont(new Font("굴림", Font.BOLD, 60));
			btnAddOrd.addActionListener(this);
			pBtn.add(btnAddOrd);
		}
		pOrderItem.revalidate();
		pOrderEdit.revalidate();
	}

	public void setItemLbl(int labelNumber) {
		this.labelNumber = labelNumber;

	}
}
