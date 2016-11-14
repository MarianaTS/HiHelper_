<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
         <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
        <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="resources\styleprof.css">

<title>Insert title here</title>
</head>
<body>

<div class="header">

	<ul>
	<li><sec:authorize access="isAuthenticated()"><sf:form action="editprofile" method="post"><input type="submit" value=" EDIT PROFILE" id="submitlogout"></sf:form></sec:authorize></li>		
<li><a href="home">HOME</a></li>
<li><sec:authorize access="isAuthenticated()"><sf:form action="logout" method="post"><input type="submit" value=" LOGOUT" id="submitlogout"></sf:form></sec:authorize></li>



	</ul>
</div>

<div class="main">
	<div class="userdet">
	
<img src="http://media.mnn.com/assets/images/2016/02/angry-cat.jpg.838x0_q80.jpg" alt="your img">
<p>${user.getOriginUsername()} </p>

</div>
<div class="infouser">
	
<table>
	<tr>
		<td>Age: </td>
		<td>${user.age}</td>
	</tr>
	<tr>
		<td>City: </td>
		<td>${user.city}</td>
	</td>
	<tr>
		<td>Country: </td>
		<td>${user.country}</td>
	</td>
	<tr>
		<td>Email: </td>
		<td>${user.email}</td>
	</tr>
	<tr>
		<td>Phonenumber: </td>
		<td>${user.phonenumber}</td>
	</tr>
	<tr>
		<td>Description: </td>
		<td>${user.description}</td>
	</tr>
</table>

</div>
</div>



<div class="works">
<h2>My works</h2>

<table>
<c:forEach items="${works}" var="work">
<tr>

<td>${work.title}</td>
<td>${work.type }</td>
<td>${work.price}</td>
<td>${work.startdate}</td>
<td>${work.starttime}</td>
<td><a href="./deletework/${work.id}">delete</a></td>

<td><a href="wholikes" id="like"><img src="http://www.rsinfrafacility.com/wp-content/uploads/2015/10/512.png" width="20px" height="20px"> ${work.count}</a></td>

</tr>

</c:forEach>

</table>


<div class="button"><a href="creatework" > Create new work</a></div>
</div>
</body>
</html>