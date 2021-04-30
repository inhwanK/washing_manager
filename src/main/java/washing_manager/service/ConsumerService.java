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
	
	public List<Consumer> selectConsumersByName(String conName){
		return dao.selectConsumerByName(conName);
	}
	
	public Consumer showConsumerByPhone(String conPhone) {
		return dao.selectConsumerByPhone(conPhone);
	}
	
	public void addConsumer(Consumer consumer) {
		dao.insertConsumer(consumer);
	}
}
