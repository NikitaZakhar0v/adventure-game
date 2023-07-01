<!DOCTYPE html>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en" xml:lang="en">
<head>
    <title>Квест</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

</head>
<body>

<c:set var="question" value="${requestScope.question}" />
<c:set var="user" value="${sessionScope.get('user')}" />

<h1>${question.text}</h1>
<div>
    <c:if test="${not empty question.answers}">
        <form method="post" action="quiz">
            <c:forEach var="answer" items="${question.answers}">
                <label>
                    <input type="radio" name="answerRadio" value="${answer.nextQuestionId()}" required>
                        ${answer.text()}
                </label>
                <br>
            </c:forEach>
            <button type="submit">Ответить</button>
        </form>
    </c:if>
</div>
<div>
    <c:if test="${empty question.answers}">
        <h3 class="red-text">${question.result.description}</h3>
        <div>
            <form method="post" action="quiz">
                <input type="hidden" name="answerRadio" value="0">
                <input type="submit" value="Начать с начала" class="button">
            </form>
        </div>
        <div>
            <form method="post" action="quiz">
                <input type="hidden" name="exit" value="exit">
                <input type="submit" value="Выход" class="button">
            </form>
        </div>
    </c:if>
</div>

<br>
<br>
<br>
<br>
<div>
    Статистика:
    <br>
    IP address: ${user.statistics.getIpAddress()}
    <br>
    Имя в игре: ${user.name}
    <br>
    Количество игр: ${user.statistics.score}
    <br>
    Побед: ${user.statistics.scoreVictory}
    <br>
    Поражений: ${user.statistics.scoreDefeat}
</div>
</body>
</html>
