package washing_manager.dao.impl;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import washing_manager.dto.Laundry;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LaundryDaoImplTest {
	private LaundryDaoImpl dao = LaundryDaoImpl.getInstance();
	
	@Test
	public void test05SelectLaundryAll() {
		System.out.println("testSelectLaundryAll()");
		List<Laundry> res = dao.selectLaundryAll();
		Assert.assertNotNull(res);
	}

	@Test
	public void test03SelectLaundryByCode() {
		System.out.println("testSelectLaundryByCode()");
		Laundry res = dao.selectLaundryByCode("ZZZ");
		System.out.println(res);
		Assert.assertNotNull(res);
	}

	@Test
	public void test01InsertLaundry() {
		System.out.println("test01InsertLaundry()");
		int res = dao.insertLaundry(new Laundry("ZZZ","웨딩드레스", 100000));
		Assert.assertEquals(1, res);
	}

	@Test
	public void test02UpdateLaundry() {
		System.out.println("test02UpdateLaundry()");
		int res = dao.updateLaundry(new Laundry("ZZZ","웨딩", 150000));
		Assert.assertEquals(1, res);
	}

	@Test
	public void test04DeleteLaundry() {
		System.out.println("testSelectLaundryByCode()");
		int res = dao.deleteLaundry("ZZZ");
		Assert.assertEquals(1, res);
	}

}
