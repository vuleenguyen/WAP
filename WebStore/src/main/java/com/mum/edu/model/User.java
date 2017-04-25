package com.mum.edu.model;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.mum.edu.common.Constant;

public class User {
	private Integer userId;
	private String userName;
	private String passWord;
	private String fullName;
	private String gender;
	private String state;
	private String city;
	private String street;
	private Integer zipCode;
	private Date birthDate;
	private String email;
	private Role role;
	// Transient Variable
	private String roletoMapping;
	
	public User(){}
	
	public User(String userName, String passWord, String fullName, String gender, String state,
			String city, String street, Integer zipCode, Date birthDate, String email, Role role) {
		this.userName = userName;
		this.passWord = passWord;
		this.fullName = fullName;
		this.gender = gender;
		this.state = state;
		this.city = city;
		this.street = street;
		this.zipCode = zipCode;
		this.birthDate = birthDate;
		this.email = email;
		this.role = role;
	}
	
	public User(String userName, String passWord, String fullName, String gender, String state,
			String city, String street, Integer zipCode, Date birthDate, String email, String role) {
		this.userName = userName;
		this.passWord = passWord;
		this.fullName = fullName;
		this.gender = gender;
		this.state = state;
		this.city = city;
		this.street = street;
		this.zipCode = zipCode;
		this.birthDate = birthDate;
		this.email = email;
		this.roletoMapping = role;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Integer getZipCode() {
		return zipCode;
	}

	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getRoletoMapping() {
		return roletoMapping;
	}

	public void setRoletoMapping(String roletoMapping) {
		this.roletoMapping = roletoMapping;
	}

	public void mapRole() {
		if (StringUtils.equals(this.getRoletoMapping(), Constant.MANAGER)) {
			this.setRole(Role.PRODUCTMANAGER);
		} else {
			this.setRole(Role.GUEST);
		}
	}
	
}
