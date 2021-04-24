package washing_manager.dao;

import java.util.List;

import washing_manager.dto.ViewAll;

public interface OrderViewDao {

	List<ViewAll> selectOrderListViewAll();

	List<ViewAll> selectOrderListViewByPrice();
}
