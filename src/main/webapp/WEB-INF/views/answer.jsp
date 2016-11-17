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

<table>
				<tr>
<td>${work.title}</td>
<td>${work.type }</td>
<td>${work.price}</td>
<td>
<p>${work.country}</p>
<p>${work.city}</p>
<p>${work.street}</p>
<p>${work.building}</p>
</td>
				</tr>


		</table>
<sf:form   action="answertoappointmentr" method="GET" id="registerform">


send to: ${client.getOriginUsername()}

<br>
<br>
<input type="email"  name="client_email" value="${client.email}" >
<input type="password"  name="password" placeholder="password from your email" required>
 <textarea   name="text"  placeholder="Add your message" rows="10" ></textarea>
 <br>
<br>
 
 from:
 ${sender.getOriginUsername()}
<br>
<br> 
<input type="submit" value="SEND">

</sf:form>
</div>
</div>


</body>
</html>