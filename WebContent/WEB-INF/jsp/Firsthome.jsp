<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Sort Check ins</title>
<link rel="stylesheet" type="text/css"
	href="/FCISquareApp/stylesheet/style.css">
</head>
<body>
	<form action="doGetCheckIn" method="post">

		<label>Enter 1 if you want your checkins sorted by date and 2
			if you want your checkins sorted by location </label> <input type="text"
			name="Id" /> <br>

		<div class="section">

			<button name="submit">show</button>

		</div>
	</form>
</body>
</html>