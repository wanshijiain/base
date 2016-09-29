<%--
  Created by IntelliJ IDEA.
  User: ZeviChen
  Date: 2016/9/28
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap 101 Template</title>
    <link href="/bootstrap/bootstrap-3.3.7/css/bootstrap.css" rel="stylesheet">
    <script src="/js/jquery-3.1.1.js"  type="application/javascript"/>
    <script src="/bootstrap/bootstrap-3.3.7/js/bootstrap.js" type="application/javascript"/>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
    <div class="container">
        <br/>
        <br/>
        <br/>
        <br/>
        <form class="form-signin" role="form" action="/main//login">
            <input type="email" name="account" class="form-control" placeholder="帐号" required autofocus>
            <input type="password" name="password" class="form-control" placeholder="密码" required>
            <div class="checkbox">
                <label>
                    <input type="checkbox" value="remember-me"> 记住密码
                </label>
            </div>
            <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
        </form>
    </div>
</body>
</html>
