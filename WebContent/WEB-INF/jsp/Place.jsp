<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Place</title>
<link rel="stylesheet" type="text/css"
	href="/FCISquareApp/stylesheet/style.css">
	<link rel="stylesheet" type="text/css"
	href="/FCISquareApp/stylesheet/input.css">
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
		class="log" src="/FCISquareApp/pic/logout.png"> 
</header>
         <center>
	     	<h1 class="IN">Add Place Now</h1>
		</center>
	<div class="Aplace">
		

		<form action="doAddPlace" method="post">
			<label for="fname">Place name</label>
    <input type="text" name="name">

    <label for="lname">Place discroption</label>
    <input type="text" name="description" >

    <label for="country">lat</label>
    <input type="text" name="lat">
     <label for="country">long</label>
    <input type="text" name="long">
    <input type="submit" value="Submit">
		</form>
	</div>
</body>
</html>