<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<<<<<<< HEAD
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>


<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>home</title>
<link rel="stylesheet" type="text/css"
	href="/FCISquareApp/stylesheet/style.css">
<link href='https://fonts.googleapis.com/css?family=Berkshire+Swash'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Open+Sans+Condensed:300'
	rel='stylesheet' type='text/css'>

</head>


<body>
	<header>
	<h1>FCISquare</h1>
	<form class="search">
		<input type="text" name="firstname" value="">
	</form>
	<img class="searchlogo" src="/FCISquareApp/pic/search.png">
	<h3>${it.name}</h3>
	<img class="home" src="/FCISquareApp/pic/home.png"> <img
		class="log" src="/FCISquareApp/pic/logout.png"> </header>

	<div class="sideBar">

		<table>

			<tr>
				<td><a href="/FCISquareApp/app/CheckIn"> <img
						src="/FCISquareApp/pic/checkin.png">
				</a></td>

				<td><a href="/FCISquareApp/app/AddPlace"> <img
						src="/FCISquareApp/pic/addplace.png">
				</a></td>

			</tr>

			<tr>
				<td><a href="/FCISquareApp/app/LastPositionForm"> <img
						src="/FCISquareApp/pic/last.png">
				</a></td>
				<td><a href="/FCISquareApp/app/SavePlace"> <img
						src="/FCISquareApp/pic/save.png">
				</a></td>
			</tr>

			<tr>
				<td><a href="/FCISquareApp/app/Follow"> <img
						src="/FCISquareApp/pic/follow.png">
				</a></td>
				<td><a href="/FCISquareApp/app/Unfollow"> <img
						src="/FCISquareApp/pic/unfollow.png">
				</a></td>

			</tr>
			<tr>
				<td><a href="/FCISquareApp/app/getfollows"> <img
						src="/FCISquareApp/pic/getfollowers.png">
				</a></td>
				<td><a href="/FCISquareApp/app/mynotifications"> <img
						src="/FCISquareApp/pic/notification.png">
				</a></td>
			</tr>

			<tr>
				<td>
					<form action="History" method="post">
						<button class="HistoryStyle" name="submit">H</button>
						<br>
					</form>
				</td>
			</tr>
			<tr>
			</tr>
			<tr>
			</tr>


		</table>
	</div>

	<div class="checkinOptions">
		<form action="doGetCheckIn" method="post">

			<input class="option1" type="radio" name="Id" value="1" checked>
			<span class="sortStyle1">Sort by Date</span> <input class="option2"
				type="radio" name="Id" value="2" checked> <span
				class="sortStyle2">Sort by Location </span>
			<button class="ShowCheckins" name="submit">Show Checkins</button>
		</form>

	</div>


=======
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Insert title here</title>
</head>
<body>
	<p>Welcome b2a ya ${it.name} :D :D </p>
	<p>This is should be user home page</p>
	<p> You can show your current position on map and update your position on our database from <a href="/FCISquareApp/app/showLocation"> here</a>
	
	<p>Current implemented services
		"http://se2firstapp-softwareeng2.rhcloud.com/FCISquare/rest/signup ---
		{requires: name, email, pass}"</p>
	<p>and "http://se2firstapp-softwareeng2.rhcloud.com/FCISquare/rest/login ---
		{requires: name, pass}"</p>
	<p>and "http://se2firstapp-softwareeng2.rhcloud.com/FCISquare/rest/updatePosition ---
		{requires: id, lat, long}"</p>
	<p> All parameters are post parameters </p> 
	<form action = "dofollow" method = "post" >
	
	Email <input type="text" name = "email" /> <br>
	<input type="submit" value = "follow" /> 



</form>
	<p>you should implement Follow,	UnFollow, getFollowers and getLastPositionOfUser services </p>
>>>>>>> 3a7cab454d0e0e3232dcf96c9454550fd7c1acbe
</body>
</html>