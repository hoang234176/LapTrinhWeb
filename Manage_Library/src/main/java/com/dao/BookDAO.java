package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.Book;

public class BookDAO {
    private String JDBC_URL = "jdbc:mysql://localhost:3306/Manage_Library";
    private String JDBC_USER = "root";
    private String JDBC_PASSWORD = "12345678";

    private static final String INSERT_BOOK = "INSERT INTO books (title, author, publisher, publication_year, isbn, category, quantity) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String ALL_BOOKS = "SELECT * FROM books";

    public boolean insertBook(Book book) {
        try {
            // Step 1: Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Create connection
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // Step 3: Create and execute SQL statement
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOK);
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setString(3, book.getPublisher());
            preparedStatement.setString(4, book.getPublication_year());
            preparedStatement.setString(5, book.getIsbn());
            preparedStatement.setString(6, book.getCategory());
            preparedStatement.setString(7, book.getQuantity());

            int result = preparedStatement.executeUpdate();

            connection.close();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public List<Book> getAllBook(){
    	List<Book> books = new ArrayList<>();
    	try {
    		// Step 1: Tải driver MySQL
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		
    		// Step 2: Tạo kết nối
    		Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    		
    		// Step 3: Tạo và thực thi câu lệnh SQL
    		PreparedStatement preparedStatement = connection.prepareStatement(ALL_BOOKS);
    		ResultSet resultSet = preparedStatement.executeQuery();
    		
    		while (resultSet.next()) {
    			Book book = new Book();
    			book.setBook_id(resultSet.getInt("book_id"));
    			book.setTitle(resultSet.getString("title"));
    			book.setAuthor(resultSet.getString("author"));
    			book.setPublisher(resultSet.getString("publisher"));
    			book.setPublication_year(resultSet.getString("publication_year"));
    			book.setIsbn(resultSet.getString("isbn"));
    			book.setCategory(resultSet.getString("category"));
    			book.setQuantity(resultSet.getString("quantity"));
    			books.add(book);
    		}
    				
    	} catch (Exception e) {
            e.printStackTrace();
        }
		return books;
    }

}