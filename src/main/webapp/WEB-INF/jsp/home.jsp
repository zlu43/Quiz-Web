<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
<nav class="global-nav">
    <a href="/home">Home</a>
    <a href="/logout">Logout</a>
    <a href="/register">Register</a>
    <a href="/feedback">Feedback</a>
    <a href="/contact-us">Contact Us</a>
</nav>


<div class="container">
<h1>Hi, ${user.firstname} ${user.lastname}!</h1>
<h1>Quiz Categories</h1>
<ul>
    <c:forEach var="category" items="${category_list}">
        <li><a href="/quiz/${category.category_id}">${category.category_name}</a></li>
    </c:forEach>
</ul>

<h1>Quiz Results</h1>
<table>
    <tr>
        <th>Quiz ID</th>
        <th>Date Taken</th>
        <th>Result</th>
    </tr>
    <c:forEach var="taken_quiz" items="${taken_quiz_list}">
        <tr>
            <td>${taken_quiz.quiz_id}</td>
            <td>${taken_quiz.start_time}</td>
            <td><a href="/result/${taken_quiz.quiz_id}">View Result</a></td>
        </tr>
    </c:forEach>
</table>
</div>
</body>
</html>


