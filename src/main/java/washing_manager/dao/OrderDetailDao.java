package washing_manager.dao;

import java.util.List;

import washing_manager.dto.OrderList;

public interface OrderDetailDao {

	List<OrderList> selectOrderDetailByTurn(int turnNo);
}
