// Manage_Library/src/main/java/com/dao/BookDAO.java
package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.Book;

public class BookDAO {
    private String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/Manage_Library";
    private String JDBC_fname = "root";
    private String JDBC_PASSWORD = "12345678";

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        try {
            // Tải driver MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Tạo kết nối
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_fname, JDBC_PASSWORD);
            
            // Tạo và thực thi câu lệnh SQL
            String query = "SELECT * FROM Books";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                Book book = new Book(
                    resultSet.getInt("book_id"),
                    resultSet.getString("title"),
                    resultSet.getString("author"),
                    resultSet.getString("publisher"),
                    resultSet.getInt("publication_year"),
                    resultSet.getString("isbn"),
                    resultSet.getInt("category"),
                    resultSet.getInt("quantity"),
                    resultSet.getString("image")
                );
                books.add(book);
            }
            
            // Đóng kết nối
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return books;
    }
}