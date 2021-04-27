package washing_manager.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import washing_manager.conn.WashingJdbcUtil;
import washing_manager.dao.LaundryDao;
import washing_manager.dto.Laundry;

public class LaundryDaoImpl implements LaundryDao {
	private static LaundryDaoImpl instance = new LaundryDaoImpl();
	
	public static LaundryDaoImpl getInstance() {
		return instance;
	}
	
	public LaundryDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Laundry> selectLaundryAll() {
		String sql = "SELECT lndcode, lndname, lndprice\r\n" + 
				"FROM laundry;";
		try(Connection con = WashingJdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			if(rs.next()) {
				List<Laundry> list = new ArrayList<>();
				do {
					list.add(getLaundry(rs));
				}while(rs.next());
				return list;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private Laundry getLaundry(ResultSet rs) {
		Laundry laundry = new Laundry();
		
		try {
			laundry.setLndCode(rs.getString("lndcode"));
		} catch (SQLException e) {}
		
		try {
			laundry.setLndName(rs.getString("lndname"));
		} catch (SQLException e) {}
		try {
			laundry.setLndPrice((rs.getInt("lndprice")));
		} catch (SQLException e) {}
		
		return laundry;
	}

	@Override
	public Laundry selectLaundryByCode(String lndCode) {
		String sql ="SELECT lndcode, lndname, lndprice\r\n" + 
				"FROM laundry where lndcode = ?;";
		try(Connection con = WashingJdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, lndCode);
			try(ResultSet rs = pstmt.executeQuery()){
				if (rs.next()) {
					return getLaundry(rs);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertLaundry(Laundry laundry) {
		String sql = "insert into laundry(lndcode, lndname, lndprice) values(?, ?, ?);";
		try(Connection con = WashingJdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, laundry.getLndCode());
			pstmt.setString(2, laundry.getLndName());
			pstmt.setInt(3, laundry.getLndPrice());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int updateLaundry(Laundry laundry) {
		String sql = "update laundry set lndname = ?, lndprice = ? where lndcode = ?;";
		try(Connection con = WashingJdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, laundry.getLndName());
			pstmt.setInt(2, laundry.getLndPrice());
			pstmt.setString(3, laundry.getLndCode());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteLaundry(String lndCode) {
		String sql = "delete from laundry where lndcode = ?;";
		try(Connection con = WashingJdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, lndCode);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Laundry selectLaundryByName(String lndName) {
		String sql ="SELECT lndcode, lndname, lndprice\r\n" + 
				"FROM laundry where lndname = ?;";
		try(Connection con = WashingJdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, lndName);
			try(ResultSet rs = pstmt.executeQuery()){
				if (rs.next()) {
					return getLaundry(rs);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}



	
}
