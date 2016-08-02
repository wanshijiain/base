package com.czw.elastic;

import static com.czw.util.ESUtils.initClient;

import org.elasticsearch.client.Client;
import org.junit.After;
import org.junit.Test;

import com.czw.util.ESUtils;

/**
 * @author Zevi Chan
 * @Date 2016-07-26 18:00:59
 */
public class ESDelete {

	@Test
	public void deleteTest() {
		Client client = initClient();
		//DeleteResponse deleteResponse = 
		client.prepareDelete("goods", "info", "201").get();
		System.out.println("the data has been deleted");
	}
	@After
	public void closeClient(){
		ESUtils.close();
		System.out.println("It has been closed!");
	}

}
