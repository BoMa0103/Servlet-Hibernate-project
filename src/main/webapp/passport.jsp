<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Passport list</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<jsp:useBean id="passportListBean" class="ua.cn.stu.databean.PassportListDatabean"/>
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
	<h1 class="text-center">Passport page</h1>
	<form method="post" action="passport">
		<table style="width: 80%; margin: 0 auto;" border="1">
			<tr>
				<td class="col1" >Passport number</td>
				<td>Date of birth</td>
				<td>Home address</td>
				<td>Sex</td>
				<td>Personal number</td>
				<c:if test="${currentSign.getSign().getRole() == 'ADMIN'}"><td>Actions</td></c:if>
			</tr>
			<c:forEach var="passport" items="${passportListBean.passportList}">
				<tr>
					<td><c:out value="${passport.getPassportNumber()}" /></td>
					<td><c:out value="${passport.getDateOfBirth()}" /></td>
					<td><c:out value="${passport.getHomeAddress()}" /></td>
					<td><c:out value="${passport.getSex()}" /></td>
					<td><c:out value="${passport.getPersonalNumber()}" /></td>
					<c:if test="${currentSign.getSign().getRole() == 'ADMIN'}">
					<td>
						<c:url var="deleteUrl" value="/deletePassport.jsp">
							<c:param name="passportNumber" value="${passport.getPassportNumber()}" />
							<c:param name="dateOfBirth" value="${passport.getDateOfBirth()}" />
							<c:param name="homeAddress" value="${passport.getHomeAddress()}" />
							<c:param name="sex" value="${passport.getSex()}" />
							<c:param name="personalNumber" value="${passport.getPersonalNumber()}" />
						</c:url> 
						<c:url var="updateUrl" value="/updatePassport.jsp">
							<c:param name="passportNumber" value="${passport.getPassportNumber()}" />
							<c:param name="dateOfBirth" value="${passport.getDateOfBirth()}" />
							<c:param name="homeAddress" value="${passport.getHomeAddress()}" />
							<c:param name="sex" value="${passport.getSex()}" />
							<c:param name="personalNumber" value="${passport.getPersonalNumber()}" />
						</c:url>
						<p>
							<a href="${deleteUrl}" class="link">Delete Passport</a>
						</p>
						<p>
							<a href="${updateUrl}" class="link">Update Passport</a>
						</p>
					</td>
					</c:if>
				</tr>
			</c:forEach>
			<c:if test="${currentSign.getSign().getRole() == 'ADMIN'}">
			<tr>
				<td><input type="text" class="type-1" name="passportNumber" /></td>
				<td><input type="date" class="date1" value="2000-01-01"
                    min="1950-01-01" max="2023-01-01" name="dateOfBirth" /></td>
				<td><input type="text" class="type-1" name="homeAddress" /></td>
				<td>
						<select name="sex" class="select">
						  <option value="M">M</option>
						  <option value="W">W</option>
						</select></td>
				<td><input type="text" class="type-1" name="personalNumber" /></td>
				<td><input type="hidden" name="actiontype" value="addPassport" />
					<input type="submit" name="addPassport"  class="gradient-button" value="Add Passport">
				</td>
			</tr>
			</c:if>
		</table>
	</form>
</body>
</html>