<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Comment</title>
<link rel="stylesheet" type="text/css"
	href="/FCISquareApp/stylesheet/style.css">
</head>
<body>
<div class="All">
		<center>
			<p name="head">
				<b> FCISquare</b>
			</p>
			<h1>Comment</h1>
		

		<form action="doComment" method="post">
			<label>CheckInId </label> <input type="text" name="CheckInId" /> <br>
			<label>CommentText </label> <input type="text" name="CommentText" /> <br>
			
			   <div class="section">

						<button name="submit">Comment</button>
				
			</div>
			   </form>
		</center>
	</div>
</body>
</html>