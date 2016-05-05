<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<title>FCISquare Application</title>
<link rel="stylesheet" href="/FCISquareApp/stylesheet/login.css">
</head>

<body>
	<div class="All">
		<center>
			
			<h1>Login now</h1>
		</center>


		<form action="doLogin" method="post">
			<label>Email</label>    <input type="text" name="email" /> <br> 
			<label>Password:</label><input type="password" name="pass" /> <br>
			
			<div class="section">

				<p name1="ab1">
					<a href="/FCISquareApp/app/"><button>Login</button></a>
				</p>
			</div>
		</form>

		<h2 name="ab">
			<bolder> Don't have an account?, Sign Up</bolder>
			<a href="/FCISquareApp/app/signUp"> here</a>
		</h2>
	</div>

</body>

</html>