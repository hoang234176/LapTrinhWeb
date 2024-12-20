package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.Categories;

public class CategoriesDAO {
	private String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/Manage_Library";
    private String JDBC_categori = "root";
    private String JDBC_PASSWORD = "12345678";
    
    private static final String ALL_CATEGORIES = "SELECT * FROM Categories;";
    
    public List<Categories> getAllCategories(){
    	List<Categories> categories = new ArrayList<>();
    	try {
    		// Step 1: Tải driver MySQL
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		
    		// Step 2: Tạo kết nối
    		Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_categori, JDBC_PASSWORD);
    		
    		// Step 3: Tạo và thực thi câu lệnh SQL
    		PreparedStatement preparedStatement = connection.prepareStatement(ALL_CATEGORIES);
    		ResultSet resultSet = preparedStatement.executeQuery();
    		
    		while (resultSet.next()) {
    			Categories categori = new Categories();
    			categori.setCategory_id(resultSet.getInt("category_id"));
    			categori.setCategory_name(resultSet.getString("category_name"));
    			categories.add(categori);
    		}
    				
    	} catch (Exception e) {
            e.printStackTrace();
        }
		return categories;
    }
}
