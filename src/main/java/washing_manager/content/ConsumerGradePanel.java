package washing_manager.content;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ConsumerGradePanel extends JPanel {
	private JTextField tfGrade;
	private JTextField tfDiscount;
	private JTextField tfConName;

	/**
	 * Create the panel.
	 */
	public ConsumerGradePanel() {

		initialize();
	}
	private void initialize() {
		setLayout(new GridLayout(0, 2, 10, 2));
		
		JPanel pConName = new JPanel();
		add(pConName);
		pConName.setLayout(new GridLayout(0, 2, 10, 0));
		
		JLabel lblConName = new JLabel("고객명");
		lblConName.setHorizontalAlignment(SwingConstants.CENTER);
		pConName.add(lblConName);
		
		tfConName = new JTextField();
		pConName.add(tfConName);
		tfConName.setColumns(10);
		
		JPanel pSpace = new JPanel();
		add(pSpace);
		pSpace.setLayout(new GridLayout(0, 2, 10, 0));
		
		JPanel pGrade = new JPanel();
		add(pGrade);
		pGrade.setLayout(new GridLayout(0, 2, 10, 0));
		
		JLabel lblGrade = new JLabel("등급");
		pGrade.add(lblGrade);
		lblGrade.setHorizontalAlignment(SwingConstants.CENTER);
		
		tfGrade = new JTextField();
		pGrade.add(tfGrade);
		tfGrade.setColumns(10);
		
		JPanel pDisc = new JPanel();
		add(pDisc);
		pDisc.setLayout(new GridLayout(1, 2, 10, 0));
		
		JLabel lblDiscount = new JLabel("할인율");
		pDisc.add(lblDiscount);
		lblDiscount.setHorizontalAlignment(SwingConstants.CENTER);
		
		tfDiscount = new JTextField();
		pDisc.add(tfDiscount);
		tfDiscount.setEditable(false);
		tfDiscount.setColumns(10);
	}

}
