<%--
  Created by IntelliJ IDEA.
  User: tk
  Date: 2019/3/20
  Time: 22:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Success</title>
</head>
<body>
    <h2>Rest Crud</h2>

    <c:if test="${!empty person}">
        <p>编辑Person</p>
    </c:if>
    <c:if test="${empty person}">
        <p>新增Person</p>
    </c:if>
    <c:if test="${empty requestScope.person}">
        <span>没有数据</span>
    </c:if>
    <form action="restCrud/person" method="post">
        <c:if test="${!empty person}">
            <input type="hidden" name="_method" value="PUT">
        </c:if>
        <input type="hidden" name="id" value="${person.id}"><br/>
        userName：<input type="text" name="userName" value="${person.userName}"><br/>
        password：<input type="password" name="password" value="${person.password}"><br/>
        birth：<input type="text" name="birth" value="${person.birth}"><br/>
        province：<input type="text" name="address.province" value="${person.address.province}"><br/>
        city：<input type="text" name="address.city" value="${person.address.city}"><br/>
        street：<input type="text" name="address.street" value="${person.address.street}"><br/>
        <c:if test="${empty person}">
            <button type="submit" >提交保存</button><br/>
        </c:if>
        <c:if test="${!empty person}">
            <button type="submit" >提交修改</button><br/>
        </c:if>
    </form>

    <br/><br/>
    <p>使用Spring的标签可以回显表单 modelAttribute 指定接收参数的bean的参数名 </p>
    <%--<form:form action="restCrud/person" method="post" modelAttribute="person">--%>
        <%--id：<form:input path="id" />--%>
    <%--</form:form>--%>

    <br/><br/><br/><br/>
    <p>新增/修改后的Person数据</p>
    id：${person.id}<br/>
    userName：${person.userName}<br/>
    password：${person.password}<br/>
    province：${person.address.province}<br/>
    city：${person.address.city}<br/>
    street：${person.address.street}<br/>

</body>
</html>
