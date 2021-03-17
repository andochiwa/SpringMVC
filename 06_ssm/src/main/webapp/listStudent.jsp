<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() +
            request.getContextPath() + "/";
%>
<html>
<head>
    <title>查询学生ajax</title>
    <base href="<%=basePath%>">
    <script type="text/javascript" src="js/jquery-3.5.1.js"></script>
    <script type="text/javascript">
        $(function () {
            // 在当前页面dom对象加载处执行loadStudentData()
            loadStudentData();
            $("#btnLoader").click(function () {
            })
        })

       function loadStudentData() {
           $.ajax({
               url: "student/queryStudents.do",
               type: "get",
               dataType: "json",
               success: function (data) {
                   // 清楚旧的数据
                   $("#info").html("");
                   $.each(data, function (i, data) {
                       // 增加新的数据
                       $("#info").append("<tr>")
                           .append("<td>" + data.id + "</td>")
                           .append("<td>" + data.name + "</td>")
                           .append("<td>" + data.gender + "</td>")
                           .append("<td>" + data.email + "</td>")
                           .append("<tr/>");
                   })
               }
           })
       }
    </script>
</head>
<body>
<div align="center">
    <table>
        <thead>
        <tr>
            <td>学号</td>
            <td>姓名</td>
            <td>性别</td>
            <td>邮箱</td>
        </tr>
        </thead>
        <tbody id="info">

        </tbody>
    </table>
    <input type="button" id="btnLoader" value="查询数据">
</div>
</body>
</html>
