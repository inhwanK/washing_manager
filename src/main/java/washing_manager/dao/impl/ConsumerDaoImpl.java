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
import washing_manager.dto.GradeDc;

public class ConsumerDaoImpl implements ConsumerDao {
	private static final ConsumerDaoImpl instance = new ConsumerDaoImpl();

	private ConsumerDaoImpl() {
	}

	public static ConsumerDaoImpl getInstance() {
		return instance;
	}

	public Consumer getConsumer(ResultSet rs) throws SQLException {
		String conName = rs.getString("conname");
		GradeDc conGrade = new GradeDc(rs.getString("congrade"));
		String conPhone = rs.getString("conphone");
		return new Consumer(conName, conGrade, conPhone);
	}

	// 전체 검색. 초기에 떠있는 거임.
	@Override
	public List<Consumer> selectConsumerByAll() {
		String sql = "select conname, congrade, conphone from consumer;";
		try (Connection con = WashingJdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				List<Consumer> listCon = new ArrayList<>();
				do {
					listCon.add(getConsumer(rs));
				} while (rs.next());
				return listCon;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 이름으로 검색
	@Override
	public List<Consumer> selectConsumerByName(String conName) {
		String sql = "select conname, congrade, conphone from consumer where conname like ?;";
		try (Connection con = WashingJdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, conName);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				List<Consumer> listEqualName = new ArrayList<>();
				do {
					listEqualName.add(getConsumer(rs));
				} while (rs.next());
				return listEqualName;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Consumer selectConsumerByPhone(String conPhone) {
		String sql = "select conname, congrade, conphone from consumer where conphone = ?;";
		try(Connection con = WashingJdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, conPhone);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				return getConsumer(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertConsumer(Consumer consumer) {
		String sql ="insert into consumer(conname, congrade, conphone) values(?, ?, ?);";
		try(Connection con = WashingJdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, consumer.getConName());
			pstmt.setString(2, consumer.getConGrade().getGrade());
			pstmt.setString(3, consumer.getConPhone());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
