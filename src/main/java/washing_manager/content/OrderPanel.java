package washing_manager.content;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;


@SuppressWarnings("serial")
public class OrderPanel extends JPanel implements ActionListener {
	private JPanel pOrderList;
	private JButton btnAddOrder;
	private int a = 0;
	private List<OrderItemPanel> listOrderitem = new ArrayList<>();
	//싱글톤 패턴? 그 개념을 공부해야함. 그리고 사용해보자.
	private static final OrderPanel instance = new OrderPanel();
	
	
	public static OrderPanel getInstance() {
		return instance;
	}
			
	
	// 추가 삭제는 구현했음... 아마?
	public List<OrderItemPanel> addListOrderitem(OrderItemPanel item) {
		listOrderitem.add(item);
		return listOrderitem;
	}

	public void delListOrderitem(int i) {
		
		if(listOrderitem.get(i+1) != null) {
			listOrderitem.set(i, listOrderitem.get(i+1));
			listOrderitem.set(i+1, null);
		}else {
			listOrderitem.set(i, null);
		}
	}

	//loadData와 비슷한 기능 
	private void loadOrderItem() {
		int i=0;
		
		pOrderList.add(listOrderitem.get(i));
	}
	public OrderPanel() {

		initialize();
	}

	private void initialize() {
		setLayout(new BorderLayout(0, 10));

		ChoiceConsumerPanel pConInfo = new ChoiceConsumerPanel();
		pConInfo.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u3141\u3139\u3134\u3147\u3141\u3139\u3147", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		add(pConInfo, BorderLayout.NORTH);

		pOrderList = new JPanel();
		pOrderList.setBorder(new EmptyBorder(5, 5, 5, 5));

		add(pOrderList, BorderLayout.CENTER);
		pOrderList.setLayout(new GridLayout(5, 1, 0, 5));

		// 버튼을 생성 그리고 초기화.
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

	private void actionPerformedBtnAddOrder(ActionEvent e) { // 쌤한테 여쭤보기
		//loadData 처럼 ? 배열을 만들어 놓고 추가, 삭제할 때마다 배열의 요소를 땡겨오는 식으로 하는 것이 맞음.
		pOrderList.add(new OrderItemPanel());
		pOrderList.add(btnAddOrder);

		if (a == 3) {
			btnAddOrder.setVisible(false);
		}
		pOrderList.revalidate();
		a++;

	}
	
	public void actionPerformedBtnDelOrder(ActionEvent e) {
		
	}
}
