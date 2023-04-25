package ua.cn.stu.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ua.cn.stu.dao.HibernateDAOFactory;
import ua.cn.stu.domain.Education;
import ua.cn.stu.domain.Employee;

public class EducationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String actionType = req.getParameter("actiontype");
		// Обробка запиту на додання продукту
		if ("addEducation".equalsIgnoreCase(actionType)) {
			Long diplomaNumber = Long.parseLong(req.getParameter("diplomaNumber"));
			Long personalNumber = Long.parseLong(req.getParameter("personalNumber"));
			String nameOfSpecialty = req.getParameter("nameOfSpecialty");
			String specialtyCode = req.getParameter("specialtyCode");
			Integer specialtyCodeInt = Integer.parseInt(specialtyCode);
			if(nameOfSpecialty.equals("")) {
				resp.sendRedirect("education.jsp");
				return;
			}
			Education education = new Education();
			education.setDiplomaNumber(diplomaNumber);;
			education.setNameOfSpecialty(nameOfSpecialty);
			education.setSpecialtyCode(specialtyCodeInt);
			Employee employee = HibernateDAOFactory.getInstance().getEmployeeDAO().getEmployeeByNumber(personalNumber);
			education.setEmployee(employee);
			HibernateDAOFactory.getInstance().getEducationDAO().createEducation(education);
			// Обробка запиту на видалення продукту
		} else if ("deleteEducation".equalsIgnoreCase(actionType)) {
			String EducationNumberString = req.getParameter("diplomaNumber");
			Long EducationNumber = Long.parseLong(EducationNumberString);
			HibernateDAOFactory.getInstance().getEducationDAO().deleteEducationByNumber(EducationNumber);
			// Обробка запиту на оновлення продукту
		} else if ("updateEducation".equalsIgnoreCase(actionType)) {
			Long diplomaNumber = Long.parseLong(req.getParameter("diplomaNumber"));
			Long personalNumber = Long.parseLong(req.getParameter("personalNumber"));
			String nameOfSpecialty = req.getParameter("nameOfSpecialty");
			String specialtyCode = req.getParameter("specialtyCode");
			Integer specialtyCodeInt = Integer.parseInt(specialtyCode);
			if(nameOfSpecialty.equals("")) {
				resp.sendRedirect("education.jsp");
				return;
			}
			Education education = HibernateDAOFactory.getInstance().getEducationDAO().getEducationByNumber(diplomaNumber);
			education.setDiplomaNumber(diplomaNumber);;
			education.setNameOfSpecialty(nameOfSpecialty);
			education.setSpecialtyCode(specialtyCodeInt);
			Employee employee = HibernateDAOFactory.getInstance().getEmployeeDAO().getEmployeeByNumber(personalNumber);
			education.setEmployee(employee);
			HibernateDAOFactory.getInstance().getEducationDAO().updateEducation(education);
		}
		// Після обробки запиту перейти на сторінку продукту
		resp.sendRedirect("education.jsp");
	}
}