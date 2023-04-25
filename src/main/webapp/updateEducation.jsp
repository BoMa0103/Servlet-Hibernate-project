<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update education</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<jsp:useBean id="educationListBean"
		class="ua.cn.stu.databean.EducationListDatabean" />
	<div class="col-lg-6">
		<nav class="two">
			<ul class="menu">
				<li class="menu__item"><a href="department.jsp"
					class="menu-link">Department</a></li>
				<li class="menu__item"><a href="education.jsp"
					class="menu-link">Education</a></li>
				<li class="menu__item"><a href="employee.jsp" class="menu-link">Employee</a>
				</li>
				<li class="menu__item"><a href="passport.jsp" class="menu-link">Passport</a>
				</li>
				<li class="menu__item"><a href="position.jsp" class="menu-link">Position</a>
				</li>
				<li class="menu__item"><a href="work.jsp" class="menu-link">Work</a>
				</li>
				<li class="menu__item"><a href="log.jsp" class="menu-link">Log</a>
				</li>
			</ul>
		</nav>
	</div>

	<p class="updateText">Update education page</p>
	<c:url var="educationUrl" value="/education.jsp" />
	<div class="form1">
		<div>
			<form method="post" action="education" class="updateform">
				<input type="hidden" name="actiontype" value="updateEducation">
				<input type="hidden" name="diplomaNumber"
					value="${param.diplomaNumber}" />

				<p class="textP">Diploma Number:</p>
				<input type="text" class="type-1" name="diplomaNumber"
					value="${param.diplomaNumber}" />

				<p class="textP">Name Of Specialty:</p>
				<input type="text" class="type-1" name="nameOfSpecialty"
					value="${param.nameOfSpecialty}" />

				<p class="textP">Specialty Code:</p>
				<input type="text" class="type-1" name="specialtyCode"
					value="${param.specialtyCode}" />

				<p class="textP">Personal Number:</p>
				<input type="text" class="type-1" name="personalNumber"
					value="${param.personalNumber}" />
				
				
				<br><input type="submit" class="gradient-button" name="deleteEducation" value="Update education" /> 
				<input type="button" class="gradient-button-cancel"
					onclick="window.location.href='${educationUrl}'" value="Cancel">
			</form>
		</div>
	</div>
</body>
</html>