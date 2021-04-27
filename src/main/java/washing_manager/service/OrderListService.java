package washing_manager.service;

import washing_manager.dao.OrderListDao;
import washing_manager.dao.impl.OrderListDaoImpl;
import washing_manager.dto.OrderList;

public class OrderListService {
private OrderListDao dao = OrderListDaoImpl.getInstance();
	
	public int insertTurn(){
		return dao.insertTurn();
	}
	
	public int insertOrderList(OrderList orderList){
		return dao.insertOrder(orderList);
	}
}
