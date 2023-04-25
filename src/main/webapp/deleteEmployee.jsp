<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee list</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<jsp:useBean id="employeeListBean" class="ua.cn.stu.databean.EmployeeListDatabean"/>
	<div class="col-lg-6">
              <nav class="two">
                 <ul class="menu">
                  <li class="menu__item">
                    <a href="department.jsp" class="menu-link">Department</a>
                  </li>
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
                  <li class="menu__item">
                    <a href="log.jsp" class="menu-link">Log</a>
                  </li>
                </ul>
              </nav>
            </div>
            
	<h1 class="deleteText">Delete employee page</h1>
	<div class="form1">
	<div class="deleteform">
		<p class="font1">Below employee will be deleted:</p>
		<p>Personal number: ${param.personalNumber}</p>
		<p>Name: ${param.name}</p>
		<p>Phone: ${param.phone}</p>
		<p>Department number: ${param.departmentNumber}</p>
		<c:url var="employeeUrl" value="/employee.jsp" />
		<form method="post" action="employee" class="formdelete">
			<input type="hidden" name="actiontype" value="deleteEmployee" /> <input
				type="hidden" name="personalNumber" value="${param.personalNumber}"> <input
				type="submit" name="deleteEmployee" class="gradient-button" value="Delete employee"> <input
				type="button" onclick="window.location.href='${employeeUrl}'"
				class="gradient-button-cancel" value="Cancel">
		</form>
	</div>
	</div>
</body>
</html>