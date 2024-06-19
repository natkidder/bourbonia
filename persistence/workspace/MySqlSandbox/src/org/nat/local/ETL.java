package org.nat.local;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class ETL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    //String driverName = "org.gjt.mm.mysql.Driver";
		String driverName = "com.mysql.jdbc.Driver";
	    try {
			Class.forName(driverName);

			String serverName = "localhost";
			String mydatabase = "menagerie";
			String url = "jdbc:mysql://" + serverName + "/" + mydatabase; 
			System.out.println("url="+url);
			String username = "nrkidder";
			String password = "wlypb";
			ResultSet resultSet = null;
			Connection connection = DriverManager.getConnection(url, username, password);
			String sql = "select name, species from pet";
			Statement statement = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			resultSet = statement.executeQuery(sql);
			while (resultSet.next())  {
				System.out.println(resultSet.getString(1)+"  "+resultSet.getString(1));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
