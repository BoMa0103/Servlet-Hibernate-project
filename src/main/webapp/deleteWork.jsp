<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Work list</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<jsp:useBean id="workListBean" class="ua.cn.stu.databean.WorkListDatabean"/>
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
            
	<h1 class="deleteText">Delete work page</h1>
	<div class="form1">
	<div class="deleteform">
		<p class="font1">Below work will be deleted:</p>						
		<p>Work Code: ${param.workCode}</p>
		<p>Date Of Adoption: ${param.dateOfAdoption}</p>
		<p>Date Of Dismissal: ${param.dateOfDismissal}</p>
		<p>Personal Number: ${param.personalNumber}</p>
		<p>Position Code: ${param.positionCode}</p>
		<c:url var="workUrl" value="/work.jsp" />
		<form method="post" action="work" class="formdelete">
			<input type="hidden" name="actiontype" value="deleteWork" /> <input
				type="hidden" name="workCode" value="${param.workCode}"> <input
				type="submit" name="deleteWork" class="gradient-button" value="Delete work"> <input
				type="button" onclick="window.location.href='${workUrl}'"
				class="gradient-button-cancel" value="Cancel">
		</form>
	</div>
	</div>
</body>
</html>