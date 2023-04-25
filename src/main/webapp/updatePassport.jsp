<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update passport</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<jsp:useBean id="passportListBean"
		class="ua.cn.stu.databean.PassportListDatabean" />
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

	<p class="updateText">Update passport page</p>
	<c:url var="passportUrl" value="/passport.jsp" />
	<div class="form1">
		<div>
			<form method="post" action="passport" class="updateform">
				<input type="hidden" name="actiontype" value="updatePassport">
				<input type="hidden" name="passportNumber"
					value="${param.passportNumber}" />

				<p class="textP">Passport Number:</p>
				<input type="text" class="type-1" name="personalNumber"
					value="${param.personalNumber}" />

				<p class="textP">Date Of Birth:</p>
				<input type="date" class="date1"
                    min="1950-01-01" max="2023-01-01" name="dateOfBirth"
					value="${param.dateOfBirth}" />

				<p class="textP">Home Address:</p>
				<input type="text" class="type-1" name="homeAddress"
					value="${param.homeAddress}" />

				<p class="textP">Sex:</p>
				<select name="sex" class="select">
					<option value="M" <c:if test="${param.sex == 'M'}"> selected </c:if>>M</option>
					<option value="W" <c:if test="${param.sex == 'W'}"> selected </c:if>>W</option>
				</select>
					
				<p class="textP">Personal Number:</p>
				<input type="text" class="type-1" name="personalNumber"
					value="${param.personalNumber}" />
				
				<br><input type="submit" class="gradient-button" name="deletePassport" value="Update passport" /> 
				<input type="button" class="gradient-button-cancel"
					onclick="window.location.href='${passportUrl}'" value="Cancel">
			</form>
		</div>
	</div>
</body>
</html>