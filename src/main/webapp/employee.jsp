<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee list</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<jsp:useBean id="employeeListBean" class="ua.cn.stu.databean.EmployeeListDatabean"/>
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
                  <c:if test="${currentSign.getSign().getRole() == 'ADMIN'}">
	                  <li class="menu__item">
	                    <a href="log.jsp" class="menu-link">Log</a>
	                  </li>
	              </c:if>
                  <li class="menu__item">
                    <a href="logout.jsp" class="menu-link">Log out</a>
                  </li>
                  <li class="user_head">
                    <p>${currentSign.getSign().getLogin()} (${currentSign.getSign().getRole()})</p>
                  </li>
                </ul>
              </nav>
            </div>
            
	<h1 class="text-center">Employee page</h1>
	<form method="post" action="employee">
		<table style="width: 80%; margin: 0 auto;" border="1">
			<tr>
				<td class="col1" >Personal number</td>
				<td>Name</td>
				<td>Phone</td>
				<td>Department number</td>
				<c:if test="${currentSign.getSign().getRole() == 'ADMIN'}"><td>Actions</td></c:if>
			</tr>
			<c:forEach var="employee" items="${employeeListBean.employeeList}">
				<tr>
					<td><c:out value="${employee.getPersonalNumber()}" /></td>
					<td><c:out value="${employee.getName()}" /></td>
					<td><c:out value="${employee.getPhone()}" /></td>
					<td><c:out value="${employee.getDepartmentNumber()}" /></td>
					<c:if test="${currentSign.getSign().getRole() == 'ADMIN'}">
					<td>
						<c:url var="deleteUrl" value="/deleteEmployee.jsp">
							<c:param name="personalNumber" value="${employee.getPersonalNumber()}" />
							<c:param name="name" value="${employee.getName()}" />
							<c:param name="phone" value="${employee.getPhone()}" />
							<c:param name="departmentNumber" value="${employee.getDepartmentNumber()}" />
						</c:url> 
						<c:url var="updateUrl" value="/updateEmployee.jsp">
							<c:param name="personalNumber" value="${employee.getPersonalNumber()}" />
							<c:param name="name" value="${employee.getName()}" />
							<c:param name="phone" value="${employee.getPhone()}" />
							<c:param name="departmentNumber" value="${employee.getDepartmentNumber()}" />
						</c:url>
						<p>
							<a href="${deleteUrl}" class="link">Delete Employee</a>
						</p>
						<p>
							<a href="${updateUrl}" class="link" >Update Employee</a>
						</p>
					</td>
					</c:if>
				</tr>
			</c:forEach>
			<c:if test="${currentSign.getSign().getRole() == 'ADMIN'}">
			<tr>
				<td><input type="text" class="type-1" name="personalNumber" /></td>
				<td><input type="text" class="type-1" name="name" /></td>
				<td><input type="text" class="type-1" name="phone" /></td>
				<td><input type="text" class="type-1" name="departmentNumber" /></td>
				<td><input type="hidden" name="actiontype" value="addEmployee" />
					<input type="submit" name="addEmployee"  class="gradient-button" value="Add Employee">
				</td>
			</tr>
			</c:if>
		</table>
	</form>
</body>
</html>