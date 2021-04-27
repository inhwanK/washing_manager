package washing_manager.order;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import washing_manager.content.ChoiceConsumerPanel;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class OrderPanel extends JPanel implements ActionListener {
	private JPanel pOrderEdit;
	private ChoiceConsumerPanel pConInfo;
	private static OrderPanel instance = new OrderPanel();
	private JButton btnAddOrder;
	private JPanel pOrderItem;
	

	private int labelNumber;
	private JPanel pBtn;
	private JPanel panel;
	private JButton btnOrderExe;

	public void setpBtn(JPanel pBtn) {
		this.pBtn = pBtn;
	}

	public void setItemLbl(int labelNumber) {
		this.labelNumber = labelNumber;
	}

	public JPanel getpOrderItem() {
		return pOrderItem;
	}
	
	public void setpOrderItem(JPanel pOrderItem) {
		this.pOrderItem = pOrderItem;
	}

	public static OrderPanel getInstance() {
		return instance;
	}

	public ChoiceConsumerPanel getpConInfo() {
		return pConInfo;
	}

	// loadData와 비슷한 기능

	public OrderPanel() {

		initialize();

	}

	private void initialize() {
		setLayout(new BorderLayout(0, 5));

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

		btnAddOrder = new JButton("+");
		btnAddOrder.setFont(new Font("굴림", Font.BOLD, 60));
		btnAddOrder.addActionListener(this);
		pBtn.add(btnAddOrder);

		pOrderItem = new JPanel();
		pOrderEdit.add(pOrderItem, BorderLayout.CENTER);
		pOrderItem.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		// 버튼을 생성 그리고 초기화.
		
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnOrderExe = new JButton("주문");
		panel.add(btnOrderExe);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAddOrder) {
			actionPerformedBtnAddOrder(e);
		}
	}

	private void actionPerformedBtnAddOrder(ActionEvent e) {
		int comCount = pOrderItem.getComponentCount();
		OrderItemPanel item = new OrderItemPanel(comCount + 1);

		pOrderItem.add(item);

		if (pOrderItem.getComponentCount() == 5) {
//			pOrderEdit.remove(pBtn);
//			btnAddOrder.setEnabled(true);
		}

		comCount = pOrderItem.getComponentCount();
		for (int i = 0; i < comCount; i++) {
			((OrderItemPanel) pOrderItem.getComponent(i)).setpOrderItem(pOrderItem);
		}

		pOrderItem.revalidate();
		pOrderEdit.revalidate();
	}

	public void actionPerformedRemoveOrder(ActionEvent e) {

		pOrderItem.remove(labelNumber - 1);

		int itemCount = pOrderItem.getComponentCount();
		System.out.println(itemCount);
		if (itemCount == 4) {

//			pOrderEdit.add(pBtn);
			btnAddOrder.setEnabled(false);

//			addPbtn();
		}
		for (int i = 0; i < itemCount; i++) {
			((OrderItemPanel) pOrderItem.getComponent(i)).setpOrderItem(pOrderItem);
			((OrderItemPanel) pOrderItem.getComponent(i)).setLabelNumber(i + 1); // 레이블 새로 세팅 ...?
		}

		
		pOrderItem.revalidate();
		pOrderEdit.revalidate();
	}

	private void addPbtn() {
		pOrderEdit.add(pBtn, BorderLayout.SOUTH);
	}
}
