package washing_manager.content;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsumerGradePanel extends JPanel implements ActionListener {
	private JTextField tfGrade;
	private JTextField tfDiscount;
	private JTextField textField;
	private JButton btnSelect;

	/**
	 * Create the panel.
	 */
	public ConsumerGradePanel() {
		initialize();
	}
	
	private void initialize() {
		setBorder(new LineBorder(new Color(0, 0, 0), 0));
		setLayout(new GridLayout(2, 1, 10, 10));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 10, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 10, 0));
		
		JLabel label = new JLabel("고객명");
		label.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		label.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 12));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(label);
		
		textField = new JTextField();
		textField.setBorder(new LineBorder(new Color(0, 0, 0)));
		textField.setColumns(10);
		panel_2.add(textField);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnSelect = new JButton("검색");
		btnSelect.addActionListener(this);
		btnSelect.setMinimumSize(new Dimension(0, 0));
		btnSelect.setMaximumSize(new Dimension(100, 100));
		btnSelect.setPreferredSize(new Dimension(100, 25));
		btnSelect.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_3.add(btnSelect);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		add(panel);
		panel.setLayout(new GridLayout(0, 2, 10, 0));
		
		JPanel pGrade = new JPanel();
		pGrade.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panel.add(pGrade);
		pGrade.setLayout(new GridLayout(0, 2, 10, 0));
		
		JLabel lblGrade = new JLabel("등급");
		lblGrade.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pGrade.add(lblGrade);
		lblGrade.setHorizontalAlignment(SwingConstants.CENTER);
		
		tfGrade = new JTextField();
		tfGrade.setBorder(new LineBorder(Color.BLACK));
		pGrade.add(tfGrade);
		tfGrade.setColumns(10);
		
		JPanel pDisc = new JPanel();
		pDisc.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panel.add(pDisc);
		pDisc.setLayout(new GridLayout(1, 2, 10, 0));
		
		JLabel lblDiscount = new JLabel("할인율");
		lblDiscount.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pDisc.add(lblDiscount);
		lblDiscount.setHorizontalAlignment(SwingConstants.CENTER);
		
		tfDiscount = new JTextField();
		tfDiscount.setBorder(new LineBorder(Color.BLACK));
		pDisc.add(tfDiscount);
		tfDiscount.setEditable(false);
		tfDiscount.setColumns(10);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSelect) {
			actionPerformedBtnSelect(e);
		}
	}
	protected void actionPerformedBtnSelect(ActionEvent e) {
		
	}
}
