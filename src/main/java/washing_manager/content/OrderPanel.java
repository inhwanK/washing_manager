package washing_manager.content;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class OrderPanel extends JPanel implements ActionListener {
	private JPanel pOrderList;
	private JButton btnAddOrder;
//	private JPanel[] pArrayOrder = new JPanel[6]; // vector? List? 클래스로 생성하면 더 쉽게 할 수도 있음.
//	private JPanel pArrayOrder = new JPanel();
	private int i = 0;
	private List<JPanel> pArray;
	private JPanel a;

	public OrderPanel() {

		initialize();
	}

	private void initialize() {
		setLayout(new BorderLayout(0, 0));

		ChoiceConsumerPanel pConInfo = new ChoiceConsumerPanel();
		add(pConInfo, BorderLayout.NORTH);

		pOrderList = new JPanel();

		add(pOrderList, BorderLayout.CENTER);
		pOrderList.setLayout(new GridLayout(5, 1, 0, 0));
		
		// 버튼을 생성 그리고 초기화.
		btnAddOrder = new JButton("+");
		btnAddOrder.addActionListener(this);
		btnAddOrder.setFont(new Font("굴림", Font.BOLD, 60));
		
		pOrderList.add(btnAddOrder);

	}

	public void getOrderPanel() {

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAddOrder) {
			actionPerformedBtnAddOrder(e);
		}
	}

	private void actionPerformedBtnAddOrder(ActionEvent e) { //쌤한테 여쭤보기

		pOrderList.add(new OrderItemPanel());
		pOrderList.add(btnAddOrder);

		if (i == 3) {
			btnAddOrder.setVisible(false);
		}
		pOrderList.revalidate();
		i++;

	}
}
