<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Feedback Page</title>
</head>
<body>
<nav class="global-nav">
    <a href="/home">Home</a>
    <a href="/logout">Logout</a>
    <a href="/register">Register</a>
    <a href="/feedback">Feedback</a>
    <a href="/contact-us">Contact Us</a>
</nav>

<h1>Feedback</h1>

<form action="/feedback" method="post">
    <p>Please rate our application:</p>
    <p>
        <input type="radio" id="star1" name="rating" value="1" />
        <label for="star1">1 star</label>

        <input type="radio" id="star2" name="rating" value="2" />
        <label for="star2">2 stars</label>

        <input type="radio" id="star3" name="rating" value="3" />
        <label for="star3">3 stars</label>

        <input type="radio" id="star4" name="rating" value="4" />
        <label for="star4">4 stars</label>

        <input type="radio" id="star5" name="rating" value="5" />
        <label for="star5">5 stars</label>
    </p>

    <p>Please enter your feedback:</p>
    <p><textarea name="feedback" rows="10" cols="30"></textarea></p>

    <input type="submit" value="Submit Feedback" />
</form>

</body>
</html>
