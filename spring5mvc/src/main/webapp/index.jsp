
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>

    <a href="init/hello?name=springmvc">GET请求</a>
    <br/>
    <a href="init/delete/ydnw-1233-d3sdf-32sdf">PathVariable请求</a>
    <br/>

    <form action="init/save" method="post">
        名称：<input type="text" name="name"><br/>
        年龄：<input type="number" name="age" ><br/>

        <button type="submit">提交表单</button>
    </form>

    <a href="init/testRest/1">测试REST风格GET请求</a>
    <br/>
    <form action="init/testRest" method="post">
        <p>REST风格的POST请求--表示新增操作</p>
        名称：<input type="text" name="name"><br/>

        <button type="submit">测试REST风格POST请求</button>
    </form>
    <form action="init/testRest" method="post">
        <p>_method参数值为DELETE让springmvc将本POST请求转换为DELETE请求--表示删除操作</p>
        <input type="hidden" name="_method" value="DELETE">
        名称：<input type="text" name="name"><br/>

        <button type="submit">测试REST风格DELETE请求</button>
    </form>
    <form action="init/testRest" method="post">
        <p>_method参数值为PUT让springmvc将本POST请求转换为PUT请求--表示更新操作</p>
        <input type="hidden" name="_method" value="PUT">
        名称：<input type="text" name="name"><br/>

        <button type="submit">测试REST风格PUT请求</button>
    </form>

    <a href="init/testRequestParam?age=3&name=">测试参数传递RequestParam</a>
    <br/>
    <a href="init/testRequestHeader">测试映射请求头参数</a>
    <br/>
    <a href="init/testCookieValue">测试CookieValue</a>
    <br/>
    <form action="init/person" method="post">
        <p>提交表单 以pojo参数提交, 支持级联属性</p>
        名称：<input type="text" name="userName"><br/>
        密码：<input type="password" name="password"><br/>
        省份：<input type="text" name="address.province"><br/>
        城市：<input type="text" name="address.city"/><br/>
        街道：<input type="text" name="address.street"><br/>
        <p/>
        <button type="submit">提交表单</button>
    </form>
    <a href="init/testServlet">测试原生的Servlet Api</a>
    <br/>
    <a href="init/testModelAndView">测试ModelAndView返回数据</a>
    <br/>
    <a href="init/testsessionAttributes">测试sessionAttributes</a>
    <br/>
    <p>session中数据，多个请求之间可以共享数据：</p>
    名称：${sessionScope.person.userName}<br/>
    密码：${sessionScope.person.password}<br/>
    省份：${sessionScope.person.address.province}<br/>
    城市：${sessionScope.person.address.city}<br/>
    街道：${sessionScope.person.address.street}<br/>
    Date类型：${sessionScope.time}<br/>
    String类型：${sessionScope.des1}<br/>
    String类型：${sessionScope.des2}<br/>


    <form action="init/testModelAttribute" method="post">
        <p 模拟修改Person 不修改的数据传空，后台只修改传递的字段数据/>
        <input type="hidden" name="id" value="123">
        名称：<input type="text" name="userName" value="小强"><br/>
        省份：<input type="text" name="address.province"><br/>
        城市：<input type="text" name="address.city"/><br/>
        街道：<input type="text" name="address.street"><br/>
        <p/>
        <button type="submit">提交表单</button>
    </form>

    <a href="success" > 测试直接跳转页面，不经过Controller 以及国际化</a><br/>

    <a href="init/testCustomView" > 测试自定义视图</a><br/>

    <a href="init/testRedirect" > 测试重定向</a><br/>

    <a href="init/testForward" > 测试转发</a><br/>

    <a href="restCrud/persons" >REST-获取所有Person</a><br/>

    <form action="restCrud/testConverters" method="post">
        <p 测试springmvc类型转换器/>
        Person：<input type="text" name="person"><br/>
        <p/>
        <button type="submit">提交表单</button>
    </form>

    <form action="init/testFileupload" method="post" enctype="multipart/form-data">
        <p 测试文件上传/>
        Desc：<input type="text" name="desc"><br/>
        <input type="file" name="file" />
        <p/>
        <button type="submit">提交表单</button>
    </form>

    <a href="init/testException/0" >测试异常</a><br/>
</body>
</html>
