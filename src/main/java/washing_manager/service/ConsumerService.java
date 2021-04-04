package washing_manager.service;

import java.util.List;

import washing_manager.dao.ConsumerDao;
import washing_manager.dao.impl.ConsumerDaoImpl;
import washing_manager.dto.Consumer;

public class ConsumerService {
	private ConsumerDao dao = ConsumerDaoImpl.getInstance();
	
	public List<Consumer> showConsumers(){
		return dao.selectConsumerByAll();
	}
}
