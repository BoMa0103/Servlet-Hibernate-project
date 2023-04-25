package ua.cn.stu.databean;
import java.util.List;



import ua.cn.stu.dao.HibernateDAOFactory;
import ua.cn.stu.domain.Work;

public class WorkListDatabean {
	private List<Work> workList;
	
	private static Long workCode;

	public WorkListDatabean() {
		workList = HibernateDAOFactory.getInstance().getWorkDAO().getAllWorks();
	}

	public Long getWorkCode() {
		return workCode;
	}
	
	public void setWorkCode(Long workCode) {
		WorkListDatabean.workCode = workCode;
	}

	public List<Work> getWorkList() {
		return workList;
	}

	public void setWorkList(List<Work> workList) {
		this.workList = workList;
	}
}
