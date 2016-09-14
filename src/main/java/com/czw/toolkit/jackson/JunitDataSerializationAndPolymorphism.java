package com.czw.toolkit.jackson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Ignore;
import org.junit.Test;

import com.czw.toolkit.jackson.entity.Animal;
import com.czw.toolkit.jackson.entity.Elephant;
import com.czw.toolkit.jackson.entity.Lion;
import com.czw.toolkit.jackson.entity.Zoo;
import com.czw.util.ComUtils;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author ZeviChen
 * @Date 2016-08-25 13:19:09
 */
public class JunitDataSerializationAndPolymorphism {
	private String outputFile = "zoo.json";
	
	/**
	 * 创建zoo.json文件
	 * @throws IOException
	 */
	@Test
	@Ignore
	public void test() throws IOException{
		File f = new File(ComUtils.getFilePath(this.getClass(),"com.czw", outputFile,true));
		FileWriter fw = new FileWriter(f);
		fw.write("{}");
		fw.close();
		
		BufferedReader br = new BufferedReader(new FileReader(f));
		String line = null;
		while((line = br.readLine()) != null){
			System.out.println(line);
		}
		br.close();
	}
	
	@Test
//	@Ignore
	public void serializeExp() throws JsonGenerationException, JsonMappingException, IOException{
		
        Zoo zoo = new Zoo("Samba Wild Park", "Paz");
        Lion lion = new Lion("Simba");
        Elephant elephant = new Elephant("Manny");
        List<Animal> animals = new ArrayList<>();
        animals.add(lion);
        animals.add(elephant);
        zoo.setAnimals(animals);
 
        ObjectMapper mapper = new ObjectMapper();
        
        File file = new File(ComUtils.getFilePath(this.getClass(),"com.czw.toolkit.jackson", outputFile,true));
        mapper.writerWithDefaultPrettyPrinter().writeValue(new FileWriter(file), zoo);
	}
	
	@Test
	@Ignore
	public void deSerializeExp() throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
        Zoo zoo = mapper.readValue(FileUtils.readFileToByteArray(new File("zoo.json")), Zoo.class);
        System.out.println(zoo);
	}
	
	
	
}
