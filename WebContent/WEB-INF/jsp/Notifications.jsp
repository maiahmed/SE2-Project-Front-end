<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Home</title>

<link rel="stylesheet" type="text/css"
	href="/FCISquareApp/stylesheet/style.css">
</head>
<body>
<!--  <header> -->
<!-- 	  <h1>FCISquare</h1> -->
<!-- 	<form class="search"> -->
<!-- 		<input type="text" name="firstname" value=""> -->
<!-- 	</form> -->
<%-- 	<img class="searchlogo" src="/FCISquareApp/pic/search.png"> 	<h3>${it.name}</h3> --%>
<!-- 	<h3>User</h3> -->
<!-- 	<img class="home" src="/FCISquareApp/pic/home.png"> <img -->
<!-- 		class="log" src="/FCISquareApp/pic/logout.png">  -->
<!-- </header> -->

	<table>
		<tr>
			<td class="myCheckinsTitle">Notifications</td>
		</tr>
		<c:forEach var="i" begin="0" end="${it.size()-1}" step="4">

			<tr>
				<td class="postX"><c:out value="${it[i]}" /> made <c:out
						value="${it[i+1]}" /> on <c:out value="${it[i+2]}" /></td>
				<td>
					<form action="showCheckin" method="post">

						<input id="id" type="hidden" name="id" value=${it[i+3] } /> <input class="submitVal"
							type="submit" value="show" />
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>