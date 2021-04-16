package washing_manager.content;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class OrderPanel extends JPanel implements ActionListener {
	private JPanel pOrderList;
	private JButton btnAddOrder;
	private int i = 0;

	public OrderPanel() {

		initialize();
	}

	private void initialize() {
		setLayout(new BorderLayout(0, 10));

		ChoiceConsumerPanel pConInfo = new ChoiceConsumerPanel();
		pConInfo.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u3141\u3139\u3134\u3147\u3141\u3139\u3147", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		add(pConInfo, BorderLayout.NORTH);

		pOrderList = new JPanel();
		pOrderList.setBorder(new EmptyBorder(10, 5, 10, 5));

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

		pOrderList.add(new OrderItemPanel());
		pOrderList.add(btnAddOrder);

		if (i == 3) {
			btnAddOrder.setVisible(false);
		}
		pOrderList.revalidate();
		i++;

	}
}
