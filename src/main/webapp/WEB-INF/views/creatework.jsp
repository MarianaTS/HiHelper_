
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="resources\stylerega.css">
<title>Create service</title>
</head>
<body>
<div class="header">

	<ul>		
<li><a href="profile">PROFILE</a></li>
<li><a href="home">HOME</a></li>



	</ul>
</div>
<div class="main">
<div class="formreg">
<sf:form  modelAttribute="work"  action="createnewwork" method="GET">
<input type="text" name="title" placeholder="title" >
<br>
<br>
<input type="text" name="price" placeholder="price" >
<br>
<br>
<input type="text" name="type" placeholder="type" >
<br>
<br>
<input type="text" name="country" placeholder="country" >
<br>
<br>

<input type="date" name="startdate" placeholder="date" >
<br>
<br>
<input type="time" name="starttime" placeholder="time" >
<br>
<br>
<input type="text" name="city" placeholder="city" >
<br>
<br>
<input type="text" name="street" placeholder="street" >
<br>
<br>
<input type="number" name="building" placeholder="building" >
<br>
<br>
<input type="submit" value="SAVE">

</sf:form>
</div>
</div>


</body>
</html>