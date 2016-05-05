<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>My CheckIns</title>
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
	<img class="searchlogo" src="/FCISquareApp/pic/search.png"> <%-- 	<h3>${it.name}</h3> --%>
	<h3>User</h3>
	<img class="home" src="/FCISquareApp/pic/home.png"> <img
		class="log" src="/FCISquareApp/pic/logout.png"> 
</header>
 <center>
			
<h1 class="IN">Check In</h1>
</center>
<img class="checkinPage" src="/FCISquareApp/pic/checkinPage.png">
		
	<div class="chechForm">
		
		

		<form action="doCheckIn" method="post">
			<label class="Nlable">Name </label> <input type="text" name="name" /> <br>

			<div class="section">

				<button class="Bcheckin" name="submit">check_in</button>

		</div>
		</form>
	</div>
</body>
</html>