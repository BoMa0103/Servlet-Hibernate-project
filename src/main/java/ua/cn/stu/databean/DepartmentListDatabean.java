package ua.cn.stu.databean;

import java.util.List;
import ua.cn.stu.dao.HibernateDAOFactory;
import ua.cn.stu.domain.Department;

public class DepartmentListDatabean {
	private List<Department> departmentList;
	private List<Object> departmentEmployeesList;

	public DepartmentListDatabean() {
		departmentList = HibernateDAOFactory.getInstance().getDepartmentDAO().getAllDepartments();
		departmentEmployeesList = HibernateDAOFactory.getInstance().getDepartmentDAO().getAllDepartmentEmployees();
	}

	public List<Department> getDepartmentList() {
		return departmentList;
	}

	public void setDepartmentList(List<Department> departmentList) {
		this.departmentList = departmentList;
	}
	
	public List<Object> getDepartmentEmployeesList() {
		return departmentEmployeesList;
	}

	public void setDepartmentEmployeesList(List<Object> departmentEmployeesList) {
		this.departmentEmployeesList = departmentEmployeesList;
	}
}