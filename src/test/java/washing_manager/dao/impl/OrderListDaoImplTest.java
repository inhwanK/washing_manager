package washing_manager.dao.impl;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import washing_manager.dto.Consumer;
import washing_manager.dto.Laundry;
import washing_manager.dto.OrderList;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrderListDaoImplTest {
	private OrderListDaoImpl dao = OrderListDaoImpl.getInstance();
	
	@Test
	public void test01InsertTurn() {
		System.out.println("test01InsertTurn()");
		int res = dao.insertTurn();
		Assert.assertEquals(1, res);
	}

	@Test
	public void test02InsertOrder() {
		System.out.println("test02InsertOrder()");
		OrderList orderList = new OrderList(1,new Laundry("AAA"),new Consumer("010-9198-6529"));
		int res = dao.insertOrder(orderList);
		Assert.assertEquals(1, res);
	}

}
