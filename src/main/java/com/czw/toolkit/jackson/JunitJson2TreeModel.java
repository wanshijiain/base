package com.czw.toolkit.jackson;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import org.apache.commons.io.IOUtils;
import org.junit.Ignore;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 看看这种流获取到treemodel的过程
 * @author ZeviChen
 * @Date 2016-08-25 12:45:25
 */
public class JunitJson2TreeModel {

	@Test
	@Ignore
	public void treeModel1() throws MalformedURLException, IOException {
		String url = "http://freemusicarchive.org/api/get/albums.json?api_key=60BLHNQCAOUFPIBZ&limit=2";
		String genreJson = IOUtils.toString(new URL(url), "UTF-8");

		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(genreJson);

		System.out.println(node.getNodeType()); // prints OBJECT
		System.out.println(node.isContainerNode()); // prints true
		Iterator<String> fieldNames = node.fieldNames();
		while (fieldNames.hasNext()) {
			String fieldName = fieldNames.next();
			System.out.println(fieldName);
			// total,
			// total_pages, page, limit, dataset
		}

		System.out.println(node.get("title").asText());
		JsonNode dataset = node.get("dataset");
		System.out.println(dataset.getNodeType()); // Prints ARRAY

		Iterator<JsonNode> datasetElements = dataset.iterator();
		while (datasetElements.hasNext()) {
			JsonNode datasetElement = datasetElements.next();
			
			System.out.println(datasetElement.getNodeType());
			
			Iterator<String> datasetElementFields = datasetElement.fieldNames();
			while (datasetElementFields.hasNext()) {
				String datasetElementField = datasetElementFields.next();
				System.out.println(datasetElementField);
				// album_id,album_title,album_handle,
				// album_url,album_type,artist_name,
				// artist_url,album_producer,album_engineer,
				// album_information,album_date_released,album_comments,
				// album_favorites,album_tracks,album_listens,
				// album_date_created,album_image_file,album_images

			}
			break;
		}
	}
	
	@Test
	@Ignore
	public void treeModel2() throws MalformedURLException, IOException{
		String url = "http://freemusicarchive.org/api/get/albums.json?api_key=60BLHNQCAOUFPIBZ&limit=10";
        String genreJson = IOUtils.toString(new URL(url),"UTF-8");
 
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(genreJson);
 
        Iterator<JsonNode> albums = node.path("dataset").iterator();
        while (albums.hasNext()) {
            System.out.println(albums.next().path("album_title"));
        }
	}
	
}
