package washing_manager.dao.impl;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import washing_manager.dto.ViewAll;

public class OrderViewDaoImplTest {
	private OrderViewDaoImpl dao = OrderViewDaoImpl.getInstance();

	@Test
	public void testSelectOrderListViewAll() {
		System.out.println("testSelectOrderListViewAll()");
		List<ViewAll> res = dao.selectOrderListViewAll();
		Assert.assertNotNull(res);
	}

	@Test
	public void testSelectOrderListViewByPrice() {
		System.out.println("testSelectOrderListViewByPrice()");
		List<ViewAll> res = dao.selectOrderListViewAll();
		Assert.assertNotNull(res);
	}

}
