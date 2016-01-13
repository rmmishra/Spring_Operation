<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
  <%@include file="header.jsp" %>
  
  <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${msg}
<center><h2>User Register Form</h2></center>
<center>
<form:form action="registeruserinfo.do" methodParam="POST" modelAttribute="UserData" autocomplete="off">
<table>
<p><form:errors path="firstName"></form:errors></p>
<tr><th align="left">User First Name</th><td><form:input path="firstName" size="40"  /></td></tr>
<p><form:errors path="lastName"></form:errors></p>
<tr><th align="left">User Last Name</th><td><form:input  path="lastName"  size="40" /></td></tr>
<p><form:errors path="sex"></form:errors></p>
<tr><th align="left">Sex</th><td><form:input  path="sex"  size="40"/></td></tr>
<p><form:errors path="phoneNo"></form:errors></p>
<tr><th align="left">Phone No</th><td><form:input  path="phoneNo"  size="40" /></td></tr>
<p><form:errors path="email"></form:errors></p>
<tr><th align="left">Email Id</th><td><form:input  path="email"  size="40" /></td></tr>
<p><form:errors path="address"></form:errors></p>
<tr><th align="left">Address</th><td><form:input  path="address"  size="40" /></td></tr>
<p><form:errors path="pwd"></form:errors></p>
<tr><th align="left">Password</th><td><form:input  path="pwd"  size="40" /></td></tr>

<tr><th align="right" colspan="2"><input type="submit" value="Submit" /></th></tr>

</table>
</form:form>
</center>
</body>
</html>

<%@include file="footer.jsp" %>