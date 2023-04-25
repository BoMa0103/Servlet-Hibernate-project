package ua.cn.stu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.cn.stu.dao.HibernateDAOFactory;
import ua.cn.stu.domain.Department;
import ua.cn.stu.domain.Employee;

public class EmployeeServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String actionType = req.getParameter("actiontype");
		// Обробка запиту на додання продукту
		if ("addEmployee".equalsIgnoreCase(actionType)) {
			String personalNumber = req.getParameter("personalNumber");
			Long personalNumberInt = Long.parseLong(personalNumber);
			String name = req.getParameter("name");
			String phone = req.getParameter("phone");
			String departmentNumber = req.getParameter("departmentNumber");
			Long departmentNumberLong = Long.parseLong(departmentNumber);
			if(name.equals("") || phone.equals("")) {
				resp.sendRedirect("employee.jsp");
				return;
			}
			Employee employee = new Employee();
			employee.setPersonalNumber(personalNumberInt);
			employee.setName(name);
			employee.setPhone(phone);
			Department department = HibernateDAOFactory.getInstance().getDepartmentDAO().getDepartmentByNumber(departmentNumberLong);
			employee.setDepartment(department);
			HibernateDAOFactory.getInstance().getEmployeeDAO().createEmployee(employee);
			// Обробка запиту на видалення продукту
		} else if ("deleteEmployee".equalsIgnoreCase(actionType)) {
			String personalNumber = req.getParameter("personalNumber");
			Long personalNumberInt = Long.parseLong(personalNumber);
			HibernateDAOFactory.getInstance().getEmployeeDAO().deleteEmployeeByNumber(personalNumberInt);
			// Обробка запиту на оновлення продукту
		} else if ("updateEmployee".equalsIgnoreCase(actionType)) {
			String personalNumber = req.getParameter("personalNumber");
			Long personalNumberInt = Long.parseLong(personalNumber);
			String name = req.getParameter("name");
			String phone = req.getParameter("phone");
			String departmentNumber = req.getParameter("departmentNumber");
			Long departmentNumberLong = Long.parseLong(departmentNumber);
			if(name.equals("") || phone.equals("")) {
				resp.sendRedirect("employee.jsp");
				return;
			}
			Employee employee = HibernateDAOFactory.getInstance().getEmployeeDAO().getEmployeeByNumber(personalNumberInt);
			employee.setPersonalNumber(personalNumberInt);
			employee.setName(name);
			employee.setPhone(phone);
			Department department = HibernateDAOFactory.getInstance().getDepartmentDAO().getDepartmentByNumber(departmentNumberLong);
			employee.setDepartment(department);
			HibernateDAOFactory.getInstance().getEmployeeDAO().updateEmployee(employee);
		}
		// Після обробки запиту перейти на сторінку продукту
		resp.sendRedirect("employee.jsp");
	}
}
