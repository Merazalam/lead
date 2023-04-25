<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="editLead" method="post">
<pre>
<input type="hidden" name="id" value="${lead.id}"/>
firstName<input type="text" name="firstName" value="${lead.firstName}"/>
lastName<input type="text" name="lastName"  value="${lead.lastName}"/>
email<input type="text" name="email"   value="${lead.email}"/>
mobile<input type="text" name="mobile" value="${lead.mobile}"/>
<input type="submit" value="update"/>
</pre>
</form>
</body>
</html>