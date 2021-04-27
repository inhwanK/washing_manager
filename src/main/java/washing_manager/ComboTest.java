package washing_manager;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import washing_manager.dao.impl.LaundryDaoImpl;
import washing_manager.dto.Laundry;

import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class ComboTest extends JFrame {
	private LaundryDaoImpl dao = LaundryDaoImpl.getInstance();
	
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComboTest frame = new ComboTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ComboTest() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JComboBox comboBox = new JComboBox();
		List<Laundry> list = dao.selectLaundryAll();
		comboBox.addItem("세탁물명");
		for(int i =0 ; i < list.size(); i++) {
			comboBox.addItem(list.get(i).getLndName());
		}
		contentPane.add(comboBox, BorderLayout.CENTER);
	}

}
