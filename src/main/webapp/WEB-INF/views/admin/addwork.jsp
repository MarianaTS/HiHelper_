<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
    
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


<div class="maincontent">
<sf:form  modelAttribute="work"  action="addnewwork" method="POST">
<input type="text" name="title" placeholder="title" >
<br>
<br>
<input type="text" name="price" placeholder="price" >
<br>
<br>
 <input type="date" name="startdate" placeholder="beginning date" >
<br>
<br>
<!--<input type="time" name="starttime" placeholder="beginning time" >
<br>
<br> -->
<input type="text" name="type" placeholder="type" >
<br>
<br>

<input type="submit" value="SAVE">

</sf:form>


</div>
<div class="footer"></div>


</body>
</html>