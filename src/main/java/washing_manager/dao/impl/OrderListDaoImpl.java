package washing_manager.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import washing_manager.conn.WashingJdbcUtil;
import washing_manager.dao.OrderListDao;
import washing_manager.dto.Laundry;
import washing_manager.dto.OrderList;

public class OrderListDaoImpl implements OrderListDao {
	private static OrderListDaoImpl instance = new OrderListDaoImpl();

	public static OrderListDaoImpl getInstance() {
		return instance;
	}

	// orderlist 넣기 전 turn이 먼저 들어가야하기에 수행
	@Override
	public int insertTurn() {
		String sql = "insert into orderturn(orderdate) values (now());";
		try (Connection con = WashingJdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {

			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	// orderlist 넣는 작업.
	@Override
	public int insertOrder(OrderList orderList) {
		String sql = "insert into orderlist(lndea, lndcode , conphone, turn) \r\n"
				+ "values(?, ?, ?, (select turn from orderturn order by turn desc limit 1));";
		try (Connection con = WashingJdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
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

	@Override
	public List<OrderList> selectOrderDetailByTurn(int turnNo) {
		String sql = "select @rownum:=@rownum+1 as 번호,\r\n" + " 	   o.ordno as 주문번호,\r\n"
				+ "	   o.lndcode as 제품코드,\r\n" + "	   l.lndname as 제품명,\r\n" + "	   o.lndea as 세탁수량,\r\n"
				+ "	   l.lndprice as 세탁단가,\r\n" + "	   o.lndea * l.lndprice as 세탁물별총가격\r\n"
				+ "  from orderlist o left join laundry l on o.lndcode =l.lndcode , (select @rownum:=0) r \r\n"
				+ "  where o.turn = ?;";
		try (Connection con = WashingJdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, turnNo);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				List<OrderList> listDetail = new ArrayList<>();
				do {
					listDetail.add(getOrderList(rs));
				} while (rs.next());
				return listDetail;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private OrderList getOrderList(ResultSet rs) {
		OrderList orderList = new OrderList();

		try {
			orderList.setDetailNo(rs.getInt("번호"));
		} catch (SQLException e) {
		}
		try {
			orderList.setOrdNo(rs.getInt("주문번호"));
		} catch (SQLException e) {
		}

		try {
			orderList.setLndCode(new Laundry(rs.getString("제품코드"), rs.getString("제품명"), rs.getInt("세탁단가")));
		} catch (SQLException e) {
		}

		try {
			orderList.setLndEa(rs.getInt("세탁수량"));
		} catch (SQLException e) {
		}

		try {
			orderList.setTotalPrice(rs.getInt("세탁물별총가격"));
		} catch (SQLException e) {
		}

		return orderList;
	}

	@Override
	public int deleteOrderByTurn(int turnNo) {
		String sql = "delete\r\n" + 
					"  from orderlist\r\n" + 
					" where turn = ?;";
		try (Connection con = WashingJdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, turnNo);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int sortTurnNumber() {
		String sql = "ALTER TABLE orderturn AUTO_INCREMENT = 1;";
		try (Connection con = WashingJdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteTurn(int turnNo) {
		String sql = "delete\r\n" + 
				"  from orderturn\r\n" + 
				" where turn = ?;";
		try (Connection con = WashingJdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, turnNo);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int sortOrderNumber() {
		String sql ="ALTER TABLE orderturn AUTO_INCREMENT = 1;";
		try(Connection con = WashingJdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}

}
