<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "com.dao.BookDAO" %>
<%@ page import = "com.model.Book" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản lý sách</title>
</head>
<body>
    <jsp:include page="../includes/headerADM.jsp"/>
    
    <div class="manage-book">
    	<h2>Quản lý sách</h2>
    </div>
    
    <table class="book-table">
	    <thead>
	        <tr>
	            <th>ID</th>
	            <th>Tên sách</th>
	            <th>Tác giả</th>
	            <th>Nhà xuất bản</th>
	            <th>Năm xuất bản</th>
	            <th>Mã vạch</th>
	            <th>Thể loại</th>
	            <th>Số lượng</th>
	            <th>Hoạt động</th>
	        </tr>
	    </thead>
	
	    <tbody>
	        <%
	            BookDAO bookDAO = new BookDAO();
	            List<Book> books = bookDAO.getAllBook();
	        %>
	        <%
	            if (books != null){
	                for (Book book : books){
	        %>
	            <tr>
	                <td><%= book.getBook_id() %></td>
	                <td><%= book.getTitle() %></td>
	                <td><%= book.getAuthor() %></td>
	                <td><%= book.getPublisher() %></td>
	                <td><%= book.getPublication_year() %></td>
	                <td><%= book.getIsbn() %></td>
	                <td><%= book.getCategory() %></td>
	                <td><%= book.getQuantity() %></td>
	                <td>
	                    <form action="DeleteBookController" method="post">
	                        <input type="hidden" name="delete_id" value="<%= book.getBook_id()%>">
	                        <button type="submit" class="delete-button" onclick="return confirm('Bạn chắc chắn muốn xóa sách này?');">Xóa</button>
	                    </form>
	                    <form action="EditBookController" method="post">
	                        <input type="hidden" name="delete_id" value="<%= book.getBook_id() %>">
	                        <button type="submit" class="edit-button">Sửa</button>
	                    </form>
	                </td>
	            </tr>
	        <%
	                }
	            } else {
	        %>
		        <tr>
		            <td colspan="9" class="no-data">Không có sách nào!</td>
		        </tr>
	        <%
	            }
	        %>
	    </tbody>
	</table>

    <a href="addBook.jsp" class="button-addbook">Thêm sách</a><br>
    
    <jsp:include page="../includes/footer.jsp"/>
</body>
</html>