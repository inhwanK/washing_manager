package washing_manager.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import washing_manager.conn.WashingJdbcUtil;
import washing_manager.dao.OrderViewDao;
import washing_manager.dto.ViewAll;

public class OrderViewDaoImpl implements OrderViewDao {
	private static final OrderViewDaoImpl instance = new OrderViewDaoImpl();

	public static OrderViewDaoImpl getInstance() {
		return instance;
	}

	public OrderViewDaoImpl() {
	}

	private ViewAll getOrderView(ResultSet rs) {

		ViewAll v_all = new ViewAll();

//		int turnNo;
//		String conName;
//		String lndNameEa;
//		String priceEa;
//		String conGrade;
//		float discount;
//		int priceAll;
//		String lndCode;
//		String conPhone;
//		String ordNo;
//		Date orderTime;

		try {
			v_all.setTurnNo(rs.getInt("순번"));
		} catch (SQLException e) {
		}

		try {
			v_all.setConName(rs.getString("고객명"));
		} catch (SQLException e) {
		}

		try {
			v_all.setLndNameEa((rs.getString("제품명(세탁수량)")));
		} catch (SQLException e) {
		}

		try {
			v_all.setPriceEa((rs.getString("세탁단가")));
		} catch (SQLException e) {
		}

		try {
			v_all.setConGrade((rs.getString("등급")));
		} catch (SQLException e) {
		}

		try {
			v_all.setDiscount(rs.getInt("할인율"));
		} catch (SQLException e) {
		}

		try {
			v_all.setPriceAll((rs.getInt("세탁가격")));
		} catch (SQLException e) {
		}

		try {
			v_all.setLndCode((rs.getString("세탁물코드")));
		} catch (SQLException e) {
		}

		try {
			v_all.setConPhone((rs.getString("고객번호")));
		} catch (SQLException e) {
		}

		try {
			v_all.setOrdNo((rs.getString("주문번호"))); // int 값 여러개
		} catch (SQLException e) {
		}

		try {
			v_all.setOrderTime((rs.getDate("주문시간")));
		} catch (SQLException e) {
		}

		try {
			v_all.setLndName((rs.getString("제품명"))); // String 값 여러개
		} catch (SQLException e) {
		}

		try {
			v_all.setLndEa((rs.getString("세탁수량"))); // int 값 여러개
		} catch (SQLException e) {
		}

		try {
			v_all.setRank((rs.getInt("순위")));
		} catch (SQLException e) {
		}
//		

		return v_all;
	}

	@Override
	public List<ViewAll> selectOrderListViewAll() { // 세탁 수량이랑 단가는 불필요함.
		String sql = "select * from v_all order by 순번 desc;";
		try (Connection con = WashingJdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				List<ViewAll> list = new ArrayList<>();
				do {
					list.add(getOrderView(rs));
				} while (rs.next());
				return list;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<ViewAll> selectOrderListViewByPrice() { // 세탁 수량이랑 단가는 불필요함.
		String sql = "select (select count(*)+1 from v_all where 세탁가격 > a.세탁가격) as 순위,\r\n"
				+ "		고객명, 제품명, 세탁수량, 세탁단가, 등급, 할인율 , 세탁가격\r\n" + "  from v_all a\r\n" + "  order by 순위 asc;";
		try (Connection con = WashingJdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				List<ViewAll> list = new ArrayList<>();
				do {
					list.add(getOrderView(rs));
				} while (rs.next());
				return list;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public int selectSumOrderPrice() {
		String sql = "select sum(세탁가격) from v_all;";
		try (Connection con = WashingJdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				int sum = rs.getInt("sum(세탁가격)");
				return sum;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
