<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Chess Board</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            background-color: #f5f5f5;
            margin: 0;
            padding: 20px;
        }

        h2 {
            color: #333;
            margin: 20px 0;
        }

        #chess-board {
            margin: 20px auto;
            border-collapse: collapse;
        }

        #chess-board td {
            width: 60px;
            height: 60px;
            border: 1px solid #999;
            text-align: center;
            vertical-align: middle;
            font-size: 50px;
            font-weight: bold;
        }

        #chess-board tr:nth-child(odd) td:nth-child(even),
        #chess-board tr:nth-child(even) td:nth-child(odd) {
            background-color: #bbb;
        }

        form {
            margin-top: 30px;
        }

        input[type="text"], button[type="submit"] {
            font-size: 16px;
            padding: 10px;
            margin: 5px;
            border-radius: 5px;
            border: 1px solid #ccc;
        }

        button[type="submit"] {
            cursor: pointer;
            background-color: #333;
            color: white;
        }

        .error-message {
            color: #d9534f;
            font-weight: bold;
            margin-top: 20px;
        }
    </style>
</head>
<body>
<h2>${turnMessage}</h2>
<table id="chess-board">
    <c:forEach var="rank" items="${board.ranks}">
        <tr>
            <c:forEach var="piece" items="${rank.pieces}">
                <td>${piece.representation}</td>
            </c:forEach>
        </tr>
    </c:forEach>
</table>

<form action="/play" method="post">
    <div>
        <label for="source">시작점:</label>
        <input type="text" id="source" name="source">
    </div>
    <div>
        <label for="target">종료점:</label>
        <input type="text" id="target" name="target">
    </div>
    <button type="submit">입력</button>
</form>

<c:if test="${not empty errorMessage}">
    <p class="error-message">${errorMessage}</p>
</c:if>

</body>
</html>
