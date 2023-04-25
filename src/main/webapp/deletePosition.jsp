<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Position list</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<jsp:useBean id="positionListBean" class="ua.cn.stu.databean.PositionListDatabean"/>
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
            
	<h1 class="deleteText">Delete position page</h1>
	<div class="form1">
	<div class="deleteform">
		<p class="font1">Below position will be deleted:</p>	
		<p>Position Code: ${param.positionCode}</p>
		<p>Name: ${param.name}</p>
		<p>Number Of Hours: ${param.numberOfHours}</p>
		<p>Salary: ${param.salary}</p>
		
		<c:url var="positionUrl" value="/position.jsp" />
		<form method="post" action="position" class="formdelete">
			<input type="hidden" name="actiontype" value="deletePosition" /> <input
				type="hidden" name="positionCode" value="${param.positionCode}"> <input
				type="submit" name="deletePosition" class="gradient-button" value="Delete position"> <input
				type="button" onclick="window.location.href='${positionUrl}'"
				class="gradient-button-cancel" value="Cancel">
		</form>
	</div>
	</div>
</body>
</html>