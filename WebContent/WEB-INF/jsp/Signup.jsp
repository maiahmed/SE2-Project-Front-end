<%@ page language="java" contentType="text/html; charset=windows-1256"
<<<<<<< HEAD
	pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>FCISquare Application</title>
<link rel="stylesheet" type="text/css" href="/FCISquareApp/stylesheet/signup.css">

</head>
<body>

	<div class="All">
		<center>
			<p name="head">
				<b> FCISquare</b>
			</p>
			<h1>SignUp now</h1>
		</center>

		<form action="doSignUp" method="post">
			<label>name </label> <input type="text" name="name" /> <br>
			<label>email </label> <input type="text" name="email" /> <br>
		    <label>pass </label> <input type="password" name="pass" /> <br>

            <div class="section">

				<p name1="ab1">
			 <a href="/FCISquareApp/app/"><button>SignUp</button></a>
				</p>
			</div>

		</form>
		<h2 name="ab">
			<bolder> if you already have an account?, Login</bolder>
			<a href="/FCISquareApp/app/"> here</a>
		</h2>
	</div>
=======
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>FCISquare Application</title>
</head>
<body>

<form action = "doSignUp" method = "post">
	
	name : <input type = "text" name = "name" /> <br>
	email : <input type = "text" name = "email" /> <br>
	pass : <input type = "password" name = "pass" /> <br>
	
	<input type = "submit" value = "Signup" />
	
</form>
>>>>>>> 3a7cab454d0e0e3232dcf96c9454550fd7c1acbe

</body>
</html>