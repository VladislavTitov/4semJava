<%--
  Created by IntelliJ IDEA.
  User: VladislavTitov
  Date: 10.03.2017
  Time: 1:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up</title>
</head>
<body>
    <h1>Sign Up</h1>
    <form method="post" action="/signup">
        <label>Name: <input type="text" name="username" placeholder="Enter your name"/></label>
        <label>Password: <input type="password" name="password" placeholder="Enter your pass"/></label>
        <label>Describe yourself: <textarea name="description" placeholder="Enter info about yourself"></textarea></label>
        <input type="submit"/>
    </form>
</body>
</html>
