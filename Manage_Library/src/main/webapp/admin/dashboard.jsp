<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang Admin</title>
<link rel="stylesheet" type="text/css" href="../assets/css/style.css">
</head>
<body>
	<jsp:include page="../includes/headerADM.jsp"/>
	
	<div class="management-container">
	    <div class="management-box">
	        <h4>Sách</h4>
	        <h6>Số loại sách: </h6>
	        <h6>Tổng số lượng sách: </h6>
	        <a href="/Manage_Library/admin/manageBooks.jsp" class="button-manageBooks">Quản lý Sách</a>
	    </div>
	    <div class="management-box">
	        <h4>Người dùng</h4>
	        <h6>Tổng số người dùng: </h6>
	        <a href="/Manage_Library/admin/manageUsers.jsp" class="button-manageUser">Quản lý người dùng</a>
	    </div>
	</div>
	<a href="/Manage_Library/admin/addBook.jsp" class="button-addbook">Thêm sách</a><br>

	<jsp:include page="../includes/footer.jsp"/>
</body>
</html>