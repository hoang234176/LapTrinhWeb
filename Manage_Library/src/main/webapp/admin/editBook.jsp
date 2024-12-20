<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.model.Book" %>
<%
	Book book = (Book) request.getAttribute("book");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chỉnh sửa sách</title>
</head>
<body>
	<jsp:include page = "../includes/headerADM.jsp" />

    <div class="book-form-container">
        <h3>Chỉnh sửa sách</h3>
        <% String message = (String) request.getAttribute("message"); %>
		<% if (message != null) { %>
		    <div class="edit_notify">
		        <h4><%= message %></h4>
		    </div>
		<% } %>
        <form action="/Manage_Library/EditBookController" method="post" enctype="multipart/form-data">
            <input type="text" name="title" placeholder="Tiêu đề" value="<%= book.getTitle() %>" required>
            <input type="text" name="author" placeholder="Tác giả" value="<%= book.getAuthor() %>" required>
            <input type="text" name="publisher" placeholder="Nhà xuất bản" value="<%= book.getPublisher() %>" required>
            <input type="number" name="publication_year" placeholder="Năm xuất bản" value="<%= book.getPublication_year() %>" required>
            <input type="text" name="isbn" placeholder="ISBN" value="<%= book.getIsbn() %>" required>
            <input type="text" name="category_id" placeholder="ID Thể loại" value="<%= book.getCategory() %>" required>
            <input type="number" name="quantities" placeholder="Số lượng" value="<%= book.getQuantity() %>" required>
<!--             <input type="file" name="image" required> -->
            <button type="submit">Thêm</button>
        </form>
    </div>
    
	<jsp:include page = "../includes/footer.jsp" />
</body>
</html>