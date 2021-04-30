package washing_manager.detail;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class OrderConDetailePanel extends JPanel {
	private JTextField tfConName;
	private JTextField tfConGrade;
	private JTextField tfConPhone;
	
	public JTextField getTfConGrade() {
		return tfConGrade;
	}


	public JTextField getTfConName() {
		return tfConName;
	}


	public JTextField getTfConPhone() {
		return tfConPhone;
	}


	public OrderConDetailePanel() {

		initialize();
	}
	private void initialize() {
		setBorder(new EmptyBorder(0, 10, 0, 10));
		setLayout(new GridLayout(3, 2, 5, 5));
		
		JLabel lblConName = new JLabel("이름");
		lblConName.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblConName);
		
		tfConName = new JTextField();
		tfConName.setEditable(false);
		add(tfConName);
		tfConName.setColumns(10);
		
		JLabel lblConGrade = new JLabel("등급");
		lblConGrade.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblConGrade);
		
		tfConGrade = new JTextField();
		tfConGrade.setEditable(false);
		add(tfConGrade);
		tfConGrade.setColumns(10);
		
		JLabel lblConPhone = new JLabel("번호");
		lblConPhone.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblConPhone);
		
		tfConPhone = new JTextField();
		tfConPhone.setEditable(false);
		add(tfConPhone);
		tfConPhone.setColumns(10);
	}

}
