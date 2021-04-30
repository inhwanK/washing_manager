package washing_manager.service;

import java.util.List;

import washing_manager.dao.OrderViewDao;
import washing_manager.dao.impl.OrderViewDaoImpl;
import washing_manager.dto.ViewAll;

public class OrderViewService {

	private OrderViewDao dao = OrderViewDaoImpl.getInstance();

	public List<ViewAll> showOrderViewAll() {
		return dao.selectOrderListViewAll();
	}

	public List<ViewAll> showOrderViewByPrice() {
		return dao.selectOrderListViewByPrice();
	}
	
	public int showSumOrderTotalPrice() {
		return dao.selectSumOrderPrice();
	}
	
	public ViewAll showOrderByTunr(int turnNo) {
		return dao.selectOrderListByturn(turnNo);
	}
}
