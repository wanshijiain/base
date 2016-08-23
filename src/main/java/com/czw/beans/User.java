package com.czw.beans;

import java.io.Serializable;

/**
 * @author ZeviChen
 * @Date 2016-08-23 17:22:29
 */
public class User implements Serializable {
	
	private static final long serialVersionUID = -8081346162611635878L;
	
	private int id;
	private String name;
	private String email;
	private String gender;
	private String birthday;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	
}
