<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() +
            request.getContextPath() + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <title>功能入口</title>
    <base href="<%=basePath%>"/>
</head>
<body>
<p>全局异常处理</p>
<form action="some.do" method="post">
    姓名：<input type="text" name="name">
    性别：
    <select name="gender">
        <option value="男">男</option>
        <option value="女">女</option>
    </select>
    邮箱: <input type="text" name="email">
    <input type="submit" value="提交">
</form>
</body>
</html>