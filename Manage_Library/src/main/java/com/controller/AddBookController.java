package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import com.dao.BookDAO;
import com.model.Book;

import java.io.File;
import java.io.IOException;

/**
 * Servlet implementation class AddBookController
 */
@MultipartConfig
@WebServlet("/AddBookController")
public class AddBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBookController() {
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
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String publisher = request.getParameter("publisher");
		String publication_year = request.getParameter("publication_year");
		String isbn = request.getParameter("isbn");
		String category_id = request.getParameter("category_id"); 
		int category = Integer.parseInt(category_id);
		String quantities = request.getParameter("quantities");
		int quantity = Integer.parseInt(quantities);

		// Xử lý file upload
	    Part filePart = request.getPart("image");

	    String image = filePart.getSubmittedFileName();
	    
	    System.out.println(image);
	        
		Book book = new Book();
		book.setTitle(title);
		book.setAuthor(author);
		book.setPublisher(publisher);
		book.setPublication_year(publication_year);
		book.setIsbn(isbn);
		book.setCategory(category);
		book.setQuantity(quantity);
		book.setImage(image);		
		
		// Đường dẫn lưu ảnh
		String uploadPath = getServletContext().getRealPath("/") + "assets" + File.separator + "images";
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdirs();
		}
		filePart.write(uploadPath + File.separator + image);
		
		BookDAO bookDAO = new BookDAO();
		bookDAO.insertBook(book);
		
		request.setAttribute("message", "Thêm sách thành công!");
		
		getServletContext().getRequestDispatcher("/admin/addBook.jsp").forward(request, response);
	}
}
