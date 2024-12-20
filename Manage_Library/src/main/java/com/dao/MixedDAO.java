package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.RecordsUser;

public class MixedDAO {
	private String JDBC_URL = "jdbc:mysql://localhost:3306/Manage_Library";
    private String JDBC_USER = "root";
    private String JDBC_PASSWORD = "12345678";
    
    private static final String RECORD_USER = "SELECT fname, title, borrow_date, return_date, status FROM Users INNER JOIN BorrowRecords ON Users.user_id = BorrowRecords.user_id INNER JOIN Books ON BorrowRecords.book_id = Books.book_id WHERE Users.user_id = ?;"; 
    
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
}
