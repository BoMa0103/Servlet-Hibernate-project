package ua.cn.stu.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ua.cn.stu.dao.HibernateDAOFactory;
import ua.cn.stu.domain.Employee;
import ua.cn.stu.domain.Passport;

public class PassportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String actionType = req.getParameter("actiontype");
		// Обробка запиту на додання продукту
		if ("addPassport".equalsIgnoreCase(actionType)) {
			Long PassportNumber = Long.parseLong(req.getParameter("passportNumber"));
			String dateOfBirth = req.getParameter("dateOfBirth");
			String homeAddress = req.getParameter("homeAddress");
			String sex = req.getParameter("sex");
			String personalNumber = req.getParameter("personalNumber");
			Long personalNumberLong = Long.parseLong(personalNumber);
			Date dateOfBirthDate = Date.valueOf(dateOfBirth);
			if(homeAddress.equals("")) {
				resp.sendRedirect("passport.jsp");
				return;
			}
			Passport passport = new Passport();
			passport.setPassportNumber(PassportNumber);
			passport.setDateOfBirth(dateOfBirthDate);
			passport.setHomeAddress(homeAddress);
			passport.setSex(sex);
			Employee employee = HibernateDAOFactory.getInstance().getEmployeeDAO().getEmployeeByNumber(personalNumberLong);
			passport.setEmployee(employee);
			HibernateDAOFactory.getInstance().getPassportDAO().createPassport(passport);
			// Обробка запиту на видалення продукту
		} else if ("deletePassport".equalsIgnoreCase(actionType)) {
			String PassportNumberString = req.getParameter("passportNumber");
			Long PassportNumber = Long.parseLong(PassportNumberString);
			HibernateDAOFactory.getInstance().getPassportDAO().deletePassportByNumber(PassportNumber);
			// Обробка запиту на оновлення продукту
		} else if ("updatePassport".equalsIgnoreCase(actionType)) {
			Long PassportNumber = Long.parseLong(req.getParameter("passportNumber"));
			String dateOfBirth = req.getParameter("dateOfBirth");
			String homeAddress = req.getParameter("homeAddress");
			String sex = req.getParameter("sex");
			String personalNumber = req.getParameter("personalNumber");
			Long personalNumberLong = Long.parseLong(personalNumber);
			Date dateOfBirthDate = Date.valueOf(dateOfBirth);
			if(homeAddress.equals("")) {
				resp.sendRedirect("passport.jsp");
				return;
			}
			Passport passport = HibernateDAOFactory.getInstance().getPassportDAO().getPassportByNumber(PassportNumber);
			passport.setPassportNumber(PassportNumber);
			passport.setDateOfBirth(dateOfBirthDate);
			passport.setHomeAddress(homeAddress);
			passport.setSex(sex);
			Employee employee = HibernateDAOFactory.getInstance().getEmployeeDAO().getEmployeeByNumber(personalNumberLong);
			passport.setEmployee(employee);
			HibernateDAOFactory.getInstance().getPassportDAO().updatePassport(passport);
		}
		// Після обробки запиту перейти на сторінку продукту
		resp.sendRedirect("passport.jsp");
	}
}