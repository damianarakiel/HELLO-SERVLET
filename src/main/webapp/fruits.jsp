<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: goobar
  Date: 07.10.18
  Time: 00:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Fruits</title>
</head>
<body>
<br/>
Fruits:
<br/>
<ol>
<c:forEach var="fruit" items="${fruits}">
    <li><c:out value="${fruit}"/></li>
</c:forEach>
</ol>
</body>
</html>
