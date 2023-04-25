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
                </ul>
              </nav>
            </div>
            
	<h1 class="deleteText">Delete department page</h1>
	<div class="form1">
	<div class="deleteform">
		<p class="font1">Below department will be deleted:</p>
		<p>Department number: ${param.departmentNumber}</p>
		<p>Address: ${param.address}</p>
		<p>Phone: ${param.phone}</p>
		<p>Working Days: ${param.workingDays}</p>
		<p>Start Of Work: ${param.startOfWork}</p>
		<p>End Of Work: ${param.endOfWork}</p>
		<c:url var="departmentUrl" value="/department.jsp" />
		<form method="post" action="department" class="formdelete">
			<input type="hidden" name="actiontype" value="deleteDepartment" /> <input
				type="hidden" name="departmentNumber" value="${param.departmentNumber}"> <input
				type="submit" name="deleteDepartment" class="gradient-button" value="Delete department"> <input
				type="button" onclick="window.location.href='${departmentUrl}'"
				class="gradient-button-cancel" value="Cancel">
		</form>
	</div>
	</div>
</body>
</html>