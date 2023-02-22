<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quiz Page</title>
</head>
<body>
<nav class="global-nav">
    <a href="/home">Home</a>
    <a href="/logout">Logout</a>
    <a href="/register">Register</a>
    <a href="/feedback">Feedback</a>
    <a href="/contact-us">Contact Us</a>
</nav>


<h1>Quiz</h1>
<form action="/quiz" method="post">
    <c:forEach items="${quiz.question_list}" var="question">
        <p><b>Question: ${question.question_content}</b></p>
        <c:forEach items="${question.choice_list}" var="choice">
            <input type="radio" id="answer_${question.question_id}_${choice.choice_id}" name="answer_${question.question_id}" value="${choice.choice_id}">
            <label for="answer_${question.question_id}_${choice.choice_id}">${choice.choice_content}</label><br>
        </c:forEach>
    </c:forEach>
    <input type="submit" value="Submit" />
</form>
</body>
</html>


