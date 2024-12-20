<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.model.RecordsUser" %>
<%@ page import="com.dao.MixedDAO" %> 
<%
    HttpSession sessions = request.getSession();
    Integer user_id = (Integer) sessions.getAttribute("user_id"); // Lấy ID người dùng từ session
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thông tin Mượn Sách</title>
    <link rel="stylesheet" type="text/css" href="/Manage_Library/assets/css/style.css">
</head>
<body>
	<jsp:include page="../includes/header.jsp"/>
    <h1 class="page-title">Thông tin Mượn Sách</h1>
    <table class="info-table">
        <thead>
            <tr>
                <th class="table-header">Tên Sách</th>
                <th class="table-header">Ngày Mượn</th>
            </tr>
        </thead>
        <tbody>
            <%
                if (user_id != null) {
                    MixedDAO mixedDAO = new MixedDAO();
                    List<RecordsUser> borrowedBooks = mixedDAO.getBorrowedBooks(user_id);
                    if (borrowedBooks != null && !borrowedBooks.isEmpty()) {
                        for (RecordsUser book : borrowedBooks) {
            %>
                <tr class="table-row">
                    <td class="table-cell"><%= book.getTitle() %></td>
                    <td class="table-cell"><%= book.getBorrow_date() %></td>
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
                } else {
            %>
                <tr>
                    <td colspan="2" class="no-data">Không tìm thấy ID người dùng!</td>
                </tr>
            <%
                }
            %>
        </tbody>
    </table>
	<jsp:include page="../includes/footer.jsp"/>
</body>
</html>