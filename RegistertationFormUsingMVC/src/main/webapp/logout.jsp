<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    session.invalidate(); // Invalidate the session to log out the user
    response.sendRedirect("login.html"); // Redirect to login page
%>
