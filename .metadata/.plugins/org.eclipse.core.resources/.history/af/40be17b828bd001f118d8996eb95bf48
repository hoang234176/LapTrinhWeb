package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.User;

public class UserDAO {
	private String JDBC_URL = "jdbc:mysql://localhost:3307/Manage_Library";
    private String JDBC_fname = "root";
    private String JDBC_PASSWORD = "12345678";
    
    private static final String LOGIN_LOGIN = "SELECT * FROM users WHERE email = ? AND password = ?";
    private static final String INSERT_USER = "INSERT INTO Users (fname, password, email, role) VALUES (?, ?, ?, ?)";
    
    public User loginUser(String email, String password) {
    	String role = null;
    	String fname = null;
    	User user = null;
    	try {
    		// Step 1: Tải driver MySQL
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		
    		// Step 2: Tạo kết nối
    		Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_fname, JDBC_PASSWORD);
    		
    		// Step 3: Tạo và thực thi câu lệnh SQL
    		PreparedStatement preparedStatement = connection.prepareStatement(LOGIN_LOGIN);
    		preparedStatement.setString(1, email);
    		preparedStatement.setString(2, password);
		    ResultSet resultSet = preparedStatement.executeQuery();
		    
		    if (resultSet.next()) {
		    	//Lấy giá trị role để xử lý duy trì đăng nhập
		    	role = resultSet.getString("role");
		    	fname = resultSet.getString("fname");
		    	user = new User(fname, email, password, role);
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
		return user;
    }
    
    public boolean insertUser(User user) {
    	try {
    		// Step 1: Tải driver MySQL
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		
    		// Step 2: Tạo kết nối
    		Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_fname, JDBC_PASSWORD);
    		
    		// Step 3: Tạo và thực thi câu lệnh SQL
    		PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER);
    		preparedStatement.setString(1, user.getFname());
    		preparedStatement.setString(2, user.getPassword());
    		preparedStatement.setString(3, user.getEmail());
    		preparedStatement.setString(4, user.getRole());
            
            int result = preparedStatement.executeUpdate();
            
            connection.close();
            return result > 0;
    	} catch (Exception e) {
            e.printStackTrace();
        }
    	return false;
    }
}
