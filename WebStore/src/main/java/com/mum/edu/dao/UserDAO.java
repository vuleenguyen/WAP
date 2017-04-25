package com.mum.edu.dao;

import java.sql.SQLException;

import com.mum.edu.model.User;

public interface UserDAO {
	
	public User getUser(String userName) throws ClassNotFoundException, SQLException;
}
