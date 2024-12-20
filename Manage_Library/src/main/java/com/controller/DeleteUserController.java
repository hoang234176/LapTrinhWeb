package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.dao.UserDAO;

/**
 * Servlet implementation class DeleteUserController
 */
@WebServlet("/DeleteUserController")
public class DeleteUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUserController() {
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
		int user_id = Integer.parseInt(delete_id);
		
		UserDAO userDAO = new UserDAO();
		boolean DelUserRecord = userDAO.deleteUserRecord(user_id);
		if (DelUserRecord) {
			boolean DelUser = userDAO.deleteUser(user_id);
			if (DelUser) {
				request.setAttribute("message", "Đã xóa người dùng khỏi hệ thống!!");
				getServletContext().getRequestDispatcher("/admin/manageUsers.jsp").forward(request, response);
			} else {
				request.setAttribute("message", "Không thể xóa người dùng!!");
				getServletContext().getRequestDispatcher("/admin/manageUsers.jsp").forward(request, response);
			}
		} else {
			boolean DelUser = userDAO.deleteUser(user_id);
			if (DelUser) {
				request.setAttribute("message", "Đã xóa người dùng khỏi hệ thống!!");
				getServletContext().getRequestDispatcher("/admin/manageUsers.jsp").forward(request, response);
			} else {
				request.setAttribute("message", "Không thể xóa người dùng!!");
				getServletContext().getRequestDispatcher("/admin/manageUsers.jsp").forward(request, response);
			}
		}
	}

}
