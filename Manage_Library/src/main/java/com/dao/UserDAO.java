package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.User;


public class UserDAO {
	private String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/Manage_Library";
    private String JDBC_USER = "root";
    private String JDBC_PASSWORD = "12345678";
    
    private static final String LOGIN_USER = "SELECT * FROM users WHERE email = ? AND password = ?";
    private static final String INSERT_USER = "INSERT INTO Users (fname, password, email, role) VALUES (?, ?, ?, ?)";
    private static final String ALL_USER = "SELECT * FROM users WHERE role = 'User'";
    private static final String USER = "SELECT * FROM users WHERE role = 'User' AND user_id = ?";
    
    public User loginUser(String email, String password) {
    	User user = null;
    	try {
    		// Step 1: Tải driver MySQL
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		
    		// Step 2: Tạo kết nối
    		Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    		
    		// Step 3: Tạo và thực thi câu lệnh SQL
    		PreparedStatement preparedStatement = connection.prepareStatement(LOGIN_USER);
    		preparedStatement.setString(1, email);
    		preparedStatement.setString(2, password);
		    ResultSet resultSet = preparedStatement.executeQuery();
		    
		    if (resultSet.next()) {
		    	//Lấy giá trị user_id từ kết quả truy vấn
		    	int user_id = resultSet.getInt("user_id");
		    	String role = resultSet.getString("role");
		    	String fname = resultSet.getString("fname");
		    	user = new User(user_id, fname, email, password, role);
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
    		Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    		
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
    
    public List<User> getAllUsers(){
    	List<User> users = new ArrayList<>();
    	try {
    		// Step 1: Tải driver MySQL
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		
    		// Step 2: Tạo kết nối
    		Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    		
    		// Step 3: Tạo và thực thi câu lệnh SQL
    		PreparedStatement preparedStatement = connection.prepareStatement(ALL_USER);
    		ResultSet resultSet = preparedStatement.executeQuery();
    		
    		while (resultSet.next()) {
    			User user = new User();
    			user.setFname(resultSet.getString("fname"));
    			user.setPassword(resultSet.getString("password"));
    			user.setEmail(resultSet.getString("email"));
    			user.setRole(resultSet.getString("role"));
    			users.add(user);
    		}
    		
    		
    	} catch (Exception e) {
            e.printStackTrace();
        }
		return users;
    }
    
    // Thực hiện truy vấn để lấy thông tin người dùng từ cơ sở dữ liệu
    public User getUserById(int userId) {
        User user = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            PreparedStatement statement = connection.prepareStatement(USER);
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
             if (resultSet.next()) {
                user = new User();
                user.setUser_id(resultSet.getInt("user_id")); // Đảm bảo rằng bạn đang sử dụng đúng tên cột
                user.setFname(resultSet.getString("fname"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setRole(resultSet.getString("role"));
            }
             resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
