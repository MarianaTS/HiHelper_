<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
         <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
        <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="resources\style.css">

    <title>HIHelper</title>

</head>

<body>
<div class="header">
<sec:authorize access="isAuthenticated()">
<div class="userdet">
	
<img src="photo.jpg" alt="your img">

</div>
</sec:authorize>
<div class="logo">
	<img src="https://logomakr.com/download.php?id=732hUX" alt="HIHelper">
</div>

	<ul>
		
<sec:authorize access="isAuthenticated()">
<li><sf:form action="logout" method="post">
<input type="submit" value=" LOGOUT" id="submitlogout">
</sf:form>
</li>
<li><a href="profile">PROFILE</a></li>
</sec:authorize>
<sec:authorize access="!isAuthenticated()">
<li><a href="loginpage">LOGIN</a><li>
</sec:authorize>
		<li><sec:authorize access="hasRole('ROLE_ADMIN')"><a href="adminpage">ADMIN PAGE</a></sec:authorize></li>
	</ul>



</div>
<div class="main">
	
<div id="logo-text">
	
<p>SAVE YOUR TIME </p>
<div class="buttonstart" ><a href="allworks">START</a></div>
</div>

</div>


</body>
</html>