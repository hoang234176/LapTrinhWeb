package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.dao.MixedDAO;
import com.model.RecordsUser;

import java.io.IOException;
import java.util.List;

@WebServlet("/BorrowReturnInfo")
public class BorrowReturnInfo extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public BorrowReturnInfo() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("user_id");

        if (userId != null) {
            MixedDAO mixedDAO = new MixedDAO();
            String action = request.getParameter("action");

            if ("borrow".equals(action)) {
                List<RecordsUser> borrowedBooks = mixedDAO.getBorrowedBooks(userId);
                request.setAttribute("borrowedBooks", borrowedBooks);
                request.getRequestDispatcher("/views/BorrowInfo.jsp").forward(request, response);
            } else if ("return".equals(action)) {
                List<RecordsUser> returnedBooks = mixedDAO.getReturnedBooks(userId);
                request.setAttribute("returnedBooks", returnedBooks);
                request.getRequestDispatcher("/views/ReturnInfo.jsp").forward(request, response);
            }
        } else {
            response.sendRedirect("./auth/login.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}