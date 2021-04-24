package washing_manager.service;

import java.util.List;

import washing_manager.dao.OrderDetailDao;
import washing_manager.dao.impl.OrderDetailDaoImpl;
import washing_manager.dto.OrderList;

public class OrderDetailService {
	private OrderDetailDao dao = OrderDetailDaoImpl.getInstance();

	public List<OrderList> showOrderDetailByTurn(int turnNo){
		return dao.selectOrderDetailByTurn(turnNo);
	}
}
