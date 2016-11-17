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

<title>Likes</title>
</head>
<body>

<div class="header">

	<ul>
	<li><sec:authorize access="isAuthenticated()"><sf:form action="editprofile" method="post"><input type="submit" value=" EDIT PROFILE" id="submitlogout"></sf:form></sec:authorize></li>		
<li><a href="home">HOME</a></li>
<li><sec:authorize access="isAuthenticated()"><a href="profile">PROFILE</a></sec:authorize></li>
	</ul>
</div>
<div id="users">
<table>
 <c:forEach items="${users}" var="user"> 
<tr>
<td>${user.getOriginUsername()}</td>

</tr>
</c:forEach> 
</table>
</div>

<div class="button"><a href="creatework" > Create new work</a></div>

</body>
</html>