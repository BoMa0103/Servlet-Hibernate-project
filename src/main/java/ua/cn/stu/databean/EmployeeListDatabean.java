package ua.cn.stu.databean;
import java.util.List;


import ua.cn.stu.dao.HibernateDAOFactory;
import ua.cn.stu.domain.Employee;

public class EmployeeListDatabean {
	private List<Employee> employeeList;
	
	private static Long departmentNumber;

	public EmployeeListDatabean() {
		employeeList = HibernateDAOFactory.getInstance().getEmployeeDAO().getAllEmployees();
	}

	public Long getDepartmentNumber() {
		return departmentNumber;
	}
	
	public void setDepartmentNumber(Long departmentNumber) {
		EmployeeListDatabean.departmentNumber = departmentNumber;
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> EmployeeList) {
		this.employeeList = EmployeeList;
	}
	
	public List<Employee> getDepartmentEmployeesList() {
		return HibernateDAOFactory.getInstance().getEmployeeDAO().getEmployeesByDepartmentNumber(getDepartmentNumber());
	}
}
