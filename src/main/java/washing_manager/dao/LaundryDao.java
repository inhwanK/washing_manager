package washing_manager.dao;

import java.util.List;

import washing_manager.dto.Laundry;

public interface LaundryDao {
	
	List<Laundry> selectLaundryAll();
	
	Laundry selectLaundryByCode(String lndCode);
	Laundry selectLaundryByName(String lndName);
	int insertLaundry(Laundry laundry);
	int updateLaundry(Laundry laundry);
	int deleteLaundry(String lndCode);
	
}
