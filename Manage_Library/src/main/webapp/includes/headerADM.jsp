<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Admin</title>
	<link rel="stylesheet" href="/Manage_Library/assets/css/style.css">
	<script src="/Manage_Library/assets/js/script.js"></script>
</head>
<body>
    <header>
		<div class="logo">
            <a href="/Manage_Library/admin/dashboard.jsp"><img src="/Manage_Library/assets/images/logo.jpg" alt="Library Logo"></a>
        </div>
        <nav>
            <ul>
                <li><a href="/Manage_Library/admin/dashboard.jsp">Dashboard</a></li>
                <li><a href="/Manage_Library/admin/manageUsers.jsp">Quản lý người dùng</a></li>
                <li><a href="/Manage_Library/admin/manageBooks.jsp">Quản lý Sách</a></li>
                <li><a href="/Manage_Library/auth/logout.jsp" class="logout-btn">Đăng xuất</a></li>
            </ul>
        </nav>
    </header>

