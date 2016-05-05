<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Your Followers</title>
<link rel="stylesheet" type="text/css"
	href="/FCISquareApp/stylesheet/style.css">
</head>
<body>
<!-- 	<header> -->
<!-- 	<h1>FCISquare</h1> -->
<!-- 	<form class="search"> -->
<!-- 		<input type="text" name="firstname" value=""> -->
<!-- 	</form> -->
<!-- 	<img class="searchlogo" src="/FCISquareApp/pic/search.png">  -->
<!-- 	<%-- 	<h3>${it.name}</h3> --%> --!>
<!-- 	<h3>User</h3> -->
<!-- 	<img class="home" src="/FCISquareApp/pic/home.png"> <img -->
<!-- 		class="log" src="/FCISquareApp/pic/logout.png"> </header> -->
	<div class="FollowersList">
		<table>
			<tr>
				<td class="myCheckinsTitle">My Followers</td>
			</tr>
			<c:forEach var="i" begin="0" end="${it.size()-1}" step="1">

				<tr>
					<td>${it.val}</td>
				</tr>
			</c:forEach>
		</table>

	</div>
</body>
</html>