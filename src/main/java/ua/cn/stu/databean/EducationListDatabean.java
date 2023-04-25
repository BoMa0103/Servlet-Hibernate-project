package ua.cn.stu.databean;
import java.util.List;



import ua.cn.stu.dao.HibernateDAOFactory;
import ua.cn.stu.domain.Education;

public class EducationListDatabean {
	private List<Education> educationList;
	
	private static Long personalNumber;

	public EducationListDatabean() {
		educationList = HibernateDAOFactory.getInstance().getEducationDAO().getAllEducations();
	}

	public Long getPersonalNumber() {
		return personalNumber;
	}
	
	public void setPersonalNumber(Long personalNumber) {
		EducationListDatabean.personalNumber = personalNumber;
	}

	public List<Education> getEducationList() {
		return educationList;
	}

	public void setEducationList(List<Education> EducationList) {
		this.educationList = EducationList;
	}
}
