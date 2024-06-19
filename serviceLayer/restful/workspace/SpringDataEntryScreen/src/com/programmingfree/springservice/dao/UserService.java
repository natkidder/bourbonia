package com.programmingfree.springservice.dao;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.programmingfree.springservice.domain.User;
//import com.programmingfree.springservice.utility.DBUtility;
import com.programmingfree.springservice.domain.Users;

public class UserService {

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		try {
			System.out.println("1620-2"); ////
			FileInputStream fstream = new FileInputStream("c:/nat/training/webServices/restful/workspace/SpringDataEntryScreen/DataFile.txt");
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			//Read File Line By Line
			while ((strLine = br.readLine()) != null)     {
				String[] attributes = strLine.split("[ ]+");
				User user = new User();
				user.setUserid(Integer.parseInt(attributes[0]));
				user.setFirstName(attributes[1]);
				user.setLastName(attributes[2]);  
				user.setEmail(attributes[3]);
				users.add(user);
			}
			//Close the input stream
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("getAllUsers - size="+users.size()); ////
		return users;
	}

	public Users getAllUsers2()  {
		List<User> listOfUsers = getAllUsers();
		Users users = new Users();
		users.setUsers(listOfUsers);
		return users;
	}

	public User getUserById(int userId) {
		User user = new User();
		try {

			FileInputStream fstream = new FileInputStream("c:/nat/training/webServices/restful/workspace/SpringDataEntryScreen/DataFile.txt");
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			//Read File Line By Line
			while ((strLine = br.readLine()) != null)     {
				String[] attributes = strLine.split("[ ]+");
				if (Integer.parseInt(attributes[0]) == userId)  {
					user.setUserid(Integer.parseInt(attributes[0]));
					user.setFirstName(attributes[1]);
					user.setLastName(attributes[2]);  
					user.setEmail(attributes[3]);
				}
			}
			//Close the input stream
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

}