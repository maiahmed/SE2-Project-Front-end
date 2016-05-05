<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Save Place</title>
<link rel="stylesheet" type="text/css"
	href="/FCISquareApp/stylesheet/style.css">
</head>
<body>
	<header>
	<h1>FCISquare</h1>
	<form class="search">
		<input type="text" name="firstname" value="">
	</form>
	<img class="searchlogo" src="/FCISquareApp/pic/search.png"> <%-- 	<h3>${it.name}</h3> --%>
	<h3>User</h3>
	<img class="home" src="/FCISquareApp/pic/home.png"> <img
		class="log" src="/FCISquareApp/pic/logout.png"> </header>

	<div class="All">
		<center>
			<p name="head">
				<b> FCISquare</b>
			</p>
			<h1>Save Place Now</h1>


			<form action="doSavePlace" method="post">
				<label>Place ID </label> <input type="text" name="placeid" /> <br>

				<div class="section">

					<button name="submit">Save Place</button>

				</div>
			</form>
		</center>
	</div>

</body>
</html>