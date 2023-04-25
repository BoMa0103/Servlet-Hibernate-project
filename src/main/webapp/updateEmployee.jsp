<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update employee</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<jsp:useBean id="employeeListBean"
		class="ua.cn.stu.databean.EmployeeListDatabean" />
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

	<p class="updateText">Update employee page</p>
	<c:url var="employeeUrl" value="/employee.jsp" />
	<div class="form1">
		<div>
			<form method="post" action="employee" class="updateform">
				<input type="hidden" name="actiontype" value="updateEmployee">
				<input type="hidden" name="personalNumber"
					value="${param.personalNumber}" />

				<p class="textP">Personal number:</p>
				<input type="text" class="type-1" name="personalNumber"
					value="${param.personalNumber}" />

				<p class="textP">Name:</p>
				<input type="text" class="type-1" name="name"
					value="${param.name}" />

				<p class="textP">Phone:</p>
				<input type="text" class="type-1" name="phone"
					value="${param.phone}" />

				<p class="textP">Department number:</p>
				<input type="text" class="type-1" name="departmentNumber"
					value="${param.departmentNumber}" />
				
				
				<br><input type="submit" class="gradient-button" name="deleteEmployee" value="Update employee" /> 
				<input type="button" class="gradient-button-cancel"
					onclick="window.location.href='${employeeUrl}'" value="Cancel">
			</form>
		</div>
	</div>
</body>
</html>