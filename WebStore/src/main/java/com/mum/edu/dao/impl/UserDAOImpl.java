package com.mum.edu.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mum.edu.config.DBconnection;
import com.mum.edu.dao.UserDAO;
import com.mum.edu.model.User;

public class UserDAOImpl implements UserDAO {

	@Override
	public User getUser(String userName){
		String query = "SELECT * from user where username = '" + userName + "';";
		User user = null;
		try (Connection con = DBconnection.getMySQLConnection(); Statement stmt = con.createStatement();) {
			System.out.println("the query: " + query);
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				userName = rs.getString("USERNAME");
				String passWord = rs.getString("PASSWORD");
				String fullName = rs.getString("FULLNAME");
				String gender = rs.getString("GENDER");
				String state = rs.getString("STATE");
				String city = rs.getString("CITY");
				String street = rs.getString("STREET");
				Integer zipcode = rs.getInt("ZIPCODE");
				Date birthDate = rs.getDate("BIRTHDATE");
				String email = rs.getString("EMAIL");
				String role = rs.getString("ROLE");
				user = new User(userName, passWord, fullName, gender,
						state, city, street, zipcode, birthDate, email, role);
			}
			stmt.close();
		} catch (SQLException s) {
			System.out.println("Exception thrown in retrieveUser ....");
			s.printStackTrace();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage());
		}
		return user;
	}

}
