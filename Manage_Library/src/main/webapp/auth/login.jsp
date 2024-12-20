<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <title>Đăng Nhập</title>
    <link rel="stylesheet" href="/Manage_Library/assets/css/style.css">
</head>
<body>
	<jsp:include page = "../includes/header.jsp" />
	
	<div class="form_login">
		<h2>Đăng Nhập</h2>
		<% String message = (String) request.getAttribute("message"); %>
		<% if (message != null) { %>
		    <div class="login_notify">
		        <h4><%= message %></h4>
		    </div>
		<% } %>
		<form action="/Manage_Library/LoginController" method="post">
			<input type="email" name="email" placeholder="Email" required>
	        <input type="password" name="password" placeholder="Mật khẩu" required>
	        <button type="submit">Đăng nhập</button>
	        <p>Chưa có tài khoản? <a href="register.jsp">Đăng ký</a></p>
		</form>
	</div>
	
	<jsp:include page = "../includes/footer.jsp" />
</body>
</html>