package com.mum.edu.dao;

import java.sql.SQLException;

import com.mum.edu.model.User;

public interface UserDAO {
	
	public User getUser(String userName) throws ClassNotFoundException, SQLException;

	public void save(User user);
	public void update(User user);
}
