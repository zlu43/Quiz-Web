<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Contact Us</title>
</head>
<body>
<nav class="global-nav">
    <a href="/home">Home</a>
    <a href="/logout">Logout</a>
    <a href="/register">Register</a>
    <a href="/feedback">Feedback</a>
    <a href="/contact-us">Contact Us</a>
</nav>


<h1>Contact Us</h1>

<form action="/contact-us" method="post">
    <p>Name:</p>
    <p><input type="text" name="name"></p>

    <p>Email:</p>
    <p><input type="email" name="email"></p>

    <p>Message:</p>
    <p><textarea name="message" rows="10" cols="30"></textarea></p>

    <input type="submit" value="Send Message" />
</form>

</body>
</html>
