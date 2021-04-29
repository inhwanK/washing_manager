package washing_manager.service;

import washing_manager.dao.GradeDao;
import washing_manager.dao.impl.GradeDaoImpl;
import washing_manager.dto.GradeDc;

public class GradeDcService {
	private GradeDao dao = GradeDaoImpl.getInstance();
	
	public GradeDc showGradeDcByGrade(String grade) {
		return dao.selectGradedcByGrade(grade);
	}
}
