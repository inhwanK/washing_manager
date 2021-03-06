package washing_manager.search;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class ConsumerInputPanel extends JPanel {
	private JTextField tfConsumer;
	
	public JTextField getTfConsumer() {
		return tfConsumer;
	}

	public ConsumerInputPanel() {
		initialize();
	}
	
	private void initialize() {
		setBorder(new LineBorder(new Color(0, 0, 0), 0));
		setLayout(new GridLayout(1, 1, 2, 2));
		
		JPanel pConName = new JPanel();
		pConName.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		add(pConName);
		pConName.setLayout(new GridLayout(0, 1, 10, 0));
		
		JPanel pConname = new JPanel();
		pConname.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		pConName.add(pConname);
		pConname.setLayout(new GridLayout(0, 2, 10, 10));
		
		JLabel lblConsumer = new JLabel("고객명");
		lblConsumer.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 18));
		lblConsumer.setHorizontalAlignment(SwingConstants.CENTER);
		pConname.add(lblConsumer);
		
		tfConsumer = new JTextField();
		tfConsumer.setHorizontalAlignment(SwingConstants.CENTER);
		tfConsumer.setFont(new Font("휴먼모음T", Font.PLAIN, 25));
		tfConsumer.setBorder(new LineBorder(null, 1, true));
		tfConsumer.setColumns(10);
		pConname.add(tfConsumer);
	}

}
