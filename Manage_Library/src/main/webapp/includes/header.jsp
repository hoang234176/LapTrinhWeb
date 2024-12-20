<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String role = (String) session.getAttribute("role");%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage Library</title>
    <link rel="stylesheet" href="/Manage_Library/assets/css/style.css">
    <script src="/Manage_Library/assets/js/script.js"></script>
</head>
<body>
    <header>
	    <div class="logo">
	        <a href="/Manage_Library/index.jsp"><img src="/Manage_Library/assets/images/logo.jpg" alt="Library Logo"></a>
	    </div>
	    <nav>
	        <ul>
	            <li><a href="/Manage_Library/index.jsp">Trang chủ</a></li>
	            <% 
	            	if (role == null){
	            %>
			            <li><a href="/Manage_Library/auth/login.jsp">Đăng nhập</a></li>
			            <li><a href="/Manage_Library/auth/register.jsp">Đăng ký</a></li>          		
	            <%	
	            	} else {
	            %>
	            	<li><a href="/Manage_Library/views/Profile.jsp">Hồ Sơ</a></li>
		            <li><a href="/Manage_Library/auth/logout.jsp" class="logout-btn">Đăng xuất</a></li>
				<%	            		
	            	}
	            %>
	        </ul>
	    </nav>
	</header>
