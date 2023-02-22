<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Question</title>
</head>
<body>
<nav class="global-nav">
    <a href="/home">Home</a>
    <a href="/logout">Logout</a>
    <a href="/register">Register</a>
    <a href="/feedback">Feedback</a>
    <a href="/contact-us">Contact Us</a>
</nav>


<h1>Add Question</h1>
<form action="/add" method="post">
    <label for="category_name">Category:</label>
    <input type="text" id="category_name" name="category_name" placeholder="Category" required><br><br>

    <label for="question_content">Question:</label>
    <input type="text" id="question_content" name="question_content" placeholder="Question" required><br><br>

    <label for="choice1">Choice 1:</label>
    <input type="text" id="choice1" name="choice1" placeholder="Choice 1" required><br><br>

    <label for="choice1">Choice 2:</label>
    <input type="text" id="choice2" name="choice2" placeholder="Choice 2" required><br><br>

    <label for="choice1">Choice 3:</label>
    <input type="text" id="choice3" name="choice3" placeholder="Choice 3" required><br><br>

    <label for="choice1">Choice 4:</label>
    <input type="text" id="choice4" name="choice4" placeholder="Choice 4" required><br><br>

    <label for="correct_choice_num">Which choice is correct?</label>
    <input type="text" id="correct_choice_num" name="correct_choice_num" required><br><br>

    <input type="submit" value="Submit">
    <a href="/home">Back to Home</a>
</form>

</body>
</html>