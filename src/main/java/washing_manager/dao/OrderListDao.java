package washing_manager.dao;

import washing_manager.dto.OrderList;
import washing_manager.dto.OrderTurn;

public interface OrderListDao {
	int insertTurn();
	int insertOrder(OrderList orderList);
}
