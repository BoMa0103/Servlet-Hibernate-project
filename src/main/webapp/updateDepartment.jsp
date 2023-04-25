<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update department</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<jsp:useBean id="departmentListBean"
		class="ua.cn.stu.databean.DepartmentListDatabean" />
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

	<p class="updateText">Update department page</p>
	<c:url var="departmentUrl" value="/department.jsp" />
	<div class="form1">
		<div>
			<form method="post" action="department" class="updateform">
				<input type="hidden" name="actiontype" value="updatedepartment">
				<input type="hidden" name="departmentNumber"
					value="${param.departmentNumber}" />

				<p class="textP">Department Number:</p>
				<input type="text" class="type-1" name="departmentNumber"
					value="${param.departmentNumber}" />

				<p class="textP">Address:</p>
				<input type="text" class="type-1" name="address"
					value="${param.address}" />

				<p class="textP">Phone:</p>
				<input type="text" class="type-1" name="phone"
					value="${param.phone}" />

				<p class="textP">Working Days:</p>
				<input type="text" class="type-1" name="workingDays"
					value="${param.workingDays}" />

				<p class="textP">Start Of Work:</p>
				<input type="time" class="date1" step="2"
                    min="00:00" max="23:59" name="startOfWork"
					value="${param.startOfWork}" />

				<p class="textP">End Of Work:</p>
				<input type="time" class="date1" step="2"
                    min="00:00" max="23:59" name="endOfWork"
					value="${param.endOfWork}" /> <br>
					
				<br><input type="submit" class="gradient-button" name="deletedepartment" value="Update department" /> 
				<input type="button" class="gradient-button-cancel"
					onclick="window.location.href='${departmentUrl}'" value="Cancel">
			</form>
		</div>
	</div>
</body>
</html>