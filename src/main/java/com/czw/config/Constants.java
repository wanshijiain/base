package com.czw.config;

/**
 * @author Zevi Chan
 * @Date 2016-08-02 11:34:29
 */
public enum Constants {
	//elasticsearch config
	ES_CLUSTER_NAME("zevichan"),
	ES_IP_LOCAL("localhost"),
	ES_IP_127("127.0.0.1"),
	ES_IP("192.168.1.113"),
	ES_PORT("9300");
	
	
	
	
	
	
	
	
	private String value;
	private Constants(String value){
		this.value = value;
	}
	public String getValue() {
		return value;
	}
 	
}
