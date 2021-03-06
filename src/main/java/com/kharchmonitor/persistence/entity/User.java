package com.kharchmonitor.persistence.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.index.Indexed;

public class User {

	private String _id;

	@Indexed(unique = true)
	private String userName;
	
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	
	private List<Group> groups = new ArrayList<Group>();
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public List<Group> getGroups() {
		return groups;
	}
	public void addGroup(Group group) {
		this.groups.add(group);
	}
}
