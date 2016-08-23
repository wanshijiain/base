<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页</title>
<link style="stylesheet" href="/css/index/index.css"/>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	这才是项目启动的首页</br>
	
	<form action="/pt.do" method="post">
		<select name="person.username" >
			<option>请选择</option>
			<option value="zhangsan">张三</option>
			<option value="李四">李四</option>
		</select>
		<input type="submit" value="提交"/>
	</form>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>