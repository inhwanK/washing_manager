package washing_manager.status;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import washing_manager.dto.ViewAll;
import washing_manager.service.OrderViewService;

@SuppressWarnings("serial")
public class OrderTurnStatusPanel extends JPanel {

	private JTable table;
	private List<ViewAll> list;
	private OrderViewService service = new OrderViewService();

	public OrderTurnStatusPanel() {
		initialize();
	}

	private void initialize() {
		setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);

		table = new JTable();
		table.setModel(getModel());
		loadData();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		JLabel lblOrderStatus = new JLabel("세 탁 물 주 문 현 황");
		lblOrderStatus.setFont(new Font("굴림", Font.BOLD, 20));
		lblOrderStatus.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblOrderStatus, BorderLayout.NORTH);
	}

	public void loadData() {
		initList();
		setData();
	}

	private void initList() {
		list = service.showOrderViewAll();
	}

	public void setPopupMenu(JPopupMenu popMenu) { // 이거 꼭필요함
		table.setComponentPopupMenu(popMenu); 
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

		return new String[] { "순번", "고객명", "제품명(세탁수량)", "등급", "할인율", "세탁가격"};
	}

	// toArray 다시짜봄.
	private Object[] toArray(ViewAll viewAll) {
	
		return new Object[] { viewAll.getTurnNo(), viewAll.getConName(), viewAll.getLndNameEa(),
				viewAll.getConGrade(), viewAll.getDiscount(), viewAll.getPriceAll() };
	}
	
	public int getItem() { // 수정 필수
		int row = table.getSelectedRow();

		int turnNo = (int) table.getValueAt(row, 0);
		
		if (row == -1) {
			
			// exception을 던지고 그다음 메세지 출력해야돼 인환아
			JOptionPane.showMessageDialog(null, "선택을 안햇자나");
		}
		// 리턴이 문제임 인환아 indexOf메서드는 인덱스가 0인거랑 비교하는 듯?
		return turnNo;

	}
	//
	
	private TableModel getModel() {
		CustomTableModel model = new CustomTableModel(/* getData(), getColumnNames() */);
		return model;
	}

	protected void setAlignAndWidth() {
		// 컬럼내용 정렬
		setTableCellAlign(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5);
		// 컬럼별 너비 조정
		setTableCellWidth(90, 90, 230, 90, 90, 90);
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
