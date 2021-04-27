package washing_manager.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import washing_manager.conn.WashingJdbcUtil;
import washing_manager.dao.OrderListDao;
import washing_manager.dto.OrderList;

public class OrderListDaoImpl implements OrderListDao {
	private static OrderListDaoImpl instance = new OrderListDaoImpl();
	
	public static OrderListDaoImpl getInstance() {
		return instance;
	}
	
	@Override
	public int insertTurn() {
		String sql = "insert into orderturn(orderdate) values (now());";
		try(Connection con = WashingJdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public int insertOrder(OrderList orderList) {
		String sql = "insert into orderlist(lndea, lndcode , conphone, turn) \r\n" + 
				"values(?, ?, ?, (select turn from orderturn order by turn desc limit 1));";
		try(Connection con = WashingJdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, orderList.getLndEa());
			pstmt.setString(2, orderList.getLndCode().getLndCode());
			pstmt.setString(3, orderList.getConPhone().getConPhone());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
