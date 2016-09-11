package com.czw.beans;

/**
 * @author ZeviChen
 * @Date 2016-09-11 11:13:27
 */
public class Address {
	
	private String province;
	private String city;
	public String getProvince() {
		return province;
	}
	
	public Address(String province, String city) {
		super();
		this.province = province;
		this.city = city;
	}

	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
}
