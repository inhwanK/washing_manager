package washing_manager.content;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class OrderPanel extends JPanel implements ActionListener {
	private JPanel pOrderList;
	private JButton btnAddOrder;
	private JPanel[] pArrayOrder = new JPanel[5]; //vector? List? 클래스로 생성하면  
	private int i = 0;

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
		
		// 배열 패널 생성.
		pArrayOrder[i] = new JPanel();
		pOrderList.add(pArrayOrder[i]);
		pArrayOrder[i].setLayout(new GridLayout(1, 1, 0, 0));
		
		btnAddOrder = new JButton("+");
		btnAddOrder.addActionListener(this);
		btnAddOrder.setFont(new Font("굴림", Font.BOLD, 60));
		pArrayOrder[i].add(btnAddOrder);

	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnAddOrder) {
			actionPerformedBtnAddOrder(e);
		}
	}
	
	private void actionPerformedBtnAddOrder(ActionEvent e) {
		JLabel noimpl = new JLabel("주문 패널 아직 구현 안함.");
		pArrayOrder[i].add(noimpl);
		i++;
		System.out.println("왜 갑자기 안되니?");
		
		pArrayOrder[i] = new JPanel();
		pOrderList.add(pArrayOrder[i]);
//		
		pArrayOrder[i].setLayout(new GridLayout(1, 1, 0, 0));
		
		btnAddOrder.setFont(new Font("굴림", Font.BOLD, 60));
		pArrayOrder[i].add(btnAddOrder);
		
		
	}
}
