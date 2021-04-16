package washing_manager.content;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JTextField;

public class OrderItemPanel extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public OrderItemPanel() {

		initialize();
	}
	private void initialize() {
		setLayout(new GridLayout(1, 0, 0, 0));
		
		textField = new JTextField();
		textField.setText("이게머냐고임마");
		add(textField);
		textField.setColumns(10);
	}

}
