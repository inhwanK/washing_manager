package washing_manager.content;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class LaundryPanel extends JPanel {
	private JTextField tfLnName;
	private JTextField tfLnprice;
	private JTextField tfLncode;

	
	public LaundryPanel() {

		initialize();
	}
	private void initialize() {
		setLayout(new GridLayout(0, 2, 10, 0));
		
		JPanel pLncode = new JPanel();
		add(pLncode);
		pLncode.setLayout(new GridLayout(2, 1, 10, 2));
		
		JPanel panel = new JPanel();
		pLncode.add(panel);
		panel.setLayout(new GridLayout(0, 2, 10, 10));
		
		JLabel lblLncode = new JLabel("세탁물코드");
		lblLncode.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblLncode.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblLncode);
		
		tfLncode = new JTextField();
		tfLncode.setBorder(new LineBorder(Color.BLACK));
		panel.add(tfLncode);
		tfLncode.setColumns(10);
		
		JPanel pSpace = new JPanel();
		pLncode.add(pSpace);
		
		JPanel pRight = new JPanel();
		add(pRight);
		pRight.setLayout(new GridLayout(2, 0, 0, 2));
		
		JPanel pLnName = new JPanel();
		pRight.add(pLnName);
		pLnName.setLayout(new GridLayout(0, 2, 10, 0));
		
		JLabel lblLnName = new JLabel("제품명");
		lblLnName.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblLnName.setHorizontalAlignment(SwingConstants.CENTER);
		pLnName.add(lblLnName);
		
		tfLnName = new JTextField();
		tfLnName.setBorder(new LineBorder(Color.BLACK));
		tfLnName.setEditable(false);
		pLnName.add(tfLnName);
		tfLnName.setColumns(10);
		
		JPanel pLnprice = new JPanel();
		pRight.add(pLnprice);
		pLnprice.setLayout(new GridLayout(0, 2, 10, 0));
		
		JLabel lblLnprice = new JLabel("세탁단가");
		lblLnprice.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblLnprice.setHorizontalAlignment(SwingConstants.CENTER);
		pLnprice.add(lblLnprice);
		
		tfLnprice = new JTextField();
		tfLnprice.setBorder(new LineBorder(Color.BLACK));
		tfLnprice.setEditable(false);
		pLnprice.add(tfLnprice);
		tfLnprice.setColumns(10);
	}

}
