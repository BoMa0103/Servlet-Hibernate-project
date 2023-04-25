<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log list</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<jsp:useBean id="employeeLogsListBean" class="ua.cn.stu.databean.EmployeeLogsListDatabean"/>
	<jsp:useBean id="currentSign" class="ua.cn.stu.databean.SignDatabean"/>
	  
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
                  <li class="menu__item">
                    <a href="logout.jsp" class="menu-link">Log out</a>
                  </li>
                  <li class="user_head">
                    <p>${currentSign.getSign().getLogin()} (${currentSign.getSign().getRole()})</p>
                  </li>
                </ul>
              </nav>
            </div>
            
	<form method="post" action="log">
	<h1 class="text-center">Log page</h1>
		<table style="width: 80%; margin: 0 auto;" border="1">
			<tr>
				<td class="col1">Id</td>
				<td>Personal number</td>
				<td>Name</td>
				<td>Phone</td>
				<td>Department number</td>
				<td>Added</td>
				<td>Action</td>
				<td>Client</td>
			</tr>
			<c:forEach var="log" items="${employeeLogsListBean.employeeLogsList}">
				<tr>
					<td><c:out value="${log.getId()}" /></td>
					<td><c:out value="${log.getPersonalNumber()}" /></td>
					<td><c:out value="${log.getName()}" /></td>
					<td><c:out value="${log.getPhone()}" /></td>
					<td><c:out value="${log.getDepartmentNumber()}" /></td>
					<td><c:out value="${log.getAdded()}" /></td>
					<td><c:out value="${log.getAction()}" /></td>
					<td><c:out value="${log.getClient()}" /></td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>