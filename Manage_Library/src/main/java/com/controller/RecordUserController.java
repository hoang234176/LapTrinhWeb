package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.dao.MixedDAO;
import com.dao.UserDAO;
import com.model.RecordsUser;

/**
 * Servlet implementation class RecordUserController
 */
@WebServlet("/RecordUserController")
public class RecordUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecordUserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int user_id = 3;
		
		MixedDAO mixedDAO = new MixedDAO();
		List<RecordsUser> rus = mixedDAO.recordUser(user_id);
		if (rus != null) {
			for (RecordsUser ru : rus) {
				System.out.println("------------------");
				System.out.println(ru.getFname());
				System.out.println(ru.getTitle());
				System.out.println(ru.getBorrow_date());
				System.out.println(ru.getReturn_date());
				System.out.println(ru.getStatus());
			}
		} else {
			System.out.println("Khong co du lieu!");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String recordsUser = request.getParameter("recordsUser");
		
		request.setAttribute("records_User", recordsUser);
		
		getServletContext().getRequestDispatcher("/admin/borrowRecords.jsp").forward(request, response);
	}

}
