package com.czw.elastic.entity;

/**
 * @author Zevi Chan
 * @Date 2016-07-27 09:22:39
 */
public class Person {
	private int id;
	private String name;
	private int age;
	private String email;
	private String address;

	public Person() {
	}

	public Person(int id, String name, int age, String email, String address) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
