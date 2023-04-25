package ua.cn.stu.databean;

import java.util.List;
import ua.cn.stu.dao.HibernateDAOFactory;
import ua.cn.stu.domain.Log;

public class EmployeeLogsListDatabean {
	private List<Log> employeeLogsList;

	public EmployeeLogsListDatabean() {
		employeeLogsList = HibernateDAOFactory.getInstance().getEmployeeLogsDAO().getAllEmployeeLogs();
	}

	public List<Log> getEmployeeLogsList() {
		return employeeLogsList;
	}

	public void setEmployeeLogsList(List<Log> employeeLogsList) {
		this.employeeLogsList = employeeLogsList;
	}
}