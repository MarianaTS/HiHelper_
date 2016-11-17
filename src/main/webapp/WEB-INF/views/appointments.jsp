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

<title>Appointsments</title>
</head>
<body>

<div class="header">

	<ul>
<li><a href="home">HOME</a></li>
<li><sec:authorize access="isAuthenticated()"><sf:form action="logout" method="post"><input type="submit" value=" LOGOUT" id="submitlogout"></sf:form></sec:authorize></li>
	</ul>
</div>

<div class="main ">
	<div class="userdet">
<p>${user.getOriginUsername()} </p>

</div>
<div class="works">
<table>
<tr>
<td>${work.title}</td>
<td>${work.price}</td>
<td>
<p>${work.country}</p>
<p>${work.city}</p>
<p>${work.street}</p>
<p>${work.building}</p>

</td>
</tr>
</table>
<table>
<c:forEach items="${appointments}" var="app">
<tr>



<td><p>${app.messagetext}</p> </td>
<td><p>${app.sender.getOriginUsername()}</p>
    <p>${app.sender.email}</p>  </td>





<td><sf:form action="answer" method="GET">
					<input type="hidden" name="id_client" value="${app.sender.id}"/>
					<input type="hidden" name="id_work" value="${work.id}"  />
					<input type="submit"  value="ANSWERE">
					</sf:form>  </td>

<td><sf:form action="deleteapp" method="GET">
					<input type="hidden" name="id" value="${work.id}"/>
					<input type="hidden" name="app_id" value="${app.id}"  />
					<input type="submit"  value="DELETE">
					</sf:form>  </td>
					</tr>
</c:forEach>

</table>
</div>
</div>


</body>
</html>