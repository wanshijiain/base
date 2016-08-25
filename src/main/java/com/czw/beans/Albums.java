package com.czw.beans;

/**
 * @author ZeviChen
 * @Date 2016-08-25 13:01:11
 */
public class Albums {
	private String title;
	private Dataset[] dataset;

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDataset(Dataset[] dataset) {
		this.dataset = dataset;
	}

	public String getTitle() {
		return title;
	}

	public Dataset[] getDataset() {
		return dataset;
	}
}
