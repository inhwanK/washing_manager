package washing_manager.content;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import washing_manager.dto.Consumer;

public class ConsumerListPanel extends JPanel {
	private JTable table;
	private String[] columnNames;
	private String[][] data;
	private List<Consumer> list;// dto만들어야함.
//	private w

//	public void initList() {
//		
//	}
	
	
	public void setList() {
		Object[][] data = new Object[list.size()][];
		for (int i = 0; i < data.length; i++) {
			data[i] = toArray(list.get(i));
		}

		CustomTableModel model = new CustomTableModel(data, getColumnNames());
		table.setModel(model);

		RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
		table.setRowSorter(sorter);

//		setAlignAndWidth(); 데이터 정렬
	}

	private Object[] getColumnNames() {
		return new String[] { "고객번호", "고객명", "고객등급" };
	}

	private Object[] toArray(Consumer consumer) {
		return new Object[] {consumer.getConPhone(),consumer.getConName(),consumer.getConGrade()};
	}

	public ConsumerListPanel() {
		initialize();
	}

	private void initialize() {
		setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		scrollPane.add(table);
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
