<%--
  Created by IntelliJ IDEA.
  User: VladislavTitov
  Date: 10.03.2017
  Time: 1:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Sign Up</title>
</head>
<body>
    <h1>Sign Up</h1>
    <form method="post" action="/signup">
        Name: <input type="text" name="username" placeholder="Enter your name"/>
        <label>Password: <input type="password" name="password" placeholder="Enter your pass"/></label>
        <label>Describe yourself: <textarea name="description" placeholder="Enter info about yourself"></textarea></label>
        <input type="submit"/>
    </form>

    <form:form modelAttribute="user" action="anno-signup-post" method="post">
        <label>Name: <form:input path="name"/></label>
        <label>Password: <form:password path="password"/></label>
        <label>Describe yourself: <form:textarea path="description"></form:textarea></label>
        <input type="submit"/>
    </form:form>
</body>
</html>
