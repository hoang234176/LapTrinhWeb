package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

import jakarta.servlet.http.HttpSession;
import com.dao.MixedDAO;
/**
 * Servlet implementation class BorrowBookServlet
 */
@WebServlet("/BorrowBookServlet")
public class BorrowBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrowBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
	    Integer userId = (Integer) session.getAttribute("user_id"); // Lấy ID người dùng từ session

	    if (userId != null) {
	        int bookId = Integer.parseInt(request.getParameter("book_id"));
	        MixedDAO mixedDAO = new MixedDAO();

	        // Kiểm tra số lượng sách có sẵn
	        if (mixedDAO.checkBookAvailability(bookId)) {
	            // Thực hiện mượn sách
	            mixedDAO.borrowBook(userId, bookId, new Date(System.currentTimeMillis()));
	            response.getWriter().write("Mượn sách thành công!"); // Gửi phản hồi thành công
	        } else {
	            response.getWriter().write("Không đủ sách để mượn!"); // Gửi phản hồi lỗi
	        }
	    } else {
	        response.getWriter().write("Bạn cần đăng nhập để mượn sách!"); // Gửi phản hồi lỗi
	    }
	}

}
