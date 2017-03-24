<%--
  Created by IntelliJ IDEA.
  User: VladislavTitov
  Date: 14.03.2017
  Time: 12:20
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<body>

    <c:forEach var="user" items="${users}">
        <c:out value="${user.name}"></c:out>
        <c:out value="${user.description}"></c:out>
        <br>
    </c:forEach>

</body>
</html>
