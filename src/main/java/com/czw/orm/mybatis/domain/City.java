package com.czw.orm.mybatis.domain;

/**
 * 
 * @author ZeviChen
 * @Date 2016-08-30 14:22:47
 */
public class City {
	
	private int id;
	private String code;
	private String name;
	private int isCapital;
	private String provinceName;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIsCapital() {
		return isCapital;
	}
	public void setIsCapital(int isCapital) {
		this.isCapital = isCapital;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	@Override
	public String toString() {
		return "City [id=" + id + ", code=" + code + ", name=" + name + ", isCapital=" + isCapital + ", provinceName="
				+ provinceName + "]";
	}
	
}
