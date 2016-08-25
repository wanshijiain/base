package com.czw.toolkit.jackson;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author ZeviChen
 * @Date 2016-08-25 13:06:40
 */
@JsonAutoDetect(fieldVisibility = Visibility.NONE, getterVisibility = Visibility.PUBLIC_ONLY)
public class AlbumsFilter {
 
    private String title;
    private DatasetFilter[] datasetFilter;
    public String total_pages;
 
    protected String getTotal_pages() {
        return total_pages;
    }
 
    public String getTitle() {
        return title;
    }
 
    // this getter method is for the 'dataset' property
    @JsonProperty("dataset")
    public DatasetFilter[] getDatasetFilter() {
        return datasetFilter;
    }
}
