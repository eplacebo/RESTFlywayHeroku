<%--
  Created by IntelliJ IDEA.
  User: eplacebo
  Date: 05.10.2021
  Time: 13:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Start Page</title>
    <style>
        tr, td, th {
            padding: 20px;
            text-align: center;
        }
    </style>
</head>
<body>
<center>
    <h1>
        <div>Upload file</div>
    </h1>
    <form action="list" method="post" enctype="multipart/form-data">
        <table width="400px" align="center" border=2>
            <td>Username</td>
            <td><input type="text" required="required" name="username"/></td>
            <td><input type="file" required="required" name="uploadFile"/></td>
            <td><input type="submit" value="Upload"/></td>
        </table>
    </form>

    <table class="table_sort" border="1" cellspacing="0" cellpadding="2" >
        <tr>
            <th>ID</th>
            <th>Username</th>
            <th>File</th>
            <th>Date</th>
            <th>Path</th>
            <th>Download</th>
        </tr>
        <c:forEach var="user" items="${users}">
            <c:forEach var="event" items="${user.eventList}">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.username}</td>
                    <td>${event.fileInfo.nameFile}</td>
                    <td>${event.dateEvent}</td>
                    <td>${event.fileInfo.pathFile}</td>
                    <td><a href="${event.fileInfo.nameFile}" download="${event.fileInfo.nameFile}" target="_blank">Download</a></td>
                </tr>
            </c:forEach>
        </c:forEach>
    </table>
</center>
</body>
</html>