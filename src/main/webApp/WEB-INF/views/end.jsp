<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게임 종료</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            text-align: center;
            background-color: #f5f5f5;
            margin: 0;
            padding: 20px;
        }

        .message {
            font-size: 24px;
            font-weight: bold;
            color: #333;
            margin-top: 50px;
            background-color: #ffdddd;
            border: 1px solid #dd2222;
            padding: 20px;
            border-radius: 10px;
            display: inline-block;
        }

        #chess-board {
            margin-top: 20px;
            border-collapse: collapse;
            margin-left: auto;
            margin-right: auto;
        }

        #chess-board td {
            width: 60px;
            height: 60px;
            background-color: #fff;
            border: 1px solid #000;
            text-align: center;
            font-size: 50px;
            font-weight: bold;
        }

        #chess-board tr:nth-child(odd) td:nth-child(even),
        #chess-board tr:nth-child(even) td:nth-child(odd) {
            background-color: #bbb;
        }
    </style>
</head>
<body>

<div class="message">게임이 종료되었습니다.</div>

<c:if test="${not empty board}">
    <table id="chess-board">
        <c:forEach var="rank" items="${board.ranks}">
            <tr>
                <c:forEach var="piece" items="${rank.pieces}">
                    <td>${piece.representation}</td>
                </c:forEach>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>
