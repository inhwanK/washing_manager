package washing_manager.content;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;

public class SearchPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public SearchPanel() {

		initialize();
	}
	private void initialize() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(2, 1, 0, 0));
		
		ConsumerSearchPanel panel_1 = new ConsumerSearchPanel();
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EmptyBorder(3, 3, 3, 3));
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnNewButton = new JButton("검색");
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 16));
		panel_2.add(btnNewButton);
		
		ConsumerListPanel panel_3 = new ConsumerListPanel();
		add(panel_3, BorderLayout.CENTER);
		
		JPanel panel_4 = new JPanel();
		add(panel_4, BorderLayout.SOUTH);
		
		JLabel lblNewLabel = new JLabel("팝업으로 주문 메뉴, 고객 정보 수정, 자세히 보기, ");
		panel_4.add(lblNewLabel);
	}

}
