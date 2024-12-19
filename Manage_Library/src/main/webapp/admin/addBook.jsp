<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thêm sách mới</title>
    <link rel="stylesheet" href="/Manage_Library/assets/css/style.css">
</head>
<body>
	<jsp:include page = "../includes/headerADM.jsp" />

    <div class="book-form-container">
        <h3>Thêm Sách</h3>
        <form action="/Manage_Library/BookController" method="post">
            <input type="text" name="title" placeholder="Tiêu đề" required>
            <input type="text" name="author" placeholder="Tác giả" required>
            <input type="text" name="publisher" placeholder="Nhà xuất bản" required>
            <input type="number" name="publication_year" placeholder="Năm xuất bản" required>
            <input type="text" name="isbn" placeholder="ISBN" required>
            <input type="text" name="category" placeholder="Thể loại" required>
            <input type="number" name="quantity" placeholder="Số lượng" required>
            <button type="submit">Thêm Sách</button>
        </form>
    </div>
    
	<jsp:include page = "../includes/footer.jsp" />
</body>
</html>