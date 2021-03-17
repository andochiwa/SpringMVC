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
    <script type="text/javascript" src="js/jquery-3.5.1.js"></script>
    <script type="text/javascript">
        $(function() {
            $("button").click(function() {
                $.ajax({
                    // url: "returnStudentJson.do",
                    url : "returnStringData.do",
                    data: {
                        name: "张三",
                        age: 20
                    },
                    type: "post",
                    // dataType: "json",
                    dataType: "text",
                    success: function (data) {
                        // alert(data.name + "," + data.age);
                        // $.each(data, function(i, n) {
                        //     alert(n.name + ", " + n.age);
                        // })
                        alert(data);
                    }
                })
            })
        })
    </script>
</head>
<body>
<p>处理器返回String表示视图名称</p>
<form action="returnString-view.do" method="post">
    姓名: <input type="text" name="name"><br/>
    年龄: <input type="text" name="age"><br/>
    <input type="submit" value="提交参数">
</form>

<br/>
<button id="btn">发起ajax请求</button>

</body>
</html>
