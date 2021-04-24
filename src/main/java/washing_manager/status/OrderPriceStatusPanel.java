package washing_manager.status;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import washing_manager.dto.ViewAll;
import washing_manager.service.OrderListService;

@SuppressWarnings("serial")
public class OrderPriceStatusPanel extends JPanel {

	private JTable table;
	private List<ViewAll> list;
	private OrderListService service = new OrderListService();

	public OrderPriceStatusPanel() {
		initialize();
	}

	private void initialize() {
		setBorder(new LineBorder(null));
		setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);

		table = new JTable();
		table.setModel(getModel());
		loadData(); // 구현해야됨.
		scrollPane.setViewportView(table);

		JLabel lblNewLabel = new JLabel("세 탁 가 격 순 위");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel, BorderLayout.NORTH);
	}

	private void loadData() {
		initList();
		setData();
	}

	private void initList() {
		list = service.showOrderViewByPrice();
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

		return new String[] { "순번", "고객명", "제품명", "세탁수량", "세탁단가", "등급", "할인율", "세탁가격" };
	}

	private Object[] toArray(ViewAll viewAll) {

		return new Object[] { viewAll.getRank(), viewAll.getConName(), viewAll.getLndName(), viewAll.getLndEa(),
				viewAll.getPriceEa(), viewAll.getConGrade(), viewAll.getDiscount(), viewAll.getPriceAll() };
	}

	//

	private TableModel getModel() {
		CustomTableModel model = new CustomTableModel(/* getData(), getColumnNames() */);
		return model;
	}

	protected void setAlignAndWidth() {
		// 컬럼내용 정렬
		setTableCellAlign(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5, 6, 7);
		// 컬럼별 너비 조정
		setTableCellWidth(90, 90, 90, 90, 90, 90, 90, 90);
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

}
