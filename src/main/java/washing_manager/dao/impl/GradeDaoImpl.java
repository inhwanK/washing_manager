package washing_manager.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import washing_manager.conn.WashingJdbcUtil;
import washing_manager.dao.GradeDao;
import washing_manager.dto.GradeDc;

public class GradeDaoImpl implements GradeDao {
	private static GradeDaoImpl instance = new GradeDaoImpl();
	
	public static GradeDaoImpl getInstance() {
		return instance;
	}

	@Override
	public GradeDc selectGradedcByGrade(String grade) {
		String sql = "select grade, discount from gradedc where grade = ?;";
		try(Connection con = WashingJdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, grade);
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					return getGrade(rs);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private GradeDc getGrade(ResultSet rs) {
		GradeDc gradeDc = new GradeDc();
		
		try {
			gradeDc.setGrade(rs.getString("grade"));
		} catch (SQLException e) {}
		
		try {
			gradeDc.setDiscount(rs.getFloat("discount"));
		} catch (SQLException e) {}
		
		return gradeDc;
	}

	@Override
	public List<GradeDc> selectGradeDcAll() {
		String sql = "select grade, discount from gradedc;";
		try (Connection con = WashingJdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			if(rs.next()) {
				List<GradeDc> list = new ArrayList<>();
				do {
					list.add(getGrade(rs));
				}while(rs.next());
				return list;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
