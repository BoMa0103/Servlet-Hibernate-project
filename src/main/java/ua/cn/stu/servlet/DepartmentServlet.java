package ua.cn.stu.servlet;

import java.io.IOException;


import java.sql.Time;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ua.cn.stu.dao.HibernateDAOFactory;
import ua.cn.stu.domain.Department;

public class DepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String actionType = req.getParameter("actiontype");
		// Обробка запиту на додання продукту
		if ("addDepartment".equalsIgnoreCase(actionType)) {
			Long departmentNumber = Long.parseLong(req.getParameter("departmentNumber"));
			String address = req.getParameter("address");
			String phone = req.getParameter("phone");
			String workingDays = req.getParameter("workingDays");
			String startOfWork = req.getParameter("startOfWork");
			String endOfWork = req.getParameter("endOfWork");	
			if(address.equals("") || phone.equals("")) {
				resp.sendRedirect("department.jsp");
				return;
			}
			Integer wokringDaysInt = Integer.parseInt(workingDays);
			Time startOfWorkTime = Time.valueOf(startOfWork);
			Time endOfWorkTime = Time.valueOf(endOfWork);
			Department department = new Department();
			department.setDepartmentNumber(departmentNumber);
			department.setAddress(address);
			department.setPhone(phone);
			department.setWorkingDays(wokringDaysInt);
			department.setStartOfWork(startOfWorkTime);
			department.setEndOfWork(endOfWorkTime);
			HibernateDAOFactory.getInstance().getDepartmentDAO().createDepartment(department);
			// Обробка запиту на видалення продукту
		} else if ("deleteDepartment".equalsIgnoreCase(actionType)) {
			String DepartmentNumberString = req.getParameter("departmentNumber");
			Long DepartmentNumber = Long.parseLong(DepartmentNumberString);
			HibernateDAOFactory.getInstance().getDepartmentDAO().deleteDepartmentByNumber(DepartmentNumber);
			// Обробка запиту на оновлення продукту
		} else if ("updateDepartment".equalsIgnoreCase(actionType)) {
			Long departmentNumber = Long.parseLong(req.getParameter("departmentNumber"));
			String address = req.getParameter("address");
			String phone = req.getParameter("phone");
			String workingDays = req.getParameter("workingDays");
			String startOfWork = req.getParameter("startOfWork");
			String endOfWork = req.getParameter("endOfWork");
			if(address.equals("") || phone.equals("")) {
				resp.sendRedirect("department.jsp");
				return;
			}
			Integer wokringDaysInt = Integer.parseInt(workingDays);
			Time startOfWorkTime = Time.valueOf(startOfWork);
			Time endOfWorkTime = Time.valueOf(endOfWork);
			Department department = HibernateDAOFactory.getInstance().getDepartmentDAO().getDepartmentByNumber(departmentNumber);
			department.setDepartmentNumber(departmentNumber);
			department.setAddress(address);
			department.setPhone(phone);
			department.setWorkingDays(wokringDaysInt);
			department.setStartOfWork(startOfWorkTime);
			department.setEndOfWork(endOfWorkTime);
			HibernateDAOFactory.getInstance().getDepartmentDAO().updateDepartment(department);
		}
		// Після обробки запиту перейти на сторінку продукту
		resp.sendRedirect("department.jsp");
	}
}