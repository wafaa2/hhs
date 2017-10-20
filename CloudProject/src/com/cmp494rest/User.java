package com.cmp494rest;

import java.util.ArrayList;

public class User {
	
	private String id;
	private String name;
	private String username;
	private String password;	
	private String address;
	private String email;
	private ArrayList<String> permissions = new ArrayList<String>();
	private String phoneNum;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String geName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public ArrayList<String> getPersmissions() {
		return permissions;
	}
	public void setPermissions(ArrayList<String> permissions) {
		this.permissions = permissions;
	}
	
	public void addPermsissions(String permission) {
		this.permissions.add(permission);
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
}