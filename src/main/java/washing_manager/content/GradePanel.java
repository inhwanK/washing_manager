package washing_manager.content;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GradePanel extends JPanel {
	private JTextField tfGrade;
	private JTextField tfDiscount;

	/**
	 * Create the panel.
	 */
	public GradePanel() {

		initialize();
	}
	private void initialize() {
		setLayout(new GridLayout(0, 2, 10, 10));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(0, 2, 10, 0));
		
		JLabel lblGrade = new JLabel("등급 :");
		lblGrade.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblGrade);
		
		tfGrade = new JTextField();
		panel.add(tfGrade);
		tfGrade.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 10, 0));
		
		JLabel lblDiscount = new JLabel("할인율 :");
		lblDiscount.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(lblDiscount);
		
		tfDiscount = new JTextField();
		tfDiscount.setEditable(false);
		panel_1.add(tfDiscount);
		tfDiscount.setColumns(10);
	}

}
