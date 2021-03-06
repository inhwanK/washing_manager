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
import washing_manager.service.LaundryService;

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
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

@SuppressWarnings("serial")
public class OrderItemPanel extends JPanel implements ActionListener, ChangeListener {
	private JComboBox<String> cbLnName;
	private JSpinner spEach;
	private JTextField tfPrice;
	private JButton btnDelOrder;
	private JPanel pOrderItem;
	private JLabel lblNo;
	private int labelNumber;
	private OrderPanel order = OrderPanel.getInstance();
	private LaundryDaoImpl dao = LaundryDaoImpl.getInstance();
	private LaundryService service = new LaundryService();
	private OrderPanel orderPanel;
	private OrderResultPanel pResult;
	private int priceByLnd;

	public void setpResult(OrderResultPanel pResult) {
		this.pResult = pResult;
	}

	public void setOrderPanel(OrderPanel orderPanel) {
		this.orderPanel = orderPanel;
	}

	public void setOrder(OrderPanel order) {
		this.order = order;
	}

	public int getPriceByLnd() {
		return priceByLnd;
	}

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
		setBorder(new LineBorder(Color.DARK_GRAY, 2, true));
		setLayout(new GridLayout(0, 5, 10, 0));

		JPanel pLabel = new JPanel();
		pLabel.setBorder(new EmptyBorder(10, 10, 10, 10));
		add(pLabel);
		pLabel.setLayout(new GridLayout(0, 1, 0, 0));

		lblNo = new JLabel(labelNumber + "");

		lblNo.setFont(new Font("??????", Font.BOLD, 20));
		lblNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblNo.setPreferredSize(new Dimension(30, 30));
		pLabel.add(lblNo);

		JPanel pLnCode = new JPanel();
		pLnCode.setForeground(Color.WHITE);
		pLnCode.setBackground(Color.WHITE);
		add(pLnCode);
		pLnCode.setLayout(new GridLayout(0, 1, 0, 0));

		cbLnName = new JComboBox<String>();
		cbLnName.setBorder(new EmptyBorder(0, 0, 0, 0));
		cbLnName.setBackground(Color.WHITE);
		cbLnName.addActionListener(this);
		cbLnName.setForeground(Color.BLACK);
		//
		List<Laundry> list = service.showLaundryAll();
		cbLnName.addItem("????????????");
		for (int i = 0; i < list.size(); i++) {
			cbLnName.addItem(list.get(i).getLndName());
		}
		pLnCode.add(cbLnName);

//		cbLnCode.setColumns(10);

		JPanel pEach = new JPanel();
		add(pEach);
		pEach.setLayout(new GridLayout(0, 1, 0, 0));

		spEach = new JSpinner();
		spEach.addChangeListener(this);
		spEach.setBorder(new EmptyBorder(0, 0, 0, 0));
		spEach.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		pEach.add(spEach);

		JPanel pPrice = new JPanel();
		add(pPrice);
		pPrice.setLayout(new GridLayout(0, 1, 0, 0));

		tfPrice = new JTextField();
		tfPrice.setBorder(new EmptyBorder(0, 0, 0, 0));
		tfPrice.setEditable(false);
		tfPrice.setForeground(Color.LIGHT_GRAY);
		tfPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		tfPrice.setText("????????????");
		pPrice.add(tfPrice);
		tfPrice.setColumns(10);

		JPanel pDelBtn = new JPanel();
		pDelBtn.setBorder(new EmptyBorder(5, 17, 5, 17));
		add(pDelBtn);
		pDelBtn.setLayout(new GridLayout(0, 1, 0, 0));

		btnDelOrder = new JButton("-");
		btnDelOrder.addActionListener(this);
		btnDelOrder.setFont(new Font("??????", Font.BOLD, 20));
		btnDelOrder.setPreferredSize(new Dimension(50, 50));
		pDelBtn.add(btnDelOrder);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cbLnName) {
			actionPerformedCbLnName(e);
		}

		if (e.getSource() == btnDelOrder) {
			order.setItemLbl(labelNumber);
			order.setpOrderItem(pOrderItem);
			order.actionPerformedRemoveOrder(e);
			order.revalidate();

		}
	}

	protected void actionPerformedCbLnName(ActionEvent e) {
		String lndName = (String) cbLnName.getSelectedItem();
		Laundry laundry = service.showLaundryByName(lndName);
		if (tfPrice != null) {
			tfPrice.setForeground(Color.BLACK);
			tfPrice.setText(laundry.getLndPrice() + "");
		}
	}

	public void stateChanged(ChangeEvent e) {
		if (e.getSource() == spEach) {
			stateChangedSpEach(e);
		}
	}

	protected void stateChangedSpEach(ChangeEvent e) {
		int each = (int) spEach.getValue();
		int price = Integer.parseInt(tfPrice.getText());
		priceByLnd = each * price;
		pResult.actionPerformedSetResult(e);
	}

}
