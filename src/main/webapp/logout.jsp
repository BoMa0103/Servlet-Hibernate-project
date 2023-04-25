<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log out</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<jsp:useBean id="signtBean" class="ua.cn.stu.databean.SignDatabean"/>
	<jsp:useBean id="currentSign" class="ua.cn.stu.databean.SignDatabean"/>
	
	<div class="col-lg-6">
             <nav class="two">
                <ul class="menu">
                  <li class="menu__item">
                    <a href="department.jsp" class="menu-link">Department</a>
                  </li>
                  <c:if test="${currentSign.getSign().getRole() == 'ADMIN' || currentSign.getSign().getRole() == 'MANAGER'}">
	                  <li class="menu__item">
	                    <a href="education.jsp" class="menu-link">Education</a>
	                  </li>
	                  <li class="menu__item">
	                    <a href="employee.jsp" class="menu-link">Employee</a>
	                  </li>
	                  <li class="menu__item">
	                    <a href="passport.jsp" class="menu-link">Passport</a>
	                  </li>
	                  <li class="menu__item">
	                    <a href="position.jsp" class="menu-link">Position</a>
	                  </li>
	                  <li class="menu__item">
	                    <a href="work.jsp" class="menu-link">Work</a>
	                  </li>
	                  <c:if test="${currentSign.getSign().getRole() == 'ADMIN'}">
	                  <li class="menu__item">
	                    <a href="log.jsp" class="menu-link">Log</a>
	                  </li>
	                  </c:if>
	              </c:if>
                  <li class="menu__item">
                    <a href="logout.jsp" class="menu-link">Log out</a>
                  </li>
                  <li class="user_head">
                    <p>${currentSign.getSign().getLogin()} (${currentSign.getSign().getRole()})</p>
                  </li>
                </ul>
              </nav>
            </div>
            
	<form method="post" action="sign" class="deleteform">
	<h1 class="deleteText">Are you sure you want to log out?</h1>
		<input type="hidden" name="actiontype" value="logout" />
		<input type="submit" name="logout" class="gradient-button" value="Log out">
	</form>
</body>
</html>