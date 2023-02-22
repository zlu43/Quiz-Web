<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<nav class="global-nav">
    <a href="/home">Home</a>
    <a href="/login">Login</a>
    <a href="/register">Register</a>
    <a href="/feedback">Feedback</a>
    <a href="/contact-us">Contact Us</a>
</nav>


<h2>Login</h2>
<form action="/login" method="post">
    <table>
        <tr>
            <td>Username:</td>
            <td><input type="text" name="username" placeholder="Username" /></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="password" placeholder="Password"/></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="Login" />
            </td>
        </tr>
    </table>
</form>
<br>
<a href="/register">Create an Account Here</a>
</body>
</html>
