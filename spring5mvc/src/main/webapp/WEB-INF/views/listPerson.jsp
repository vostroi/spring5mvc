<%--
  Created by IntelliJ IDEA.
  User: tk
  Date: 2019/3/20
  Time: 22:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Success</title>
</head>
<body>
    <h2>Rest Crud</h2>

    <p>Person列表</p>
    <c:if test="${empty requestScope.persons}">
        <span>没人数据</span>
    </c:if>

    <c:if test="${!empty requestScope.persons}">
        <table border="1" cellpadding="10" cellspacing="0">
            <tr>
                <th>ID</th>
                <th>NAME</th>
                <th>PASSWORD</th>
                <th>PROVINCE</th>
                <th>CITY</th>
                <th>STREET</th>
                <th colspan="3">OPERATION</th>
            </tr>
            <C:forEach items="${requestScope.persons}" var="person">
                <tr>
                    <td>${person.id}</td>
                    <td>${person.userName}</td>
                    <td>${person.password == '' ? person.password : "*****"}</td>
                    <td>${person.address.province}</td>
                    <td>${person.address.city}</td>
                    <td>${person.address.street}</td>
                    <td><a href="">EDIT</a> </td>
                    <td><a href="person/${person.id}">DELETE</a> </td>
                    <td><a href="../addPerson">ADD</a> </td>
                </tr>
            </C:forEach>
        </table>
    </c:if>

</body>
</html>
