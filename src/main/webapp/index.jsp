<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<title>JSP - Hello World</title>
	</head>
	<body>
		<h1><%= "Hello World!" %></h1>
		<br/>
		<form method="post" action="hello-servlet">
			Username: <input type="text" name="username" />
			<br />
			Password: <input type="password" name="password" />
			<br />
			<input type="submit" />
		</form>
		<br />
		<%
			String problem = (String)request.getAttribute("problem");
			if (problem!=null && problem.equals("incorrect-login")) {
                out.println("<p>Incorrect Username of Password</p>");
			}
		%>
	</body>
</html>