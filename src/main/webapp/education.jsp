<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Education list</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<jsp:useBean id="educationListBean" class="ua.cn.stu.databean.EducationListDatabean"/>
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
	<h1 class="text-center">Education page</h1>
	<form method="post" action="education">
		<table style="width: 80%; margin: 0 auto;" border="1">
		
			<tr>
				<td class="col1">Diploma number</td>
				<td>Name of specialty</td>
				<td>Specialty code</td>
				<td>Personal number</td>
				<c:if test="${currentSign.getSign().getRole() == 'ADMIN'}"><td>Actions</td></c:if>
			</tr>
			<c:forEach var="education" items="${educationListBean.educationList}">
				<tr>
					<td><c:out value="${education.getDiplomaNumber()}" /></td>
					<td><c:out value="${education.getNameOfSpecialty()}" /></td>
					<td><c:out value="${education.getSpecialtyCode()}" /></td>
					<td><c:out value="${education.getPersonalNumber()}" /></td>
					<c:if test="${currentSign.getSign().getRole() == 'ADMIN'}">
					<td>
						<c:url var="deleteUrl" value="/deleteEducation.jsp">
							<c:param name="diplomaNumber" value="${education.getDiplomaNumber()}" />
							<c:param name="nameOfSpecialty" value="${education.getNameOfSpecialty()}" />
							<c:param name="specialtyCode" value="${education.getSpecialtyCode()}" />
							<c:param name="personalNumber" value="${education.getPersonalNumber()}" />
						</c:url> 
						<c:url var="updateUrl" value="/updateEducation.jsp">
							<c:param name="diplomaNumber" value="${education.getDiplomaNumber()}" />
							<c:param name="nameOfSpecialty" value="${education.getNameOfSpecialty()}" />
							<c:param name="specialtyCode" value="${education.getSpecialtyCode()}" />
							<c:param name="personalNumber" value="${education.getPersonalNumber()}" />
						</c:url>
						<p>
							<a href="${deleteUrl}" class="link" >Delete Education</a>
						</p>
						<p>
							<a href="${updateUrl}" class="link" >Update Education</a>
						</p>
					</td>
					</c:if>
				</tr>
			</c:forEach>
			<c:if test="${currentSign.getSign().getRole() == 'ADMIN'}">
			<tr>
				<td><input type="text" class="type-1" name="diplomaNumber" /></td>
				<td><input type="text" class="type-1" name="nameOfSpecialty" /></td>
				<td><input type="text" class="type-1" name="specialtyCode" /></td>
				<td><input type="text" class="type-1" name="personalNumber" /></td>
				<td><input type="hidden" name="actiontype" value="addEducation" />
					<input type="submit" name="addEducation" class="gradient-button" value="Add Education">
				</td>
			</tr>
			</c:if>
		</table>
	</form>
</body>
</html>