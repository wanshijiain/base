<%--
  Created by IntelliJ IDEA.
  User: ZeviChen
  Date: 2016/9/27
  Time: 13:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传文件</title>
    <link rel="stylesheet" type="text/css" href="/js/jquery-3.1.1.js"/>
    <script type="text/javascript">
        $.ajax({
            url: '/servlet/upload',
            type: 'POST',
            cache: false,
            data: new FormData($('#uploadForm')[0]),
            processData: false,
            contentType: false
        }).done(function(res) {
            console.log("ok")
        }).fail(function(res) {
            console.log("error")
        });
    </script>
</head>
<body>
<form method="post" action="/servlet/upload" enctype="multipart/form-data" id="uploadForm">
    选择一个文件:
    <input type="file" name="uploadFile" />
    <br/><br/>
    <input type="submit" value="上传" />
</form>
</body>
</html>
