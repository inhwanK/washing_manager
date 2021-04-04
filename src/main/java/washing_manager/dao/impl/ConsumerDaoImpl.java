package washing_manager.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import washing_manager.conn.WashingJdbcUtil;
import washing_manager.dao.ConsumerDao;
import washing_manager.dto.Consumer;

public class ConsumerDaoImpl implements ConsumerDao{
	private static final ConsumerDaoImpl instance = new ConsumerDaoImpl();
	
	private ConsumerDaoImpl() {}
	
	public static ConsumerDaoImpl getInstance() {
		return instance;
	}

	public Consumer getConsumer(ResultSet rs) throws SQLException {
		String conPhone = rs.getString("conphone");
		String conName = rs.getString("conname");
		String conGrade = rs.getString("congrade");
		return new Consumer(conPhone, conName, conGrade);
	}
	
	@Override
	public List<Consumer> selectConsumerByAll() {
		String sql ="select * from consumer;";
		try(Connection con = WashingJdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			if(rs.next()) {
				List<Consumer> listCon = new ArrayList<>();
				do {
					listCon.add(getConsumer(rs));
				}while(rs.next());
				return listCon;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Consumer> selectConsumerByName() {
		// TODO Auto-generated method stub
		return null;
	}
	

}