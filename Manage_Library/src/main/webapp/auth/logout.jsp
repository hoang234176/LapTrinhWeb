<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	// Hủy session
	session.invalidate();

	// Chuyển hướng về trang đăng nhập
	response.sendRedirect("login.jsp");
%>