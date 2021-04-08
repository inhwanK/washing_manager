package washing_manager.dao.impl;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import washing_manager.dto.Consumer;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ConsumerDaoImplTest {
	private ConsumerDaoImpl dao = ConsumerDaoImpl.getInstance();

	@Test
	public void test01SelectConsumerByAll() {
		System.out.println("testSelectConsumerByAll()");
		List<Consumer> res = dao.selectConsumerByAll();
		System.out.println(res);
		Assert.assertNotNull(res);
	}

	@Test
	public void test02SelectConsumerByName() {
		System.out.println("test02SelectConsumerByName()");
		String conName = "김인환";
		List<Consumer> res = dao.selectConsumerByName(conName);
		Assert.assertNotNull(res);
	}
}
