<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
form {
	display:flex;
	position: fixed;
	justify-content: center;
	top:0;
	left:0;
	margin: auto;
	height: 100%;
	width: 100%;
	background-image: url("img/login.png");
}

h1{
	position: absolute;
	top: 100px;
	font-size: 50px;
}

.ThongTin{
	position: absolute;
	top: 200px;
}

input{
	display: block;
	margin-bottom: 30px;
	width: 300px;
	height: 25px;
	border-radius: 50px;
	padding-left: 30px;
	font-size: 15px;
}

button{
	width: 340px;
	height: 35px;
	border-radius: 50px;
	background-color: #7FFF00;
	font-size: 20px;
	cursor: pointer;
}
</style>
</head>
<body>
<%
String message = (String)request.getAttribute("error");
if(message == null)
	message = "Tài khoản";
%>
<form action="<%=request.getContextPath()%>/Login" method="post">
<h1>Đăng nhập</h1>
  <div class = "ThongTin">
    <input type="text" placeholder="<%=message%>" name="uname" required>

    <input type="password" placeholder="Mật khẩu" name="psw" required>
        
    <button type="submit">Đăng nhập</button>
  </div>
</form>
</body>
</html>