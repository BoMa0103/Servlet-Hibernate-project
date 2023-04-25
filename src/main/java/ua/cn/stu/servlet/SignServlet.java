package ua.cn.stu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ua.cn.stu.dao.HibernateDAOFactory;
import ua.cn.stu.databean.SignDatabean;
import ua.cn.stu.domain.Sign;
import ua.cn.stu.service.SendMail;

public class SignServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String actionType = req.getParameter("actiontype");
		if ("logIn".equalsIgnoreCase(actionType)) {
			String login = req.getParameter("login");
			String password = req.getParameter("password");
			if(HibernateDAOFactory.getInstance().getSignDAO().getSignByLogin(login) != null) {
				resp.sendRedirect("register.jsp");
				return;
			}
			Sign sign = new Sign();
			sign.setLogin(login);
			sign.setPassword(password);
			sign.setRole("USER");
			HibernateDAOFactory.getInstance().getSignDAO().createSign(sign);
		} else if ("signIn".equalsIgnoreCase(actionType)) {
			String login = req.getParameter("login");
			String password = req.getParameter("password");
			Sign sign = HibernateDAOFactory.getInstance().getSignDAO().getSignByLogin(login);
			if(sign != null && sign.getPassword().equals(password)) {
				SignDatabean.setSign(sign);
				if(sign.getRole().equals("ADMIN")) {
					HibernateDAOFactory.getInstance().setUserName("user_one");
					HibernateDAOFactory.getInstance().setUserPass("user_one");
					SendMail.sendEmail("bengemingg@gmail.com");
				} else if(sign.getRole().equals("MANAGER")) {
					HibernateDAOFactory.getInstance().setUserName("manager");
					HibernateDAOFactory.getInstance().setUserPass("manager_pass");
				} else if(sign.getRole().equals("USER")) {
					HibernateDAOFactory.getInstance().setUserName("just_user");
					HibernateDAOFactory.getInstance().setUserPass("just_user");
				}
				HibernateDAOFactory.getInstance().setSession(null);
				HibernateDAOFactory.getInstance().getSession();
				resp.sendRedirect("department.jsp");
				return;
			}
		} else if("logout".equalsIgnoreCase(actionType)) {
			HibernateDAOFactory.getInstance().setUserName("login_user");
			HibernateDAOFactory.getInstance().setUserPass("login_user");
			HibernateDAOFactory.getInstance().setSession(null);
			HibernateDAOFactory.getInstance().setInstance(null);
			HibernateDAOFactory.getInstance().getSession();
		}
		resp.sendRedirect("sign.jsp");
	}
}