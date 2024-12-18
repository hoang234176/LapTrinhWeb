package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.Book;

public class BookDAO {
    private String JDBC_URL = "jdbc:mysql://localhost:3306/Manage_Library";
    private String JDBC_USER = "root";
    private String JDBC_PASSWORD = "12345678";

    private static final String INSERT_BOOK = "INSERT INTO books (title, author, publisher, publication_year, isbn, category, quantity) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String GET_BOOK_BY_ISBN = "SELECT * FROM books WHERE isbn = ?";

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

    public Book getBookByIsbn(String isbn) {
        Book book = null;
        try {
            // Step 1: Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Create connection
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // Step 3: Create and execute SQL statement
            PreparedStatement preparedStatement = connection.prepareStatement(GET_BOOK_BY_ISBN);
            preparedStatement.setString(1, isbn);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                String publisher = resultSet.getString("publisher");
                String publication_Year = resultSet.getString("publication_year");
                String category = resultSet.getString("category");
                String quantity = resultSet.getString("quantity");

                book = new Book(title, author, publisher, publication_Year, isbn, category, quantity);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }
}