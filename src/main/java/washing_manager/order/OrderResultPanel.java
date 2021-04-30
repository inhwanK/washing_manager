package washing_manager.order;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;

import washing_manager.dto.GradeDc;
import washing_manager.service.GradeDcService;

import java.awt.Font;

@SuppressWarnings("serial")
public class OrderResultPanel extends JPanel implements ActionListener {
	private JTextField tfTotalOrdPrice;
	private JTextField tfDisOrdPrice;
	private OrderPanel orderPanel;
	private GradeDcService gradeService = new GradeDcService();

	public void setOrderPanel(OrderPanel orderPanel) {
		this.orderPanel = orderPanel;
	}

	public JTextField getTfTotalOrdPrice() {
		return tfTotalOrdPrice;
	}

	public JTextField getTfDisOrdPrice() {
		return tfDisOrdPrice;
	}

	public OrderResultPanel() {

		initialize();
	}

	private void initialize() {
		setLayout(new GridLayout(0, 4, 0, 0));

		JLabel lblTotalOrdPrice = new JLabel("총주문금액");
		lblTotalOrdPrice.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 15));
		lblTotalOrdPrice.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblTotalOrdPrice);

		tfTotalOrdPrice = new JTextField();
		tfTotalOrdPrice.setFont(new Font("굴림", Font.BOLD, 20));
		tfTotalOrdPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		add(tfTotalOrdPrice);
		tfTotalOrdPrice.setColumns(10);

		JLabel lblDisOrdPrice = new JLabel("할인적용금액");
		lblDisOrdPrice.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 15));
		lblDisOrdPrice.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblDisOrdPrice);

		tfDisOrdPrice = new JTextField();
		tfDisOrdPrice.setFont(new Font("굴림", Font.BOLD, 20));
		tfDisOrdPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		add(tfDisOrdPrice);
		tfDisOrdPrice.setColumns(10);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	public void actionPerformedSetResult(ChangeEvent e) {
		int itemCount = orderPanel.getpOrderItem().getComponentCount();
		int totalPrice = 0;
		DecimalFormat df = new DecimalFormat();
		for (int i = 0; i < itemCount; i++) {
			OrderItemPanel item = ((OrderItemPanel) orderPanel.getpOrderItem().getComponent(i));

			totalPrice = totalPrice + item.getPriceByLnd();

		}

		System.out.println(totalPrice);
		orderPanel.getpResult().getTfTotalOrdPrice().setText(df.format(totalPrice) + "");
		String a = (String) orderPanel.getpConInfo().getCbConGrade().getSelectedItem();
		GradeDc grade = gradeService.showGradeDcByGrade(a);
		try {
		float dc = grade.getDiscount();
		
		int disPrice = (int) (totalPrice - (totalPrice * dc));
		orderPanel.getpResult().getTfDisOrdPrice().setText(df.format(disPrice) + "");
		}catch(NullPointerException e1) {
			System.out.println("고객이 선택 되지 않아서 등급객체도 생성이 안됨.");
			JOptionPane.showMessageDialog(null, "고객 정보를 입력하세요.");
		}

	}
}
