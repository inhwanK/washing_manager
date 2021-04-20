package washing_manager.dao;

import java.util.List;

import washing_manager.dto.OrderList;

public interface OrderListDao {
	
	
	
	List<OrderList> selectOrderListByTurn();
	List<OrderList> selectOrderListByPrice();
}
