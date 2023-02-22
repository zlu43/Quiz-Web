<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Center</title>
</head>
<body>
<nav class="global-nav">
    <a href="/home">Home</a>
    <a href="/logout">Logout</a>
    <a href="/register">Register</a>
    <a href="/feedback">Feedback</a>
    <a href="/contact-us">Contact Us</a>
</nav>

<h1>Admin Center</h1>

<h2>Users</h2>
<table>
    <tr>
        <th>Username</th>
        <th>Firstname</th>
        <th>Lastname</th>
        <th>Phone</th>
        <th>Email</th>
        <th>Address</th>
        <th>Action</th>
    </tr>
    <c:forEach var="user" items="${user_list}">
        <tr>
            <td style="text-align: center;">${user.user_name}</td>
            <td style="text-align: center;">${user.firstname}</td>
            <td style="text-align: center;">${user.lastname}</td>
            <td style="text-align: center;">${user.phone}</td>
            <td style="text-align: center;">${user.email}</td>
            <td style="text-align: center;">${user.address}</td>
            <td style="text-align: center;">
                <c:choose>
                    <c:when test="${user.is_active}">
                        <form action="/home" method="post">
                        <button type="submit" name="action_str" value="suspend_user_${user.user_id}">Suspend</button>
                        </form>
                    </c:when>
                    <c:otherwise>
                        <form action="/home" method="post">
                        <button type="submit" name="action_str" value="activate_user_${user.user_id}">Activate</button>
                        </form>
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
</table>

<h2>Quiz Results</h2>
<%--<form action="/quiz-results" method="post">--%>
<%--    <label for="category-select">Filter by Category:</label>--%>
<%--    <select name="category" id="category-select">--%>
<%--        <option value="">All Categories</option>--%>
<%--        <c:forEach var="category" items="${category_list}">--%>
<%--            <option value="${category.id}">${category.name}</option>--%>
<%--        </c:forEach>--%>
<%--    </select>--%>
<%--    <button type="submit">Filter</button>--%>
<%--</form>--%>
<table>
    <tr>
        <th>Date Taken</th>
        <th>Category</th>
        <th>User Fullname</th>
        <th>No. of Question</th>
        <th>Score</th>
        <th>Result</th>
    </tr>
        <c:forEach var="taken_quiz" items="${taken_quiz_list}">
            <tr>
                <td style="text-align: center;">${taken_quiz.start_time}</td>
                <td style="text-align: center;">${taken_quiz.category_name}</td>
                <td style="text-align: center;">${taken_quiz.user_fullname}</td>
                <td style="text-align: center;">${taken_quiz.question_list.size()}</td>
                <td style="text-align: center;">${taken_quiz.score}</td>
                <td style="text-align: center;"><a href="/result/${taken_quiz.quiz_id}">View Result</a></td>
            </tr>
        </c:forEach>
</table>

<h2>Questions</h2>
<a href="/add">Add a New Question</a>
<table>
    <tr>
        <th>Question</th>
        <th>Choices</th>
        <th>Action</th>
        <th></th>
    </tr>
    <c:forEach var="question" items="${question_list}">
        <tr>
            <td style="text-align: center;">${question.question_content}</td>
            <td style="text-align: center;">
                <c:forEach var="choice" items="${question.choice_list}">
                    ${choice.choice_content}
                </c:forEach>
            </td>
            <td style="text-align: center;">
                <c:choose>
                    <c:when test="${question.is_active}">
                        <form action="/home" method="post">
                            <button type="submit" name="action_str" value="suspend_question_${question.question_id}">Disable</button>
                        </form>
                    </c:when>
                    <c:otherwise>
                        <form action="/home" method="post">
                            <button type="submit" name="action_str" value="activate_question_${question.question_id}">Activate</button>
                        </form>
                    </c:otherwise>
                </c:choose>
            </td>
            <td>
                <a href="/update/${question.question_id}">Update</a>
            </td>
        </tr>
    </c:forEach>
</table>

<h2>Feedbacks</h2>
<table>
    <tr>
        <th>Rating</th>
        <th>Feedback</th>
    </tr>
    <c:forEach var="feedback" items="${feedback_list}">
        <tr>
            <td style="text-align: center;">${feedback.rating}</td>
            <td style="text-align: center;">${feedback.feedback}</td>
        </tr>
    </c:forEach>
</table>

<h2>Messages</h2>
<table>
    <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Message</th>
    </tr>
    <c:forEach var="message" items="${message_list}">
        <tr>
            <td style="text-align: center;">${message.name}</td>
            <td style="text-align: center;">${message.email}</td>
            <td style="text-align: center;">${message.message}</td>
        </tr>
    </c:forEach>
</table>


</body>
</html>