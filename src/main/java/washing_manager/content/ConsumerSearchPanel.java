package washing_manager.content;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class ConsumerSearchPanel extends JPanel implements ActionListener {
	private JTextField tfConsumer;
	
	public JTextField getTfConsumer() {
		return tfConsumer;
	}

	public ConsumerSearchPanel() {
		initialize();
	}
	
	private void initialize() {
		setBorder(new LineBorder(new Color(0, 0, 0), 0));
		setLayout(new GridLayout(1, 1, 10, 10));
		
		JPanel pConName = new JPanel();
		pConName.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		add(pConName);
		pConName.setLayout(new GridLayout(0, 1, 10, 0));
		
		JPanel pConname = new JPanel();
		pConname.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		pConName.add(pConname);
		pConname.setLayout(new GridLayout(0, 2, 10, 0));
		
		JLabel lblConsumer = new JLabel("고객명");
		lblConsumer.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblConsumer.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 12));
		lblConsumer.setHorizontalAlignment(SwingConstants.CENTER);
		pConname.add(lblConsumer);
		
		tfConsumer = new JTextField();
		tfConsumer.setBorder(new LineBorder(new Color(0, 0, 0)));
		tfConsumer.setColumns(10);
		pConname.add(tfConsumer);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}