<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Đăng ký</title>
	<link rel="stylesheet" href="/Manage_Library/assets/css/style.css">
	<script src="/Manage_Library/assets/js/script.js"></script>
</head>
<body>
	<jsp:include page = "../includes/header.jsp" />

	<div class="form_register">
		<h2>Đăng ký</h2>
		<% String message = (String) request.getAttribute("message"); %>
		<% if (message != null) { %>	
			<div class = "register_notify">
				<%= message %>
			</div>
		<% } %>
		<form action="/Manage_Library/RegisterController" method="post" onsubmit="return validateForm()">
        <input type="text" name="fname" placeholder="Họ và Tên" required>
        <input type="email" name="email" placeholder="Email" required>
        <input type="password" name="password" id="password" placeholder="Mật khẩu" required>
        <input type="password" name="confirmPassword" id="confirmPassword" placeholder="Nhập lại mật khẩu" required>
        <button type="submit">Đăng ký</button>
        <p>Đã có tài khoản? <a href="login.jsp">Đăng nhập</a></p>
    </form>
	</div>

	<jsp:include page = "../includes/footer.jsp" />
</body>
</html>