package washing_manager.dao;

import java.util.List;

import washing_manager.dto.GradeDc;

public interface GradeDao {
	GradeDc selectGradedcByGrade(String grade);
	List<GradeDc> selectGradeDcAll();
}
