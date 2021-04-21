package washing_manager.service;

import java.util.List;

import washing_manager.dao.OrderListDao;
import washing_manager.dao.impl.OrderListDaoImpl;
import washing_manager.dto.OrderList;

public class OrderListService {
	private OrderListDao dao = OrderListDaoImpl.getInstance();
	
	public List<OrderList> showOrderListByTurn(){
		return dao.selectOrderListByTurn();
	}
	
	public List<OrderList> showOrderListByPrice(){
		return dao.selectOrderListByPrice();
	}
}
