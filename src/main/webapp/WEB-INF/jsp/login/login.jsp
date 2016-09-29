<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-cn">

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>登录</title>
		<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
        <script src="http://cdn.bootcss.com/jquery/3.1.1/jquery.js"></script>
        <script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="/css/basic.css" />
        <script src="/main/js/login.js"></script>
	</head>

	<body>
		<div class="container">
			<form class="form-horizontal form-interval" id="loginForm" role="form" action="/main/login">
				<div class="form-group">
					<input name="loginToken" type="hidden" value="${loginToken}">
					<label class="col-sm-2 control-label" for="inputAccount">帐号：</label>
					<div class="col-sm-6">
						<input type="text" id="inputAccount" name="account" class="form-control form-input-width" placeholder="帐号" required autofocus>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="inputPassword">密码：</label>
					<div class="col-sm-6">
						<input type="password" id="inputPassword" name="password" class="form-control form-input-width" placeholder="密码" required>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-6 text-left">
						<div class="checkbox ">
							<label>
                        <input type="checkbox" value="remember-me">
                        <记住密码></记住密码>
                    </label>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-4">
						<button class="btn btn-default btn-sm com-btn" id="formSubmit" type="button" onclick="login();">登录</button>
					</div>
				</div>
			</form>
		</div>
	</body>

</html>