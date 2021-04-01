package washing_manager.content;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ConsumerPanel extends JPanel {
	private JTextField tfConName;

	/**
	 * Create the panel.
	 */
	public ConsumerPanel() {

		initialize();
	}
	private void initialize() {
		setLayout(new GridLayout(0, 1, 10, 0));
		
		JPanel pConName = new JPanel();
		add(pConName);
		pConName.setLayout(new GridLayout(0, 2, 10, 0));
		
		JLabel lblConName = new JLabel("고객명 :");
		lblConName.setHorizontalAlignment(SwingConstants.RIGHT);
		pConName.add(lblConName);
		
		tfConName = new JTextField();
		pConName.add(tfConName);
		tfConName.setColumns(10);
	}

}
