package washing_manager.status;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class StatusPanel extends JPanel implements ActionListener{
	private OrderPriceStatusPanel pPrice;
	
	public OrderPriceStatusPanel getpPrice() {
		return pPrice;
	}
	
	public StatusPanel() {

		initialize();
	}
	private void initialize() {
		setLayout(new BorderLayout(0, 0));
		
		pPrice = new OrderPriceStatusPanel();
		add(pPrice, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	public void actionPerformedRenewStatistics(ActionEvent e) { //여기는 모든 통계를 모아서 loadData() 메서드 수행하는 곳.
		pPrice.loadData(); 
	}
}
