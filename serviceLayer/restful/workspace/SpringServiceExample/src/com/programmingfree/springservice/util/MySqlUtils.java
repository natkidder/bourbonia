package com.programmingfree.springservice.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlUtils {

	static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	
	public static Connection genConnection(String serverName, String db, String username, String password)  {
		Connection connection = null;
		try {
			Class.forName(DRIVER_NAME);
			String url = "jdbc:mysql://" + serverName + "/" + db; 
			System.out.println("url="+url);
			ResultSet resultSet = null;
			connection = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	public static void closeConnection(Connection connection)  {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
