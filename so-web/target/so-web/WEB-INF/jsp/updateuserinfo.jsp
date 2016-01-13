<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@include file="header.jsp" %>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${msg}
<%
//int n=1;
%>
<%-- <center>
<table border="2">
<tr><th>S_NO</th><th>User First Name</th><th>User Last Name</th><th>User Sex</th><th>Phone No</th><th>Email Id</th><th>Address</th><th>Delete</th>
<c:forEach items="${userList}" var="userData">
<tr><td><%=n++%></td><td>${userData.firstName}</td><td>${userData.lastName}</td><td>${userData.sex}</td><td>${userData.phoneNo}</td><td>${userData.email}</td><td>${userData.address}</td><td><a href="deleteuserinfo.do?userId=${userData.userId}">Delete_User</a></td></tr>
</c:forEach>
</table>
</center> --%>
<br/><br/>

 <center><h2>Update User Information</h2></center>
<center>
<form:form action="updateuserinfo.do" methodParam="POST" modelAttribute="UserData" autocomplete="off">
<table>
<p><form:errors path="userId"></form:errors></p>
<tr><th align="left">User ID</th><td><form:input path="userId" size="40"  /></td></tr>
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

<tr><th align="right" colspan="2"><input type="submit" value="Submit" /></th></tr>

</table>
</form:form>
</center>
</body>
</html>

<%@include file="footer.jsp" %>