package washing_manager.dao;

import java.util.List;

import washing_manager.dto.Consumer;

public interface ConsumerDao {
	
	public List<Consumer> selectConsumerByAll(); // 고객정보 모두 불러오기
	
	public List<Consumer> selectConsumerByName(String conName); //고객이름으로 검색 (동명이인이 있을 수 있음) 따라서 List
	
	public Consumer selectConsumerByPhone(String conPhone);

	public int insertConsumer(Consumer consumer);
}
