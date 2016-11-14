<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="resources\stylerega.css">
<title>Insert title here</title>
</head>
<body>
<div class="header">

	<ul>		

<li><a href="home">HOME</a></li>
<li><a href="loginpage">LOGIN</a></li>

	</ul>
</div>
<div class="main">
<div class="formreg">
<sf:form  modelAttribute="user" action="registration" method="POST" id="registerform">



<input type="text" name="username" placeholder="username" >
<br>
<br>
 <input type="text" placeholder="password" name="password">
<br>
<br>
<input type="text" placeholder="email" name="email">
<br>
<br>
<input type="text" placeholder="phonenumber" name="phonenumber">
<br>
<br>
<input type="number" placeholder="age" name="age">
<br>
<br>
<input type="text" placeholder="country" name="country">
<br>
<br>
<input type="text" placeholder="city" name="city">
<br>
<br> 
 <textarea   path="description"  placeholder="users description" rows="10" ></textarea>
<br>
<br> 
<input type="submit" value="SAVE">

</sf:form>
</div>
</div>


</body>
</html>