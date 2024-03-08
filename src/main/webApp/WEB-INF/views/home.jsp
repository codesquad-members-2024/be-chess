<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chess Game Control</title>
    <style>
        body, html {
            height: 100%;
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            color: #333;
        }

        .container {
            text-align: center;
            padding: 20px;
            background-color: white;
            border: 2px solid #dedede;
            border-radius: 10px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        h1 {
            margin-bottom: 20px;
        }

        form {
            margin: 0 auto;
        }

        input[type="submit"] {
            font-size: 16px;
            padding: 10px 20px; /* Increased padding for better visibility */
            margin: 5px; /* Adjusts spacing around buttons */
            background-color: #333;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
            display: inline-block; /* Ensure buttons are aligned next to each other */
        }

        input[type="submit"]:hover {
            background-color: #555;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>체스 게임</h1>
    <form action="/main" method="post">
        <input type="submit" id="start" name="command" value="start">
        <input type="submit" id="end" name="command" value="end">
    </form>
</div>
</body>
</html>
