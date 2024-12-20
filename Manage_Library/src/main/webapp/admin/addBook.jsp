<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "com.model.Categories" %>
<%@ page import = "com.dao.CategoriesDAO" %>

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
        <% String message = (String) request.getAttribute("message"); %>
		<% if (message != null) { %>
		    <div class="addbook_notify">
		        <h4><%= message %></h4>
		    </div>
		<% } %>
        <form action="/Manage_Library/AddBookController" method="post" enctype="multipart/form-data">
            <input type="text" name="title" placeholder="Tiêu đề" required>
            <input type="text" name="author" placeholder="Tác giả" required>
            <input type="text" name="publisher" placeholder="Nhà xuất bản" required>
            <input type="number" name="publication_year" placeholder="Năm xuất bản" required>
            <input type="text" name="isbn" placeholder="ISBN" required>
            <input type="text" name="category_id" placeholder="ID Thể loại" required>
            <input type="number" name="quantities" placeholder="Số lượng" required>
            <input type="file" name="image" required>
            <button type="submit">Thêm</button>
        </form>
    </div>
    
    <div>
    	<h1>Danh sách thể loại</h1>
    	<table>
    		<thead>
    			<tr>
    				<th>ID Thể loại</th>
    				<th>Tên thể loại</th>
    			</tr>
    		</thead>
    			<%
    				CategoriesDAO categoriesDAO = new CategoriesDAO();
    				List<Categories> categories = categoriesDAO.getAllCategories();
    				if (categories != null) {
    					for (Categories categori : categories){
    			%>
    		<tbody>
    			<tr>
    				<td><%= categori.getCategory_id() %></td>
    				<td><%= categori.getCategory_name() %></td>
    			</tr>			
    			<%
   						}
    				} else {
    			%>
				<tr>
					<td colspan="2" class="no-data">Không có sách nào!</td>
				</tr>
    			<%
    				}
    			%>
    		</tbody>
    	</table>
    </div>
    
	<jsp:include page = "../includes/footer.jsp" />
</body>
</html>