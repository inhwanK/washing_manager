package washing_manager.content;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class ChoiceConsumerPanel extends JPanel {
	private JTextField tfConName;
	private JTextField tfConGrade;
	private JTextField tfConPhone;
	
	public void setTfAll(String conName, String grade, String conPhone) {
		tfConName.setText(conName);
		tfConGrade.setText(grade);
		tfConPhone.setText(conPhone);
	}
	
	public ChoiceConsumerPanel() {

		initialize();
	}

	private void initialize() {
		setLayout(new GridLayout(0, 2, 10, 0));
		
		JPanel pConGrade = new JPanel();
		add(pConGrade);
		pConGrade.setLayout(new GridLayout(2, 2, 10, 0));
		
		JLabel lblConName = new JLabel("고객명");
		pConGrade.add(lblConName);
		
		JLabel lblConGrade = new JLabel("등급");
		pConGrade.add(lblConGrade);
		
		tfConName = new JTextField();
		tfConName.setHorizontalAlignment(SwingConstants.CENTER);
		pConGrade.add(tfConName);
		tfConName.setColumns(10);
		
		tfConGrade = new JTextField();
		tfConGrade.setHorizontalAlignment(SwingConstants.CENTER);
		pConGrade.add(tfConGrade);
		tfConGrade.setColumns(10);
		
		JPanel pConPhone = new JPanel();
		add(pConPhone);
		pConPhone.setLayout(new GridLayout(2, 2, 0, 0));
		
		JLabel lblConPhone = new JLabel("휴대폰 번호");
		pConPhone.add(lblConPhone);
		
		tfConPhone = new JTextField();
		tfConPhone.setHorizontalAlignment(SwingConstants.CENTER);
		pConPhone.add(tfConPhone);
		tfConPhone.setColumns(10);
		
		
	}
}
