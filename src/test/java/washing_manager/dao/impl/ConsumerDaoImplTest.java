package washing_manager.dao.impl;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import washing_manager.dto.Consumer;

public class ConsumerDaoImplTest {
	private ConsumerDaoImpl dao = ConsumerDaoImpl.getInstance();
	
	@Test
	public void testSelectConsumerByAll() {
			System.out.println("testSelectConsumerByAll()");
			List<Consumer> res = dao.selectConsumerByAll();
			System.out.println(res);
			Assert.assertNotNull(res);
	}

}
