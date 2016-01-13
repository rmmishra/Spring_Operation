<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    <%@include file="header.jsp" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
${msg}
<br/>
<%
int n=1;

%>
<table border="2">
<tr><th>S_NO</th><th>User First Name</th><th>User Last Name</th><th>User Sex</th><th>Phone No</th><th>Email Id</th><th>Address</th><th>Delete</th>
<c:forEach items="${userList}" var="userData">
<tr><td><%=n++%></td><td>${userData.firstName}</td><td>${userData.lastName}</td><td>${userData.sex}</td><td>${userData.phoneNo}</td><td>${userData.email}</td><td>${userData.address}</td><td><a href="deleteuserinfo.do?userId=${userData.userId}">Delete_User</a></td></tr>
</c:forEach>
</table>
</center>
</body>
</html>
<%@include file="footer.jsp" %>