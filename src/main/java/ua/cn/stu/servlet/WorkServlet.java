package ua.cn.stu.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ua.cn.stu.dao.HibernateDAOFactory;
import ua.cn.stu.domain.Employee;
import ua.cn.stu.domain.Position;
import ua.cn.stu.domain.Work;

public class WorkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String actionType = req.getParameter("actiontype");
		// Обробка запиту на додання продукту
		if ("addWork".equalsIgnoreCase(actionType)) {
			Long workCode = Long.parseLong(req.getParameter("workCode"));
			String dateOfAdoption = req.getParameter("dateOfAdoption");
			String dateOfDismissal = req.getParameter("dateOfDismissal");
			String personalNumber = req.getParameter("personalNumber");
			String positionCode = req.getParameter("positionCode");
			Long personalNumberLong = Long.parseLong(personalNumber);
			Long positionCodeLong = Long.parseLong(positionCode);
			Date dateOfAdoptionDate = Date.valueOf(dateOfAdoption);
			Date dateOfDismissalDate = null;
			if(!dateOfDismissal.equals("")) {
				dateOfDismissalDate = Date.valueOf(dateOfDismissal);
			}
			Work work = new Work();
			work.setWorkCode(workCode);;
			work.setDateOfAdoption(dateOfAdoptionDate);
			work.setDateOfDismissal(dateOfDismissalDate);
			Employee employee = HibernateDAOFactory.getInstance().getEmployeeDAO().getEmployeeByNumber(personalNumberLong);
			work.setEmployee(employee);
			Position position = HibernateDAOFactory.getInstance().getPositionDAO().getPositionByCode(positionCodeLong);
			work.setPosition(position);
			HibernateDAOFactory.getInstance().getWorkDAO().createWork(work);
			// Обробка запиту на видалення продукту
		} else if ("deleteWork".equalsIgnoreCase(actionType)) {
			String workCodeString = req.getParameter("workCode");
			Long workCode = Long.parseLong(workCodeString);
			HibernateDAOFactory.getInstance().getWorkDAO().deleteWorkByCode(workCode);
			// Обробка запиту на оновлення продукту
		} else if ("updateWork".equalsIgnoreCase(actionType)) {
			Long workCode = Long.parseLong(req.getParameter("workCode"));
			String dateOfAdoption = req.getParameter("dateOfAdoption");
			String dateOfDismissal = req.getParameter("dateOfDismissal");
			String personalNumber = req.getParameter("personalNumber");
			String positionCode = req.getParameter("positionCode");
			Long personalNumberLong = Long.parseLong(personalNumber);
			Long positionCodeLong = Long.parseLong(positionCode);
			Date dateOfAdoptionDate = Date.valueOf(dateOfAdoption);
			Date dateOfDismissalDate = null;
			if(!dateOfDismissal.equals("")) {
				dateOfDismissalDate = Date.valueOf(dateOfDismissal);
			}
			Work work = HibernateDAOFactory.getInstance().getWorkDAO().getWorkByCode(workCode);
			work.setWorkCode(workCode);;
			work.setDateOfAdoption(dateOfAdoptionDate);
			work.setDateOfDismissal(dateOfDismissalDate);
			Employee employee = HibernateDAOFactory.getInstance().getEmployeeDAO().getEmployeeByNumber(personalNumberLong);
			work.setEmployee(employee);
			Position position = HibernateDAOFactory.getInstance().getPositionDAO().getPositionByCode(positionCodeLong);
			work.setPosition(position);
			HibernateDAOFactory.getInstance().getWorkDAO().updateWork(work);
		}
		// Після обробки запиту перейти на сторінку продукту
		resp.sendRedirect("work.jsp");
	}
}