package washing_manager.dao;

import java.util.List;

import washing_manager.dto.OrderList;

public interface OrderListDao {
	
	List<OrderList> selectOrderDetailByTurn(int turnNo);
	int insertTurn();
	int insertOrder(OrderList orderList);

	
	// 삭제할 때 필요한 작업.
	int deleteOrderByTurn(int turnNo);
	int deleteTurn(int turnNo);
	int sortTurnNumber();
	int sortOrderNumber();
	
}
