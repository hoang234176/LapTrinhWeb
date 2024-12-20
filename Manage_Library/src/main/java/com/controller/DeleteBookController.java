package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.dao.BookDAO;

/**
 * Servlet implementation class DeleteBookController
 */
@WebServlet("/DeleteBookController")
public class DeleteBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBookController() {
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
		String delete_id = request.getParameter("delete_id");
		int book_id = Integer.parseInt(delete_id);
		
		BookDAO BookDAO = new BookDAO();
		boolean DelBookRecord = BookDAO.deleteBookRecord(book_id);
		if (DelBookRecord) {
			boolean DelBook = BookDAO.deleteBook(book_id);
			if (DelBook) {
				request.setAttribute("message", "Đã xóa sách khỏi hệ thống!!");
				getServletContext().getRequestDispatcher("/admin/manageBooks.jsp").forward(request, response);
			} else {
				request.setAttribute("message", "Không thể xóa sách!!");
				getServletContext().getRequestDispatcher("/admin/manageBooks.jsp").forward(request, response);
			}
		} else {
			boolean DelBook = BookDAO.deleteBook(book_id);
			if (DelBook) {
				request.setAttribute("message", "Đã xóa sách khỏi hệ thống!!");
				getServletContext().getRequestDispatcher("/admin/manageBooks.jsp").forward(request, response);
			} else {
				request.setAttribute("message", "Không thể xóa sách!!");
				getServletContext().getRequestDispatcher("/admin/manageBooks.jsp").forward(request, response);
			}
		}
	}

}
