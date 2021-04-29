package washing_manager.content;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;

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
	
	public JTextField getTfConPhone() {
		return tfConPhone;
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
		lblConName.setFont(new Font("굴림", Font.BOLD, 15));
		lblConName.setHorizontalAlignment(SwingConstants.CENTER);
		pConGrade.add(lblConName);
		
		JLabel lblConGrade = new JLabel("등급");
		lblConGrade.setFont(new Font("굴림", Font.BOLD, 15));
		lblConGrade.setHorizontalAlignment(SwingConstants.CENTER);
		pConGrade.add(lblConGrade);
		
		tfConName = new JTextField();
		tfConName.setFont(new Font("굴림", Font.PLAIN, 18));
		tfConName.setHorizontalAlignment(SwingConstants.CENTER);
		pConGrade.add(tfConName);
		tfConName.setColumns(10);
		
		tfConGrade = new JTextField();
		tfConGrade.setFont(new Font("굴림", Font.PLAIN, 18));
		tfConGrade.setHorizontalAlignment(SwingConstants.CENTER);
		pConGrade.add(tfConGrade);
		tfConGrade.setColumns(10);
		
		JPanel pConPhone = new JPanel();
		add(pConPhone);
		pConPhone.setLayout(new GridLayout(2, 2, 0, 0));
		
		JLabel lblConPhone = new JLabel("휴대폰 번호");
		lblConPhone.setFont(new Font("굴림", Font.BOLD, 15));
		lblConPhone.setHorizontalAlignment(SwingConstants.CENTER);
		pConPhone.add(lblConPhone);
		
		tfConPhone = new JTextField();
		tfConPhone.setFont(new Font("굴림", Font.PLAIN, 18));
		tfConPhone.setHorizontalAlignment(SwingConstants.CENTER);
		pConPhone.add(tfConPhone);
		tfConPhone.setColumns(10);
		
	}
}
