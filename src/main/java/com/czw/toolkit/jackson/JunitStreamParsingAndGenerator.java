package com.czw.toolkit.jackson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Ignore;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/**
 * @author ZeviChen
 * @Date 2016-08-25 11:44:50
 */
public class JunitStreamParsingAndGenerator {
	
	/**
	 * 从流对象中读取json
	 * @throws JsonParseException
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	@Test
	@Ignore
	public void streamParsing() throws JsonParseException, MalformedURLException, IOException{
		//????
        String url = "http://freemusicarchive.org/api/get/albums.json?api_key=60BLHNQCAOUFPIBZ&limit=5";
        JsonFactory factory = new JsonFactory();
        JsonParser parser = factory.createParser(new URL(url));
 
        while (!parser.isClosed()) {
            JsonToken token = parser.nextToken();
            if (token == null)
                break;
 
            if (JsonToken.FIELD_NAME.equals(token) && "dataset".equals(parser.getCurrentName())) {
                token = parser.nextToken();
                if (!JsonToken.START_ARRAY.equals(token)) {
                    break;
                }
                token = parser.nextToken();
                if (!JsonToken.START_OBJECT.equals(token)) {
                    break;
                }
                while (true) {
                    token = parser.nextToken();
                    if (token == null)
                        break;
                    if (JsonToken.FIELD_NAME.equals(token) && "album_title".equals(parser.getCurrentName())) {
                        token = parser.nextToken();
                        System.out.println(parser.getText());
                    }
                }
            }
        }
	}
	
	/**
	 * json生成器，写入到文件中
	 * @throws IOException
	 */
	@Test
	public void generator() throws IOException{
		JsonFactory factory = new JsonFactory();
        JsonGenerator generator = factory.createGenerator(new FileWriter(new File("albums.json")));
 
        // start writing with {
        generator.writeStartObject();
        generator.writeFieldName("title");
        generator.writeString("Free Music Archive - Albums");
        generator.writeFieldName("dataset");
        // start an array
        generator.writeStartArray();
        generator.writeStartObject();
        generator.writeStringField("album_title", "A.B.A.Y.A.M");
        generator.writeEndObject();
        generator.writeEndArray();
        generator.writeEndObject();
 
        generator.close();
	}
	
}
