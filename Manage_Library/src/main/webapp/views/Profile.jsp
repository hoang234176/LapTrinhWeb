<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.dao.UserDAO" %>
<%@ page import="com.model.User" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thông tin người dùng</title>
<link rel="stylesheet" type="text/css" href="/Manage_Library/assets/css/style.css">
</head>
<body>
	<jsp:include page="../includes/header.jsp"/>
	<div class="user-info">
        <h1>Thông tin người dùng</h1>

       <%
        // Lấy session để kiểm tra thông tin người dùng
        HttpSession sessions = request.getSession();
        Integer userId = (Integer) sessions.getAttribute("user_id");

        if (userId != null) {
            UserDAO userDAO = new UserDAO();
            User user = userDAO.getUserById(userId);

            if (user != null) {
    	%>
                <div class="user-details">
                    <h2>Thông tin chi tiết</h2>
    				<p><strong>Tên:</strong> <%= user.getFname() %></p>
				    <p><strong>Email:</strong> <%= user.getEmail() %></p>
				    <p><strong>Vai trò:</strong> <%= user.getRole() %></p>
				    <a href="BorrowInfo.jsp" class="btn-borrow-info">Thông tin mượn sách</a>
				    <a href="ReturnInfo.jsp" class="btn-return-info">Thông tin trả sách</a>
                </div>
    	<%
            } else {
    	%>
                <p>Không tìm thấy thông tin người dùng.</p>
    	<%
            }
        	} else {
    	%>
            <p>Vui lòng đăng nhập để xem thông tin của bạn.</p>
    	<%
        }
    	%>
    </div>
    <jsp:include page="../includes/footer.jsp"/>
</body>
</html>