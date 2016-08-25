package com.czw.toolkit.jackson;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Ignore;
import org.junit.Test;

import com.czw.beans.Albums;
import com.czw.beans.Dataset;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author ZeviChen
 * @Date 2016-08-25 13:10:33
 */
public class JunitJsonDataBinding {
	
	/**
	 * 数据绑定
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	@Test
	@Ignore
	public void dataBinding() throws JsonParseException, JsonMappingException, MalformedURLException, IOException{
		String url = "http://freemusicarchive.org/api/get/albums.json?api_key=60BLHNQCAOUFPIBZ&limit=2";
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        Albums albums = mapper.readValue(new URL(url), Albums.class);
        Dataset[] datasets = albums.getDataset();
        for (Dataset dataset : datasets) {
            System.out.println(dataset.getAlbum_title());
        }
	}
	
	/**
	 * 绑定数据的过滤器
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	@Test
	public void dataBindingFilter2() throws JsonParseException, JsonMappingException, MalformedURLException, IOException{
		String url = "http://freemusicarchive.org/api/get/albums.json?api_key=60BLHNQCAOUFPIBZ&limit=2";
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        AlbumsFilter albums = mapper.readValue(new URL(url), AlbumsFilter.class);
        System.out.println(albums.getTotal_pages());
        System.out.println(albums.getTitle());
        for (DatasetFilter dataset : albums.getDatasetFilter()) {
            System.out.println(dataset.getAlbum_comments());
            System.out.println(dataset.get("album_images"));
            System.out.println(dataset.get("tags"));
            System.out.println(dataset.get("album_listens"));
            break;
        }
	}
	
	
	
}
