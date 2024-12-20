package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.RecordsUser;

public class MixedDAO {
	private String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/Manage_Library";
    private String JDBC_USER = "root";
    private String JDBC_PASSWORD = "12345678";
    
    private static final String RECORD_USER = "SELECT fname, title, borrow_date, return_date, status FROM Users INNER JOIN BorrowRecords ON Users.user_id = BorrowRecords.user_id INNER JOIN Books ON BorrowRecords.book_id = Books.book_id WHERE Users.user_id = ?;"; 
    private static final String BORROWED_BOOKS = "SELECT title, borrow_date FROM BorrowRecords INNER JOIN Books ON BorrowRecords.book_id = Books.book_id WHERE user_id = ? AND status = 'Borrowed';";
    private static final String RETURNED_BOOKS = "SELECT title, return_date FROM BorrowRecords INNER JOIN Books ON BorrowRecords.book_id = Books.book_id WHERE user_id = ? AND status = 'Returned';";
    private static final String SL_BOOK = "SELECT quantity FROM Books WHERE book_id = ?";
    private static final String INSERT_BOOK_BORROW = "INSERT INTO BorrowRecords (user_id, book_id, borrow_date, status) VALUES (?, ?, ?, 'Borrowed')";
    private static final String UPDATE_SL_BOOK = "UPDATE Books SET quantity = quantity - 1 WHERE book_id = ?";
    
    public List<RecordsUser> recordUser(int user_id) {
    	List<RecordsUser> recordsUsers = new ArrayList<>();
    	try {
    		// Step 1: Tải driver MySQL
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		
    		// Step 2: Tạo kết nối
    		Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    		
    		// Step 3: Tạo và thực thi câu lệnh SQL
    		PreparedStatement preparedStatement = connection.prepareStatement(RECORD_USER);
    		preparedStatement.setInt(1, user_id);
    		
    		try {
    			ResultSet resultSet = preparedStatement.executeQuery();
    			while (resultSet.next()) {
    				RecordsUser recordUser = new RecordsUser();
    				recordUser.setFname(resultSet.getString("fname"));
    				recordUser.setTitle(resultSet.getString("title"));
    				recordUser.setBorrow_date(resultSet.getString("borrow_date"));
    				recordUser.setReturn_date(resultSet.getString("return_date"));
    				recordUser.setStatus(resultSet.getString("status"));
    				recordsUsers.add(recordUser);
    			}
    		} catch (Exception e) {
                e.printStackTrace(); // Log lỗi khi thực thi câu truy vấn
            }
        } catch (Exception e) {
            e.printStackTrace(); // Log lỗi khi kết nối hoặc chuẩn bị câu lệnh SQL
        }
		return recordsUsers;
    }
    
    public List<RecordsUser> getBorrowedBooks(int user_id) {
        List<RecordsUser> borrowedBooks = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(BORROWED_BOOKS);
            preparedStatement.setInt(1, user_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                RecordsUser record = new RecordsUser();
                record.setTitle(resultSet.getString("title"));
                record.setBorrow_date(resultSet.getString("borrow_date"));
                borrowedBooks.add(record);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return borrowedBooks;
    }

    public List<RecordsUser> getReturnedBooks(int user_id) {
        List<RecordsUser> returnedBooks = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(RETURNED_BOOKS);
            preparedStatement.setInt(1, user_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                RecordsUser record = new RecordsUser();
                record.setTitle(resultSet.getString("title"));
                record.setReturn_date(resultSet.getString("return_date"));
                returnedBooks.add(record);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnedBooks;
    }
    
    public boolean checkBookAvailability(int book_id) {
        boolean available = false;
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(SL_BOOK)) {
            preparedStatement.setInt(1, book_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                available = resultSet.getInt("quantity") > 0; // Kiểm tra số lượng sách
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return available;
    }

    public void borrowBook(int user_id, int book_id, Date borrow_date) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement insertStatement = connection.prepareStatement(INSERT_BOOK_BORROW);
             PreparedStatement updateStatement = connection.prepareStatement(UPDATE_SL_BOOK)) {
            
            // Thêm bản ghi mượn sách
            insertStatement.setInt(1, user_id);
            insertStatement.setInt(2, book_id);
            insertStatement.setDate(3, borrow_date);
            insertStatement.executeUpdate();
            
            // Cập nhật số lượng sách
            updateStatement.setInt(1, book_id);
            updateStatement.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
