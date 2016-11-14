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
<li><a href="profile">PROFILE</a></li>

	</ul>
</div>
<div class="main">
<div class="formreg">
<sf:form modelAttribute="user" action="editthisuser" method="POST" >

		<input type="text" placeholder="email" name="email" value="${user.getEmail()}">
		<br>
		<br>
		<input type="text" placeholder="phonenumber" name="phonenumber" value="${user.getPhonenumber()}">
		<br>
		<br>
		<input type="number" placeholder="age" name="age" value="${user.getAge()}">
		<br>
		<br>
		<input type="text" placeholder="country" name="country" value="${user.getCountry()}">
		<br>
		<br>
		<input type="text" placeholder="city" name="city" value="${user.getCity()}">
		<br>
		<br>
		<textarea path="description" placeholder="users description" rows="10" value="${user.getDescription()}"></textarea>
		<br>
			<input type="submit" value="SAVE">
		</sf:form>
		<%-- <br>
			</sf:form>
	<sf:form action="./saveImage?${_csrf.parameterName}=${_csrf.token}"
		method="POST" enctype="multipart/form-data">
		<input type="file" name="image">
		<button >ADD PHOTO</button>
	</sf:form> --%>
	<br>
	



</div>
</div>


</body>
</html>




