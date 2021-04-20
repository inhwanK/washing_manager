package washing_manager.dao.impl;



import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import washing_manager.dto.OrderList;

public class OrderListDaoImplTest {
	private OrderListDaoImpl dao = OrderListDaoImpl.getInstance();
	
	@Test
	public void testSelectOrderListByTurn() {
		System.out.println("testSelectOrderListByTurn()");
		List<OrderList> res = dao.selectOrderListByTurn();
		Assert.assertNotNull(res);
	}

	@Test
	public void testSelectOrderListByPrice() {
		fail("Not yet implemented");
	}

}
