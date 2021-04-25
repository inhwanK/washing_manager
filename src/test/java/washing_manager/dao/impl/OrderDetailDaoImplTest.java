package washing_manager.dao.impl;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import washing_manager.dto.OrderList;

public class OrderDetailDaoImplTest {
	private OrderDetailDaoImpl dao = OrderDetailDaoImpl.getInstance();
	
	@Test
	public void testSelectOrderDetailByTurn() {
		System.out.println("testSelectOrderDetailByTurn()");
		List<OrderList> res = dao.selectOrderDetailByTurn(3);
		Assert.assertNotNull(res);
	}

}
