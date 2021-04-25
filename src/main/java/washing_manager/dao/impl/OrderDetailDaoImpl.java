package washing_manager.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import washing_manager.conn.WashingJdbcUtil;
import washing_manager.dao.OrderDetailDao;
import washing_manager.dto.Laundry;
import washing_manager.dto.OrderList;

public class OrderDetailDaoImpl implements OrderDetailDao {
	private static final OrderDetailDaoImpl instance = new OrderDetailDaoImpl();

	private OrderDetailDaoImpl() {
		
	}

	public static OrderDetailDaoImpl getInstance() {
		return instance;
	}
	
	@Override
	public List<OrderList> selectOrderDetailByTurn(int turnNo) {
		String sql = "select @rownum:=@rownum+1 as 번호,\r\n" + 
				"	   o.lndcode as 제품코드,\r\n" + 
				"	   l.lndname as 제품명,\r\n" + 
				"	   o.lndea as 세탁수량,\r\n" + 
				"	   l.lndprice as 세탁단가,\r\n" + 
				"	   o.lndea * l.lndprice as 세탁물별총가격\r\n" + 
				"  from orderlist o left join laundry l on o.lndcode =l.lndcode , (select @rownum:=0) r \r\n" + 
				"  where o.turn = ?;";
		try (Connection con = WashingJdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, turnNo);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				List<OrderList> listDetail = new ArrayList<>();
				do {
					listDetail.add(getOrderList(rs));
				}while(rs.next());
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
		}catch(SQLException e){
		}
		
		try {
			orderList.setLndCode(new Laundry(rs.getString("제품코드"), rs.getString("제품명"), rs.getInt("세탁단가")));
		}catch(SQLException e){
		}
		
		try {
			orderList.setLndEa(rs.getInt("세탁수량"));
		}catch(SQLException e) {
		}
		
		try {
			orderList.setTotalPrice(rs.getInt("세탁물별총가격"));
		}catch(SQLException e) {
		}
		
		return orderList;
	}

}
