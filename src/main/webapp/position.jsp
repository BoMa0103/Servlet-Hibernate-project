<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Position list</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<jsp:useBean id="positionListBean" class="ua.cn.stu.databean.PositionListDatabean"/>
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
	<h1 class="text-center">Position page</h1>
	<form method="post" action="position">
		<table style="width: 80%; margin: 0 auto;" border="1">
			<tr>
				<td class="col1">Position code</td>
				<td>Name</td>
				<td>Number of hours</td>
				<td>Salary</td>
				<c:if test="${currentSign.getSign().getRole() == 'ADMIN'}"><td>Actions</td></c:if>
			</tr>
			<c:forEach var="position" items="${positionListBean.positionList}">
				<tr>
					<td><c:out value="${position.getPositionCode()}" /></td>
					<td><c:out value="${position.getName()}" /></td>
					<td><c:out value="${position.getNumberOfHours()}" /></td>
					<td><c:out value="${position.getSalary()}" /></td>
					<c:if test="${currentSign.getSign().getRole() == 'ADMIN'}">
					<td>
						<c:url var="deleteUrl" value="/deletePosition.jsp">
							<c:param name="positionCode" value="${position.getPositionCode()}" />
							<c:param name="name" value="${position.getName()}" />
							<c:param name="numberOfHours" value="${position.getNumberOfHours()}" />
							<c:param name="salary" value="${position.getSalary()}" />
						</c:url> 
						<c:url var="updateUrl" value="/updatePosition.jsp">
							<c:param name="positionCode" value="${position.getPositionCode()}" />
							<c:param name="name" value="${position.getName()}" />
							<c:param name="numberOfHours" value="${position.getNumberOfHours()}" />
							<c:param name="salary" value="${position.getSalary()}" />
						</c:url>
						<p>
							<a href="${deleteUrl}" class="link">Delete Position</a>
						</p>
						<p>
							<a href="${updateUrl}" class="link">Update Position</a>
						</p>
					</td>
					</c:if>
				</tr>
			</c:forEach>
			<c:if test="${currentSign.getSign().getRole() == 'ADMIN'}">
			<tr>
				<td><input type="text" class="type-1" name="positionCode" /></td>
				<td><input type="text" class="type-1" name="name" /></td>
				<td><input type="text" class="type-1" name="numberOfHours" /></td>
				<td><input type="text" class="type-1" name="salary" /></td>
				<td><input type="hidden" name="actiontype" value="addPosition" />
					<input type="submit" name="addPosition"  class="gradient-button" value="Add Position">
				</td>
			</tr>
			</c:if>
		</table>
	</form>
</body>
</html>