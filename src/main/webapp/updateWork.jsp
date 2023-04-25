<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update work</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<jsp:useBean id="workListBean"
		class="ua.cn.stu.databean.WorkListDatabean" />
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

	<p class="updateText">Update work page</p>
	<c:url var="workUrl" value="/work.jsp" />
	<div class="form1">
		<div>
			<form method="post" action="work" class="updateform">
				<input type="hidden" name="actiontype" value="updateWork">
				<input type="hidden" name="workCode"
					value="${param.workCode}" />
		
				<p class="textP">Work Code:</p>
				<input type="text" class="type-1" name="workCode"
					value="${param.workCode}" />

				<p class="textP">Date Of Adoption:</p>
				<input type="date" class="date1" value="${param.dateOfAdoption}"
                    min="2000-01-01" max="2023-12-31" name="dateOfAdoption" />

				<p class="textP">Date Of Dismissal:</p>
				<input type="date" class="date1"
                    min="2000-01-01" max="2023-12-31" name="dateOfDismissal"
					value="${param.dateOfDismissal}" />

				<p class="textP">Personal Number:</p>
				<input type="text" class="type-1" name="personalNumber"
					value="${param.personalNumber}" />
					
				<p class="textP">Position Code:</p>
				<input type="text" class="type-1" name="positionCode"
					value="${param.positionCode}" />
				
				<br><input type="submit" class="gradient-button" name="deleteWork" value="Update work" /> 
				<input type="button" class="gradient-button-cancel"
					onclick="window.location.href='${workUrl}'" value="Cancel">
			</form>
		</div>
	</div>
</body>
</html>