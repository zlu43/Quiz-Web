<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Page</title>
</head>
<body>
<nav class="global-nav">
    <a href="/home">Home</a>
    <a href="/logout">Login</a>
    <a href="/register">Register</a>
    <a href="/feedback">Feedback</a>
    <a href="/contact-us">Contact Us</a>
</nav>


<h1>Create a New Account</h1>
<form action="/register" method="post">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" placeholder="Username" required><br><br>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" placeholder="Password" required><br><br>

    <label for="firstname">First Name:</label>
    <input type="text" id="firstname" name="firstname" placeholder="Firstname" required><br><br>

    <label for="lastname">Last Name:</label>
    <input type="text" id="lastname" name="lastname" placeholder="Lastname" required><br><br>

    <label for="phone">Phone:</label>
    <input type="text" id="phone" name="phone" placeholder="Phone" required><br><br>

    <label for="email">Email:</label>
    <input type="text" id="email" name="email" placeholder="Email" required><br><br>

    <label for="address">Address:</label>
    <input type="text" id="address" name="address" placeholder="Address" required><br><br>

    <input type="submit" value="Register">
    <a href="/login">Back to Login</a>
</form>
</body>
</html>
