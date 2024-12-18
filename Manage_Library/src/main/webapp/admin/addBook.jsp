<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản lý Sách</title>
    <link rel="stylesheet" href="/Manage_Library/assets/css/style.css">
</head>
<body>
<jsp:include page = "../includes/headerADM.jsp" />
</head>
<body class="book-management"> <!-- Thêm class vào body -->
    <header class="book-header">
        <h3>Quản Lý Sách</h3>
    </header>

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

</body>
	<jsp:include page = "../includes/footer.jsp" />