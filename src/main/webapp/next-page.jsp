<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Home Page</title>
</head>
<body>
	<h1>Welcome <%= request.getParameter("username") %></h1>
</body>
</html>
