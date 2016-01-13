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
<center><h2>User Login Form</h2></center>
<center>
<form:form action="loginuser.do" methodParam="POST" modelAttribute="UserData" autocomplete="off">
<table>
<tr><th align="left">Email_ID</th><td><form:input path="email" size="40" /></td></tr>
<tr><th align="left">Password</th><td><form:password path="pwd" size="40" /></td></tr>

<tr><th align="right" colspan="2"><input type="submit" value="Login" /></th></tr>

</table>
</form:form>
</center>
</body>
</html>

<%@include file="footer.jsp" %>