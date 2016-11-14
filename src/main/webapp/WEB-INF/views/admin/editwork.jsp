<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="us" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="header">

<h1>HIHelper</h1>
<ul class="log">
<li><a href="LOG IN"></a></li>
<li><a href="LOG OUT"></a></li>

</ul>

</div>

<div class="sidebar">
<ul class="menu">
<li class="elements"><a href="actitvity">Activity</a></li>
<li class="elements"><a href="messages">Messages</a></li>
</ul>
<ul class="menu">
<li>Editing</li>
<li class="elements"><a href="adduser">Add user</a></li>
<li class="elements"><a href="edituser">Edit user</a></li>
<li class="elements"><a href="addwork">Add work</a></li>
<li class="elements"><a href="editwork">Edit work</a></li>
</ul>
</div>


<table>
<th>Work ID</th>
<th>Work title</th>
<us:forEach   items="${works}" var="work" >

<tr>
<td>${work.id}</td>
<td>${work.title}</td>
<td><a class="delete" href="delwork/${work.id}">delete</a></td>
</tr>
</us:forEach>
</table>





</div>
<div class="footer"></div>





</body>
</html>