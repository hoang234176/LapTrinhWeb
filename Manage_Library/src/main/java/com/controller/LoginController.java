package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.dao.UserDAO;
import com.model.User;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
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
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UserDAO userDAO = new UserDAO();
		User user = userDAO.loginUser(email, password);
		
		HttpSession session = request.getSession();
		
		if (user != null) {
			session.setAttribute("user_id", user.getUser_id());
		    session.setAttribute("fname", user.getFname());
		    session.setAttribute("role", user.getRole());
		    
		    if ("Admin".equalsIgnoreCase(user.getRole())) {
                getServletContext().getRequestDispatcher("/admin/dashboard.jsp").forward(request, response);
            } else if ("User".equalsIgnoreCase(user.getRole())) {
                getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            }
		} else {
		    // Xử lý khi không tìm thấy user
		    request.setAttribute("message", "Tài khoản hoặc mật khẩu sai!");
		    getServletContext().getRequestDispatcher("/auth/login.jsp").forward(request, response);
		}
	}
}
