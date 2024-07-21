<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Already Exists</title>
</head>
<body>
    <h1>Registration Failed!</h1>
    <% String email = (String) session.getAttribute("email"); %>
    <h2>User with this <%= email %> already exists.</h2>
</body>
</html>
