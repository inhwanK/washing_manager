package washing_manager.detail;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import washing_manager.dto.OrderList;
import washing_manager.service.OrderListService;

@SuppressWarnings("serial")
public class OrderDetailListPanel extends JPanel implements ActionListener{
	private JTable table;
	private List<OrderList> list;
	private OrderListService service = new OrderListService();
	private JMenuItem mntmDelOrderDetail;
	private JTextField tfPrice;
	private JTextField tfDisPrice;

	

	public JTextField getTfPrice() {
		return tfPrice;
	}

	public JTextField getTfDisPrice() {
		return tfDisPrice;
	}

	public OrderDetailListPanel(int turnNo) {

		initialize(turnNo);
	}

	private void initialize(int turnNo) {
		setBorder(new EmptyBorder(0, 0, 0, 0));
		setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setModel(getModel());
		if(turnNo != 0) {
		loadData(turnNo);
		}
		scrollPane.setViewportView(table);
		
		JPopupMenu popupMenu = new JPopupMenu();
		table.setComponentPopupMenu(popupMenu); 

		mntmDelOrderDetail = new JMenuItem("상세 주문 목록");
		mntmDelOrderDetail.addActionListener(this);
		popupMenu.add(mntmDelOrderDetail);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(1, 4, 0, 0));
		
		JLabel lblPrice = new JLabel("할인전금액");
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblPrice);
		
		tfPrice = new JTextField();
		tfPrice.setEditable(false);
		panel.add(tfPrice);
		tfPrice.setColumns(10);
		
		JLabel lblDisPrice = new JLabel("할인적용금액");
		lblDisPrice.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblDisPrice);
		
		tfDisPrice = new JTextField();
		tfDisPrice.setEditable(false);
		panel.add(tfDisPrice);
		tfDisPrice.setColumns(10);
	}

	public void loadData(int turnNo) {
		initList(turnNo);
		setData();
	}

	private void initList(int turnNo) {
		list = service.showOrderDetailByTurn(turnNo); // turnNo 전달해줘야함.
	}
	
	public void setData() { 
		Object[][] data = new Object[list.size()][];
		for (int i = 0; i < data.length; i++) {
			data[i] = toArray(list.get(i));
		}

		CustomTableModel model = new CustomTableModel(data, getColumnNames());
		table.setModel(model);

		RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
		table.setRowSorter(sorter);

		setAlignAndWidth();
	}
	
	private Object[] getColumnNames() {

		return new String[] {"번호", "제품코드", "제품명", "세탁수량", "세탁단가", "세탁물별총가격"};
	}

	private Object[] toArray(OrderList orderList) {
		return new Object[] {orderList.getDetailNo(), orderList.getLndCode().getLndCode(), orderList.getLndCode().getLndName(),
				orderList.getLndEa() ,orderList.getLndCode().getLndPrice(), orderList.getTotalPrice() };
	}

	private TableModel getModel() {
		CustomTableModel model = new CustomTableModel(/* getData(), getColumnNames() */);
		return model;
	}

	protected void setAlignAndWidth() {
		// 컬럼내용 정렬
		setTableCellAlign(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5);
		// 컬럼별 너비 조정
		setTableCellWidth(90, 90, 90, 90, 90, 90);
	}

	protected void setTableCellWidth(int... width) {
		TableColumnModel tcm = table.getColumnModel();

		for (int i = 0; i < width.length; i++) {
			tcm.getColumn(i).setPreferredWidth(width[i]);
		}
	}

	protected void setTableCellAlign(int align, int... idx) {
		TableColumnModel tcm = table.getColumnModel();

		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);

		for (int i = 0; i < idx.length; i++) {
			tcm.getColumn(idx[i]).setCellRenderer(dtcr);
		}
	}

	private class CustomTableModel extends DefaultTableModel {

		public CustomTableModel() {
		}

		public CustomTableModel(Object[][] data, Object[] columnNames) {
			super(data, columnNames);
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
