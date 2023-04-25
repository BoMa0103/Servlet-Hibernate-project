<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update position</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<jsp:useBean id="positionListBean"
		class="ua.cn.stu.databean.PositionListDatabean" />
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

	<p class="updateText">Update position page</p>
	<c:url var="positionUrl" value="/position.jsp" />
	<div class="form1">
		<div>
			<form method="post" action="position" class="updateform">
				<input type="hidden" name="actiontype" value="updatePosition">
				<input type="hidden" name="positionCode"
					value="${param.positionCode}" />

				<p class="textP">Position Code:</p>
				<input type="text" class="type-1" name="positionCode"
					value="${param.positionCode}" />

				<p class="textP">Name:</p>
				<input type="text" class="type-1" name="name"
					value="${param.name}" />

				<p class="textP">Number Of Hours:</p>
				<input type="text" class="type-1" name="numberOfHours"
					value="${param.numberOfHours}" />

				<p class="textP">Salary:</p>
				<input type="text" class="type-1" name="salary"
					value="${param.salary}" />

					
				<br><input type="submit" class="gradient-button" name="deletePosition" value="Update position" /> 
				<input type="button" class="gradient-button-cancel"
					onclick="window.location.href='${positionUrl}'" value="Cancel">
			</form>
		</div>
	</div>
</body>
</html>