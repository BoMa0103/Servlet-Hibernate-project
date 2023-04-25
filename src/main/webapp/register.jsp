<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log in</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<jsp:useBean id="signBean" class="ua.cn.stu.databean.SignDatabean"/>
	
	<div class="col-lg-6">
              <nav class="two">
                 <ul class="menu">
                  <li class="menu__item">
                    <a href="register.jsp" class="menu-link">Log in</a>
                  </li>
                  <li class="menu__item">
                    <a href="sign.jsp" class="menu-link">Sign in</a>
                  </li>
                </ul>
              </nav>
            </div>
            
	<form method="post" action="sign">
	<h1 class="text-center">Log in</h1>
		<table style="width: 80%; margin: 0 auto;" border="1">
			<tr>
				<td>Login</td>
				<td>Password</td>
				<td>Actions</td>
			</tr>
			<tr>
				<td><input type="text" class="type-1" name="login" /></td>
				<td><input type="text" class="type-1" name="password" /></td>
				<td><input type="hidden" name="actiontype" value="logIn" />
					<input type="submit" name="logIn" class="gradient-button" value="Log in">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>