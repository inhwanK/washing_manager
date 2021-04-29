package washing_manager.content;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import washing_manager.dto.GradeDc;
import washing_manager.service.GradeDcService;

@SuppressWarnings("serial")
public class ChoiceConsumerPanel extends JPanel implements ActionListener{
	private JTextField tfConName;
//	private JTextField tfConGrade;
	private GradeDcService service = new GradeDcService();
	private JComboBox<String> cbConGrade;
	private JTextField tfConPhone;
	
	public void setConInfoAll(String conName, String grade, String conPhone) {
		tfConName.setText(conName);
		cbConGrade.setSelectedItem(grade);
		tfConPhone.setText(conPhone);

	}
	
	
	public JComboBox<String> getTfConGrade() {
		return cbConGrade;
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
		lblConName.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 18));
		lblConName.setHorizontalAlignment(SwingConstants.CENTER);
		pConGrade.add(lblConName);
		
		JLabel lblConGrade = new JLabel("등급");
		lblConGrade.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 18));
		lblConGrade.setHorizontalAlignment(SwingConstants.CENTER);
		pConGrade.add(lblConGrade);
		
		tfConName = new JTextField();
		tfConName.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		tfConName.setHorizontalAlignment(SwingConstants.CENTER);
		pConGrade.add(tfConName);
		tfConName.setColumns(10);
		
//		tfConGrade = new JTextField();
//		tfConGrade.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
//		tfConGrade.setHorizontalAlignment(SwingConstants.CENTER);
//		pConGrade.add(tfConGrade);
//		tfConGrade.setColumns(10);
		
		cbConGrade = new JComboBox<String>();
		cbConGrade.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		cbConGrade.setBorder(new EmptyBorder(0, 0, 0, 0));
		cbConGrade.setBackground(Color.WHITE);
		cbConGrade.addActionListener(this);
		cbConGrade.setForeground(Color.BLACK);
		//
		List<GradeDc> list = service.showGradeDcAll();
//		cbLnName.addItem("세탁물명");
		for (int i = 0; i < list.size(); i++) {
			cbConGrade.addItem(list.get(i).getGrade());
		}
		pConGrade.add(cbConGrade);
		
		
		
		
		
		
		JPanel pConPhone = new JPanel();
		add(pConPhone);
		pConPhone.setLayout(new GridLayout(2, 2, 0, 0));
		
		JLabel lblConPhone = new JLabel("휴대폰 번호");
		lblConPhone.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 18));
		lblConPhone.setHorizontalAlignment(SwingConstants.CENTER);
		pConPhone.add(lblConPhone);
		
		tfConPhone = new JTextField();
		tfConPhone.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		tfConPhone.setHorizontalAlignment(SwingConstants.CENTER);
		pConPhone.add(tfConPhone);
		tfConPhone.setColumns(10);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
