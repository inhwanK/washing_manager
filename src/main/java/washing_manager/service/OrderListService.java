package washing_manager.service;

import java.util.List;

import washing_manager.dao.OrderListDao;
import washing_manager.dao.impl.OrderListDaoImpl;
import washing_manager.dto.OrderList;

public class OrderListService {
	private OrderListDao dao = OrderListDaoImpl.getInstance();

	public List<OrderList> showOrderDetailByTurn(int turnNo) {
		return dao.selectOrderDetailByTurn(turnNo);
	}

	public void insertTurn() {
		dao.insertTurn();
	}

	public void insertOrderList(OrderList orderList) {
		dao.insertOrder(orderList);
	}

	public void removeOrderByTurn(int turnNo) {
		dao.deleteOrderByTurn(turnNo);
		dao.sortOrderNumber();
	}
	
	public void removeTurn(int turnNo) {
		dao.deleteTurn(turnNo);
		dao.sortTurnNumber();
	}
}
