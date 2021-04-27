package washing_manager.service;

import java.util.List;

import washing_manager.dao.LaundryDao;
import washing_manager.dao.impl.LaundryDaoImpl;
import washing_manager.dto.Laundry;

public class LaundryService {
	private LaundryDao dao = LaundryDaoImpl.getInstance();
	
	public List<Laundry> showLaundryAll(){
		return dao.selectLaundryAll();
	}

	public Laundry showLaundryByCode(String lndCode){
		return dao.selectLaundryByCode(lndCode);
	}
	public Laundry showLaundryByName(String lndName){
		return dao.selectLaundryByName(lndName);
	}
	public void AddLaundry(Laundry laundry){
		dao.insertLaundry(laundry);
	}
	public void modifyLaundry(Laundry laundry){
		dao.updateLaundry(laundry);
	}
	public void removeLaundry(String lndCode) {
		dao.deleteLaundry(lndCode);
	}

}
