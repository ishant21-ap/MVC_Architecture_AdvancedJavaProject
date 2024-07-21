<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Registeration Successfull !</h1>
<% String fullname = (String)session.getAttribute("fullname"); %>
<h2>Hey <%= fullname %>, you have registered to this web app successfully !</h2>
</body>
</html>