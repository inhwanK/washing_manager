package washing_manager.order;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import washing_manager.dao.impl.LaundryDaoImpl;
import washing_manager.dto.Laundry;

import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

@SuppressWarnings("serial")
public class OrderItemPanel extends JPanel implements ActionListener {
	private JComboBox<String> cbLnName;
	private JSpinner spEach;
	private JTextField tfPrice;
	private JButton btnDelOrder;
	private JPanel pOrderItem;
	private JLabel lblNo;
	private int labelNumber;
	private OrderPanel order = OrderPanel.getInstance();
	private LaundryDaoImpl dao = LaundryDaoImpl.getInstance();


	public JComboBox<String> getCbLnName() {
		return cbLnName;
	}

	public JSpinner getSpEach() {
		return spEach;
	}

	public JTextField getTfPrice() {
		return tfPrice;
	}

	public JLabel getLblNo() {
		return lblNo;
	}

	public void setLblNo(JLabel lblNo) {
		this.lblNo = lblNo;
	}

	public int getLabelNumber() {
		return labelNumber;
	}

	public void setLabelNumber(int labelNumber) {
		this.labelNumber = labelNumber;
		this.lblNo.setText(labelNumber + "");
	}

	public void setpOrderItem(JPanel pOrderItem) {
		this.pOrderItem = pOrderItem;
	}

	public OrderItemPanel(int labelNumber) {
		initialize(labelNumber);
		setLabelNumber(labelNumber);
	}

	private void initialize(int labelNumber) {
		setBorder(new LineBorder(Color.GREEN, 2, true));
		setLayout(new GridLayout(0, 5, 10, 0));

		JPanel pLabel = new JPanel();
		pLabel.setBorder(new EmptyBorder(10, 10, 10, 10));
		add(pLabel);
		pLabel.setLayout(new GridLayout(0, 1, 0, 0));

		lblNo = new JLabel(labelNumber + "");

		lblNo.setFont(new Font("굴림", Font.BOLD, 20));
		lblNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblNo.setPreferredSize(new Dimension(30, 30));
		pLabel.add(lblNo);

		JPanel pLnCode = new JPanel();
		pLnCode.setForeground(Color.WHITE);
		pLnCode.setBackground(Color.WHITE);
		add(pLnCode);
		pLnCode.setLayout(new GridLayout(0, 1, 0, 0));

		cbLnName = new JComboBox<String>();
		cbLnName.setForeground(Color.BLACK);
		cbLnName.setBackground(Color.WHITE);
		//
		List<Laundry> list = dao.selectLaundryAll();
		cbLnName.addItem("세탁물명");
		for(int i =0 ; i < list.size(); i++) {
			cbLnName.addItem(list.get(i).getLndName());
		}
		pLnCode.add(cbLnName);
		
//		cbLnCode.setColumns(10);

		JPanel pEach = new JPanel();
		add(pEach);
		pEach.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblEach = new JLabel("세탁수량");
		lblEach.setHorizontalAlignment(SwingConstants.CENTER);
		pEach.add(lblEach);

		spEach = new JSpinner();
		spEach.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		pEach.add(spEach);

		JPanel pPrice = new JPanel();
		add(pPrice);
		pPrice.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblPrice = new JLabel("세탁단가");
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		pPrice.add(lblPrice);

		tfPrice = new JTextField();
		pPrice.add(tfPrice);
		tfPrice.setColumns(10);

		JPanel pDelBtn = new JPanel();
		pDelBtn.setBorder(new EmptyBorder(5, 17, 5, 17));
		add(pDelBtn);
		pDelBtn.setLayout(new GridLayout(0, 1, 0, 0));

		btnDelOrder = new JButton("-");
		btnDelOrder.addActionListener(this);
		btnDelOrder.setFont(new Font("굴림", Font.BOLD, 20));
		btnDelOrder.setPreferredSize(new Dimension(50, 50));
		pDelBtn.add(btnDelOrder);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnDelOrder) {
			order.setItemLbl(labelNumber);
			order.setpOrderItem(pOrderItem);
			order.actionPerformedRemoveOrder(e);
			order.revalidate();

		}
	}
}
