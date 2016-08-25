package com.czw.toolkit.jackson;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.czw.beans.Album;
import com.czw.beans.Artist;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * @author ZeviChen
 * @Date 2016-08-25 10:42:53
 */
public class JunitObject2Json {
	private Album album;

	@Before
	public void init() throws ParseException {
		album = new Album("Kind Of Blue");
		album.setLinks(new String[] { "link1", "link2" });

		List<String> songs = new ArrayList<String>();
		songs.add("So What");
		songs.add("Flamenco Sketches");
		songs.add("Freddie Freeloader");
		album.setSongs(songs);

		Artist artist = new Artist();
		// 下面的nameing strategy represent the property.
		artist.name = "Miles Davis";
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		artist.birthDate = format.parse("26-05-1926");
		album.setArtist(artist);

		album.addMusician("Miles Davis", "Trumpet, Band leader");
		album.addMusician("Julian Adderley", "Alto Saxophone");
		album.addMusician("Paul Chambers", "double bass");
	}

	@Test
	@Ignore
	public void createJsonFromJava() throws ParseException, JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();

		// 格式化 缩进排版
		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		// keys sort
		mapper.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);

		// 改变日期格式
		SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
		mapper.setDateFormat(outputFormat);

		mapper.setPropertyNamingStrategy(new PropertyNamingStrategy() {
			private static final long serialVersionUID = 1254236721669045236L;

			/**
			 * 通过字段修改
			 */
			@Override
			public String nameForField(MapperConfig<?> config, AnnotatedField field, String defaultName) {
				if (field.getFullName().equals("com.czw.beans.Artist#name"))
					return "Artist-Name before property is " + defaultName;
				return super.nameForField(config, field, defaultName);
			}

			/**
			 * 通过getter方法修改
			 */
			@Override
			public String nameForGetterMethod(MapperConfig<?> config, AnnotatedMethod method, String defaultName) {
				if (method.getAnnotated().getDeclaringClass().equals(Album.class) && defaultName.equals("title"))
					return "Album-Title";
				return super.nameForGetterMethod(config, method, defaultName);
			}
		});
		// 序列化空值
		mapper.setSerializationInclusion(Include.NON_EMPTY);
		// write a json to console
		mapper.writeValue(System.out, album);
	}

	/**
	 * TreeNode create json
	 * 
	 * @throws IOException
	 */
	@Test
	@Ignore
	public void createJsonUsingTreeModel() throws IOException {
		JsonNodeFactory factory = new JsonNodeFactory(false);

		// create a json factory to write the treenode as json. for the example
		// we just write to console
		JsonFactory jsonFactory = new JsonFactory();
		JsonGenerator generator = jsonFactory.createGenerator(System.out);
		ObjectMapper mapper = new ObjectMapper();

		ObjectNode root = factory.objectNode();
		root.put("Album-Title", "Kind Of Blue");
		ArrayNode links = factory.arrayNode();
		links.add("link1").add("link2");
		// put deprecated.use set or replace
		root.set("links", links);

		ObjectNode artist = factory.objectNode();
		artist.put("Artist-Name", "Miles Davis");
		artist.put("birthDate", "26 May 1926");
		root.set("artist", artist);

		ObjectNode musicians = factory.objectNode();
		musicians.put("Julian Adderley", "Alto Saxophone");
		musicians.put("Miles Davis", "Trumpet, Band leader");
		root.set("musicians", musicians);

		mapper.writeTree(generator, root);
	}
	
	

}
