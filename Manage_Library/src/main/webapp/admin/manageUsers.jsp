<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "com.dao.UserDAO" %>
<%@ page import = "com.model.User" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Quản lý người dùng</title>
	<link rel="stylesheet" href="/Manage_Library/assets/css/style.css">
</head>
<body>
	<jsp:include page="../includes/headerADM.jsp"/>
	
	<div class="manage-user">
    	<h2>Quản lý người dùng</h2>
    </div>
    <% String message = (String) request.getAttribute("message"); %>
		<% if (message != null) { %>
		    <div class="manageUser_notify">
		        <h4><%= message %></h4>
		    </div>
	<% } %>
	<table class="user-table user-management">
	    <thead>
	        <tr>
	            <th class="table-header">ID</th>
	            <th class="table-header">Họ và Tên</th>
	            <th class="table-header">Email</th>
	            <th class="table-header">Quyền</th>
	            <th class="table-header">Hoạt động</th>
	        </tr>
	    </thead>
	    <tbody>
	    <%
	        UserDAO userDAO = new UserDAO();
	        List<User> users = userDAO.getAllUsers();
	    %>
	    <% if (users != null) {
	        for (User user : users) {
	    %>
	        <tr class="table-row">
	            <td class="table-cell"><%= user.getUser_id() %></td>
	            <td class="table-cell"><%= user.getFname() %></td>
	            <td class="table-cell"><%= user.getEmail() %></td>
	            <td class="table-cell"><%= user.getRole() %></td>
	            <td class="table-cell table-cell-actions">
				    <form action="/Manage_Library/DeleteUserController" method="post">
				        <input type="hidden" name="delete_id" value="<%= user.getUser_id() %>">
				        <button type="submit" class="delete-button" onclick="return confirm('Bạn chắc chắn muốn xóa người dùng này?');">Xóa</button>
				    </form>
				    <span class="separator">|</span> <!-- Dấu phân cách giữa hai nút -->
				    <form action="/Manage_Library/RecordUserController" method="post">
				        <input type="hidden" name="recordsUser" value="<%= user.getUser_id() %>">
				        <button type="submit" class="button-borrow-records">Lịch sử</button>
				    </form>
				</td>
	        </tr>
	    <%
	        }
	    } else {
	    %>
	        <tr>
	            <td colspan="5" class="no-data">Không tìm thấy người dùng nào!</td>
	        </tr>
	    <% } %> 
	    </tbody>
	</table>
		
	<jsp:include page="../includes/footer.jsp"/>
</body>
</html>