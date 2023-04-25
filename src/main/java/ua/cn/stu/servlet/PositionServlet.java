package ua.cn.stu.servlet;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ua.cn.stu.dao.HibernateDAOFactory;
import ua.cn.stu.domain.Position;

public class PositionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String actionType = req.getParameter("actiontype");
		// Обробка запиту на додання продукту
		if ("addPosition".equalsIgnoreCase(actionType)) {
			Long positionCode = Long.parseLong(req.getParameter("positionCode"));
			String name = req.getParameter("name");
			String numberOfHours = req.getParameter("numberOfHours");
			String salary = req.getParameter("salary");
			Integer numberOfHoursInt = Integer.parseInt(numberOfHours);
			BigDecimal salaryDecimal = BigDecimal.valueOf(Double.parseDouble(salary));
			if(name.equals("")) {
				resp.sendRedirect("position.jsp");
				return;
			}
			Position position = new Position();
			position.setPositionCode(positionCode);
			position.setName(name);
			position.setNumberOfHours(numberOfHoursInt);
			position.setSalary(salaryDecimal);
			HibernateDAOFactory.getInstance().getPositionDAO().createPosition(position);
			// Обробка запиту на видалення продукту
		} else if ("deletePosition".equalsIgnoreCase(actionType)) {
			String positionCodeString = req.getParameter("positionCode");
			Long positionCode = Long.parseLong(positionCodeString);
			HibernateDAOFactory.getInstance().getPositionDAO().deletePositionByCode(positionCode);
			// Обробка запиту на оновлення продукту
		} else if ("updatePosition".equalsIgnoreCase(actionType)) {
			Long positionCode = Long.parseLong(req.getParameter("positionCode"));
			String name = req.getParameter("name");
			String numberOfHours = req.getParameter("numberOfHours");
			String salary = req.getParameter("salary");
			Integer numberOfHoursInt = Integer.parseInt(numberOfHours);
			BigDecimal salaryDecimal = BigDecimal.valueOf(Double.parseDouble(salary));
			if(name.equals("")) {
				resp.sendRedirect("position.jsp");
				return;
			}
			Position position = HibernateDAOFactory.getInstance().getPositionDAO().getPositionByCode(positionCode);
			position.setPositionCode(positionCode);
			position.setName(name);
			position.setNumberOfHours(numberOfHoursInt);
			position.setSalary(salaryDecimal);
			HibernateDAOFactory.getInstance().getPositionDAO().updatePosition(position);
		}
		// Після обробки запиту перейти на сторінку продукту
		resp.sendRedirect("position.jsp");
	}
}