package washing_manager.order;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import washing_manager.content.ChoiceConsumerPanel;

@SuppressWarnings("serial")
public class OrderPanel extends JPanel implements ActionListener {
	private JPanel pOrderList;
	private JButton btnAddOrder;
	private int a = 0;
	private List<JPanel> listOrderitem = new ArrayList<>();
	// 싱글톤 패턴? 그 개념을 공부해야함. 그리고 사용해보자.
	private static final OrderPanel instance = new OrderPanel();
	private JButton btnDelOrder;

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public static OrderPanel getInstance() {
		return instance;
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

		ChoiceConsumerPanel pConInfo = new ChoiceConsumerPanel();
		pConInfo.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"\u3141\u3139\u3134\u3147\u3141\u3139\u3147", TitledBorder.LEADING, TitledBorder.TOP, null,
				Color.BLACK));
		add(pConInfo, BorderLayout.NORTH);

		pOrderList = new JPanel();
		pOrderList.setBorder(new EmptyBorder(5, 5, 5, 5));

		add(pOrderList, BorderLayout.CENTER);
		pOrderList.setLayout(new GridLayout(5, 1, 0, 5));

		// 버튼을 생성 그리고 초기화.
		a = 0;
		btnAddOrder = new JButton("+");
		btnAddOrder.addActionListener(this);
		btnAddOrder.setFont(new Font("굴림", Font.BOLD, 60));

		pOrderList.add(btnAddOrder);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAddOrder) {
			actionPerformedBtnAddOrder(e);
		}
	}

	private void actionPerformedBtnAddOrder(ActionEvent e) {

		OrderItemPanel item = new OrderItemPanel(a);
		pOrderList.add(item);
		pOrderList.add(btnAddOrder);

		item.setpOrderList(pOrderList);
		actionPerformedItemCheck(e);

		a++;

//		나중에 다시하자 
//		자바 책에서 장바구니 있음.
	}

	public void actionPerformedItemCheck(ActionEvent e) {
		if (e.getSource() == btnAddOrder) {
			if (a == 4) {
				pOrderList.remove(5);
			}			
		}

		pOrderList.revalidate();

	}
}
