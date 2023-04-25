<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Passport list</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<jsp:useBean id="passportListBean" class="ua.cn.stu.databean.PassportListDatabean"/>
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
            
	<h1 class="deleteText">Delete passport page</h1>
	<div class="form1">
	<div class="deleteform">
		<p class="font1">Below passport will be deleted:</p>
		<p>Passport Number: ${param.passportNumber}</p>
		<p>Date Of Birth: ${param.dateOfBirth}</p>
		<p>Home Address: ${param.homeAddress}</p>
		<p>Sex: ${param.sex}</p>
		<p>Personal Number: ${param.personalNumber}</p>
		
		<c:url var="passportUrl" value="/passport.jsp" />
		<form method="post" action="passport" class="formdelete">
			<input type="hidden" name="actiontype" value="deletePassport" /> <input
				type="hidden" name="passportNumber" value="${param.passportNumber}"> <input
				type="submit" name="deletePassport" class="gradient-button" value="Delete passport"> <input
				type="button" onclick="window.location.href='${passportUrl}'"
				class="gradient-button-cancel" value="Cancel">
		</form>
	</div>
	</div>
</body>
</html>