package washing_manager.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import washing_manager.conn.WashingJdbcUtil;
import washing_manager.dao.OrderListDao;
import washing_manager.dto.Consumer;
import washing_manager.dto.GradeDc;
import washing_manager.dto.Laundry;
import washing_manager.dto.OrderList;

public class OrderListDaoImpl implements OrderListDao {
	private static final OrderListDaoImpl instance = new OrderListDaoImpl();

	public static OrderListDaoImpl getInstance() {
		return instance;
	}

	public OrderListDaoImpl() {
	}

	@Override
	public List<OrderList> selectOrderListByTurn() {
		String sql = "select * from v_turnno;";
		try (Connection con = WashingJdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				List<OrderList> list = new ArrayList<>();
				do {
					list.add(getOrderList(rs));
				} while (rs.next());
				return list;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	private OrderList getOrderList(ResultSet rs) {

		int ordNo = 0;
		int lndEa = 0;
		String lndCode = null;
		String lndName = null;
		int lndPrice = 0;
		String conName = null;
		String conPhone = null;
		float discount = 0;
		String grade = null;
		
		try {
			ordNo = rs.getInt("순번");
		} catch (SQLException e) {}

		
		try {
			lndEa = rs.getInt("세탁수량");
		} catch (SQLException e) {}

		
		try {
			lndCode = rs.getString("세탁물코드");
		} catch (SQLException e) {}
		
		try {
			lndName = rs.getString("제품명");
		} catch (SQLException e) {}
		
		try {
			lndPrice = rs.getInt("세탁단가");
		} catch (SQLException e) {}
		
		
		try {
			conName = rs.getString("고객명");
		} catch (SQLException e) {}
		
		
		try {
			conPhone = rs.getString("고객번호");
		} catch (SQLException e) {}

		
		try {
			discount = rs.getFloat("할인율");
		} catch (SQLException e) {}
		
		try {
			grade = rs.getString("등급");
		} catch (SQLException e) {}

		GradeDc conGrade = new GradeDc(grade, discount);

		return new OrderList(ordNo, lndEa, new Laundry(lndCode, lndName, lndPrice),
				new Consumer(conName, conGrade, conPhone));
	}

	@Override
	public List<OrderList> selectOrderListByPrice() {
		// TODO Auto-generated method stub
		return null;
	}

}
