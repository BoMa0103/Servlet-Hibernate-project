<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Education list</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<jsp:useBean id="educationListBean" class="ua.cn.stu.databean.EducationListDatabean"/>
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
            
	<h1 class="deleteText">Delete education page</h1>
	<div class="form1">
	<div class="deleteform">
		<p class="font1">Below education will be deleted:</p>
		<p>Diploma Number: ${param.diplomaNumber}</p>
		<p>Name Of Specialty: ${param.nameOfSpecialty}</p>
		<p>Specialty Code: ${param.specialtyCode}</p>
		<p>Personal Number: ${param.personalNumber}</p>
		
		<c:url var="educationUrl" value="/education.jsp" />
		<form method="post" action="education" class="formdelete">
			<input type="hidden" name="actiontype" value="deleteEducation" /> <input
				type="hidden" name="diplomaNumber" value="${param.diplomaNumber}"> <input
				type="submit" name="deleteEducation" class="gradient-button" value="Delete education"> <input
				type="button" onclick="window.location.href='${educationUrl}'"
				class="gradient-button-cancel" value="Cancel">
		</form>
	</div>
	</div>
</body>
</html>