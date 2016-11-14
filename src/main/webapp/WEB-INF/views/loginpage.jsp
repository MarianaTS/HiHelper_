<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="resources\stylerega.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Log in</title>
</head>
<body>

<div class="header">

	<ul>		
<li><a href="registration">REGISTRATE</a></li>
<li><a href="home">HOME</a></li>


	</ul>
</div>
<div class="mainl">
<div class="formlogin">
<sf:form   action="loginprocesing"  method="POST">

<input type="text" name="username" placeholder="username" >
<br>
<br>
 <input type="password" placeholder="password" name="password">
<br>
<br>
 
<input type="submit" value="LOG IN">

</sf:form>
</div>
</div>




</body>
</html>