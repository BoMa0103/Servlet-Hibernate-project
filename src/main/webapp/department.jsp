<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Department list</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<jsp:useBean id="departmentListBean" class="ua.cn.stu.databean.DepartmentListDatabean"/>
	<jsp:useBean id="currentSign" class="ua.cn.stu.databean.SignDatabean"/>
	  
	  <div class="col-lg-6">
              <nav class="two">
                <ul class="menu">
                  <li class="menu__item">
                    <a href="department.jsp" class="menu-link">Department</a>
                  </li>
                  <c:if test="${currentSign.getSign().getRole() == 'ADMIN' || currentSign.getSign().getRole() == 'MANAGER'}">
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
            
	<form method="post" action="department">
	<h1 class="text-center">Department page</h1>
		<table style="width: 80%; margin: 0 auto;" border="1">
			<tr>
				<td class="col1">Department number</td>
				<td>Address</td>
				<td>Phone</td>
				<td>Working days</td>
				<td>Start of work</td>
				<td>End of work</td>
				<c:if test="${currentSign.getSign().getRole() == 'ADMIN'}"><td>Actions</td></c:if>
			</tr>
			<c:forEach var="department" items="${departmentListBean.departmentList}">
				<tr>
					<td><c:out value="${department.getDepartmentNumber()}" /></td>
					<td><c:out value="${department.getAddress()}" /></td>
					<td><c:out value="${department.getPhone()}" /></td>
					<td><c:out value="${department.getWorkingDays()}" /></td>
					<td><c:out value="${department.getStartOfWork()}" /></td>
					<td><c:out value="${department.getEndOfWork()}" /></td>
					<c:if test="${currentSign.getSign().getRole() == 'ADMIN'}">
					<td>
						<c:url var="deleteUrl" value="/deleteDepartment.jsp">
							<c:param name="departmentNumber" value="${department.getDepartmentNumber()}" />
							<c:param name="address" value="${department.getAddress()}" />
							<c:param name="phone" value="${department.getPhone()}" />
							<c:param name="workingDays" value="${department.getWorkingDays()}" />
							<c:param name="startOfWork" value="${department.getStartOfWork()}" />
							<c:param name="endOfWork" value="${department.getEndOfWork()}" />
						</c:url> 
						<c:url var="updateUrl" value="/updateDepartment.jsp">
							<c:param name="departmentNumber" value="${department.getDepartmentNumber()}" />
							<c:param name="address" value="${department.getAddress()}" />
							<c:param name="phone" value="${department.getPhone()}" />
							<c:param name="workingDays" value="${department.getWorkingDays()}" />
							<c:param name="startOfWork" value="${department.getStartOfWork()}" />
							<c:param name="endOfWork" value="${department.getEndOfWork()}" />
						</c:url>
						<p>
							<a href="${deleteUrl}" class="link" >Delete department</a>
						</p>
						<p>
							<a href="${updateUrl}" class="link" >Update department</a>
						</p>
					</td>
					</c:if>
				</tr>
			</c:forEach>
			<c:if test="${currentSign.getSign().getRole() == 'ADMIN'}">
			<tr>
				<td><input type="text" class="type-1" name="departmentNumber" /></td>
				<td><input type="text" class="type-1" name="address" /></td>
				<td><input type="text" class="type-1" name="phone" /></td>
				<td><input type="text" class="type-1" name="workingDays" /></td>
				<td><input type="time" class="date1" step="2"
                    min="00:00" max="23:59" name="startOfWork" /></td>
				<td><input type="time" class="date1" step="2"
                    min="00:00" max="23:59" name="endOfWork" /></td>
				<td><input type="hidden" name="actiontype" value="addDepartment" />
					<input type="submit" name="addDepartment" class="gradient-button" value="Add department">
				</td>
			</tr>
			</c:if>
		</table>
	</form>
	
	<h1 class="text-center" style="margin-top: 100px;">Department employees</h1>
	<table style="width: 80%; margin: 0 auto;" border="1">
			<tr>
				<td class="col1">Department number</td>
				<td>Employee count</td>
			</tr>
			<c:forEach var="departmentEmployees" items="${departmentListBean.departmentEmployeesList}">
				<tr>
					<td><c:out value="${departmentEmployees[0]}" /></td>
					<td><c:out value="${departmentEmployees[1]}" /></td>
				</tr>
			</c:forEach>
		</table>
	
</body>
</html>