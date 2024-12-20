<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "com.dao.MixedDAO" %> 
<%@ page import = "com.model.RecordsUser" %>
<%
	String records_User = (String) request.getAttribute("records_User");
	int user_id = Integer.parseInt(records_User);
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Thông tin lịch sử Mượn trả</title>
 	<link rel="stylesheet" href="/Manage_Library/assets/css/style.css">
</head>
<body>
	<jsp:include page="../includes/headerADM.jsp"/>
	
	<div class="record_User">
    	<h2>Lịch sử mượn trả của người dùng.</h2>
    </div>
    <a href="/Manage_Library/admin/manageUsers.jsp">Quay lại</a>
    <table class="user-table user-management">
	    <thead>
	        <tr>
	            <th class="table-header">Họ và Tên</th>
	            <th class="table-header">Tên Sách</th>
	            <th class="table-header">Ngày Mượn</th>
	            <th class="table-header">Ngày trả</th>
	            <th class="table-header">Trạng thái</th>
	        </tr>
	    </thead>
	    <tbody>
	    <%
 		    MixedDAO mixedDAO = new MixedDAO();
			List<RecordsUser> recordsUser = mixedDAO.recordUser(user_id); 
	    %>
	    <%
			if (recordsUser != null) {
	        	for (RecordsUser recordUser : recordsUser) {
	    %>
	        <tr class="table-row">
	            <td class="table-cell"><%= recordUser.getFname() %></td>
	            <td class="table-cell"><%= recordUser.getTitle() %></td>
	            <td class="table-cell"><%= recordUser.getBorrow_date() %></td>
	            <td class="table-cell"><%= recordUser.getReturn_date() %></td>
	            <td class="table-cell"><%= recordUser.getStatus() %></td>
	        </tr>
	    <%
	        }
	    } else {
	    %>
	        <tr>
	            <td colspan="5" class="no-data">Không có dữ liệu</td>
	        </tr>
	    <% } %>
	    </tbody>
	</table>
	
	<jsp:include page="../includes/footer.jsp"/>
</body>
</html>