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
<sf:form modelAttribute="work" action="./editthiswork/${work.id}" method="POST" >

<input type="text" name="title" placeholder="title" value="${work.getTitle()}">
<br>
<br>
<input type="text" name="price" placeholder="price" value="${work.getPrice()}">
<br>
<br>
 <input type="date" name="startdate" placeholder="beginning date" value="${work.getStartdate()}">
<br>
<br>
<input type="time" name="starttime" placeholder="beginning time" value="${work.getStarttime()}" >
<br>
<br>
<input type="text" name="type" placeholder="type"  value="${work.getType()}">
<br>
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




