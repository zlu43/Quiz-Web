<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <title>Quiz Result</title>
</head>
<body>
<nav class="global-nav">
    <a href="/home">Home</a>
    <a href="/logout">Logout</a>
    <a href="/register">Register</a>
    <a href="/feedback">Feedback</a>
    <a href="/contact-us">Contact Us</a>
</nav>


<h1>Quiz Result</h1>

<p>User Name: ${quiz.user_fullname}</p>
<p>Start Time: ${quiz.start_time}</p>
<p>End Time: ${quiz.end_time}</p>

<table>
    <tr>
        <th>Question</th>
        <th>Options</th>
        <th>Your Answer</th>
    </tr>
    <c:forEach var="question" items="${quiz.question_list}" varStatus="loop">
        <tr>
            <td style="text-align: center;">${question.question_content}</td>
            <td style="text-align: center;">
                <c:forEach var="choice" items="${question.choice_list}">
                    ${choice.choice_content}
                </c:forEach>
            </td>>
            <td style="text-align: center;">${quiz.user_answer_list.get(loop.index).choice_content}</td>
        </tr>
    </c:forEach>
</table>

<c:if test="${quiz.score > 3}">
    <h3>You passed the quiz!</h3>
</c:if>
<c:if test="${quiz.score <= 3}">
    <h3>You failed the quiz.</h3>
</c:if>

<a href="/home">Back to Home</a>

</body>
</html>
