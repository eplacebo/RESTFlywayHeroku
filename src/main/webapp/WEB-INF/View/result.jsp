<%--
  Created by IntelliJ IDEA.
  User: eplacebo
  Date: 06.10.2021
  Time: 2:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Upload Result</title>
</head>

<body>
<h2>${message}</h2>
</body>
<script>
    setTimeout(function() {
        document.location.href = '${pageContext.request.contextPath}/';
    }, 3000);
</script>
