<%--
  Created by IntelliJ IDEA.
  User: 10660
  Date: 2021/2/23
  Time: 3:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p>第一个springmvc项目</p>
    <p><a href="test/some.do">发起some.do的请求</a></p><br/>
    <form action="test/other.do" method="post">
        <input type="submit" value="post请求other.do">
    </form>
</body>
</html>
