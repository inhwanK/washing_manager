package washing_manager.dao;

import washing_manager.dto.GradeDc;

public interface GradeDao {
	GradeDc selectGradedcByGrade(String grade);
}
