<%--
  Created by IntelliJ IDEA.
  User: tk
  Date: 2019/3/20
  Time: 22:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Success</title>
</head>
<body>
    <h2>Success</h2>
    <a href="init/hello">success</a>

    <p 接收controller返回的数据/>
    时间：${requestScope.time}<br/>
    名称：${requestScope.person.userName}<br/>
    密码：${requestScope.person.password}<br/>
    省份：${requestScope.person.address.province}<br/>
    城市：${requestScope.person.address.city}<br/>
    街道：${requestScope.person.address.street}<br/>

    <br/>
    名字列表：${names}

    <br/>
    <p>session中数据：</p>
    名称：${sessionScope.abcd.userName}<br/>
    密码：${sessionScope.person.password}<br/>
    省份：${sessionScope.person.address.province}<br/>
    城市：${sessionScope.person.address.city}<br/>
    街道：${sessionScope.person.address.street}<br/>
    Date类型：${sessionScope.time}<br/>
    String类型：${sessionScope.des1}<br/>
    String类型：${sessionScope.des2}<br/>
    <a href="/spring5mvc">跳转到index</a>
    <br/>

    <p>测试国际化效果</p>
    <fmt:message key="userName"/> <br/>
    <fmt:message key="password"/> <br/>
</body>
</html>
