<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.dao.BookDAO" %>
<%@ page import="com.model.Book" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="styles.css">
	<title>Thư Viện Sách</title>
	<link rel="stylesheet" href="/Manage_Library/assets/css/style.css">
	<script src="/Manage_Library/assets/js/script.js"></script>
</head>
<body>
    <jsp:include page="includes/header.jsp" />
    
    <h1>Trang chủ</h1>
    
    <div class="book-list">
        <%
            // Kết nối đến cơ sở dữ liệu
            BookDAO bookDAO = new BookDAO();
            List<Book> books = bookDAO.getAllBook();
            
            for (Book book : books) {
        %>
            <div class="book-item">
            	<img src="/Manage_Library/assets/images/<%= book.getImage() %>" alt="<%= book.getTitle() %>" style="width: 100%; height: auto; border-radius: 5px;">
                <h2><%= book.getTitle() %></h2>
                <p>Tác giả: <%= book.getAuthor() %></p>
                <p>Năm xuất bản: <%= book.getPublication_year() %></p>
                <p>Số lượng: <%= book.getQuantity() %></p>
                <button onclick="borrowBook(<%= book.getBook_id() %>)">Mượn Sách</button>
            </div>
        <%
            }
        %>
    </div>
    
    <jsp:include page="includes/footer.jsp" />
</body>
</html>