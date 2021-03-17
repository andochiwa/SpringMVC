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
    <p>提交参数给Controller</p>
    <form action="receiveproperty.do" method="post">
        姓名: <input type="text" name="name"><br/>
        年龄: <input type="text" name="age"><br/>
        <input type="submit" value="提交参数">
    </form>

    <br/>
    <p>请求参数名和处理器方法的形参名不一样</p>
    <form action="receiveParam.do" method="post">
        姓名: <input type="text" name="rname"><br/>
        年龄: <input type="text" name="rage"><br/>
        <input type="submit" value="提交参数">
    </form>

    <br/>
    <p>请使用java对象接受请求参数</p>
    <form action="receiveObject.do" method="post">
        姓名: <input type="text" name="name"><br/>
        年龄: <input type="text" name="age"><br/>
        <input type="submit" value="提交参数">
    </form>
</body>
</html>
