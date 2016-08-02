package com.czw.elastic.entity;

/**
 * @author Zevi Chan
 * @Date 2016-08-02 14:58:58
 */
public class IndexTypeBean {
	private String index;
	private String type;
	private String filePath;
	public IndexTypeBean() {}
	public IndexTypeBean(String index, String type) {
		this(index,type,null);
	}
	public IndexTypeBean(String index, String type, String filePath) {
		this.index = index;
		this.type = type;
		this.filePath = filePath;
	}
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	
}
