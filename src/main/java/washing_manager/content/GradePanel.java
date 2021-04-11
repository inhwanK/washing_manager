package washing_manager.content;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import washing_manager.dto.Consumer;

@SuppressWarnings("serial")
public class GradePanel extends JPanel implements ActionListener {
	private JTextField tfGrade;
	private JTextField tfDiscount;

	public GradePanel() {
		initialize();
	}
	
	private void initialize() {
		setBorder(new LineBorder(new Color(192, 192, 192), 0));
		setLayout(new GridLayout(1, 1, 10, 10));
		
		JPanel pGrDc = new JPanel();
		pGrDc.setBorder(new LineBorder(new Color(192, 192, 192), 0));
		add(pGrDc);
		pGrDc.setLayout(new GridLayout(0, 2, 10, 0));
		
		JPanel pGrade = new JPanel();
		pGrade.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		pGrDc.add(pGrade);
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
		pGrDc.add(pDisc);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
