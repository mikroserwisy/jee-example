<%@ page import="pl.training.jee.StatusProvider" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: landr
  Date: 13.11.2021
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title>Info</title>
</head>
<body>
<%--<%!
    private static final String CLIENT_NAME = "client-name";
    private final StatusProvider statusProvider = new StatusProvider();
%>--%>
<p>
<%--
<%
    String clientName = request.getParameter(CLIENT_NAME);
    String responseText = statusProvider.getStatus(clientName);
    out.println(responseText);
%>
--%>
Status: ${requestScope.status}
</p>
</body>
</html>
