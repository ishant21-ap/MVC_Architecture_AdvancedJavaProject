<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Failure</title>
</head>
<body>
<h1>Registeration Failed !!</h1>
<% String fullname = (String)session.getAttribute("fullname"); %>
<h2>Hey <%= fullname %>, you failed to registered to this web app !</h2>
</body>
</html>