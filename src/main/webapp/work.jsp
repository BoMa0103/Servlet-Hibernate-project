<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Work list</title>
<link href="style.css	" rel="stylesheet" type="text/css">
</head>
<body>
	<jsp:useBean id="workListBean" class="ua.cn.stu.databean.WorkListDatabean"/>
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
	<h1 class="text-center">Work page</h1>
	<form method="post" action="work">
		<table style="width: 80%; margin: 0 auto;" border="1">
			<tr>
				<td class="col1">Work code</td>
				<td>Date of adoption</td>
				<td>Date of dismissal</td>
				<td>Personal number</td>
				<td>Position code</td>
				<c:if test="${currentSign.getSign().getRole() == 'ADMIN'}"><td>Actions</td></c:if>
			</tr>
			<c:forEach var="work" items="${workListBean.workList}">
				<tr>
					<td><c:out value="${work.getWorkCode()}" /></td>
					<td><c:out value="${work.getDateOfAdoption()}" /></td>
					<td><c:out value="${work.getDateOfDismissal()}" /></td>
					<td><c:out value="${work.getPersonalNumber()}" /></td>
					<td><c:out value="${work.getPositionCode()}" /></td>
					<c:if test="${currentSign.getSign().getRole() == 'ADMIN'}">
					<td>
						<c:url var="deleteUrl" value="/deleteWork.jsp">
							<c:param name="workCode" value="${work.getWorkCode()}" />
							<c:param name="dateOfAdoption" value="${work.getDateOfAdoption()}" />
							<c:param name="dateOfDismissal" value="${work.getDateOfDismissal()}" />
							<c:param name="personalNumber" value="${work.getPersonalNumber()}" />
							<c:param name="positionCode" value="${work.getPositionCode()}" />
						</c:url> 
						<c:url var="updateUrl" value="/updateWork.jsp">
							<c:param name="workCode" value="${work.getWorkCode()}" />
							<c:param name="dateOfAdoption" value="${work.getDateOfAdoption()}" />
							<c:param name="dateOfDismissal" value="${work.getDateOfDismissal()}" />
							<c:param name="personalNumber" value="${work.getPersonalNumber()}" />
							<c:param name="positionCode" value="${work.getPositionCode()}" />
						</c:url>
						<p>
							<a href="${deleteUrl}" class="link">Delete Work</a>
						</p>
						<p>
							<a href="${updateUrl}" class="link">Update Work</a>
						</p>
					</td>
					</c:if>
				</tr>
			</c:forEach>
			<c:if test="${currentSign.getSign().getRole() == 'ADMIN'}">
			<tr>
				<td><input type="text" class="type-1" name="workCode" /></td>
				<td><input type="date" class="date1" value="2000-01-01"
                    min="2000-01-01" max="2023-12-31" name="dateOfAdoption" /></td>
				<td><input type="date" class="date1" 
                        min="2000-01-01" max="2023-12-31" name="dateOfDismissal" /></td>
				<td><input type="text" class="type-1" name="personalNumber" /></td>
				<td><input type="text" class="type-1" name="positionCode" /></td>
				<td><input type="hidden" name="actiontype" value="addWork" />
					<input type="submit" name="addWork" class="gradient-button" value="Add Work">
				</td>
			</tr>
			</c:if>
		</table>
	</form>
</body>
</html>