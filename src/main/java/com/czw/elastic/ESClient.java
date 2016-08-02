package com.czw.elastic;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.Client;
import org.junit.After;
import org.junit.Test;

import com.czw.util.ESUtils;

/**
 * @author Zevi Chan
 * @Date 2016-07-26 14:05:36
 */
public class ESClient {

	@Test
	public void testClient(){
		Client client = ESUtils.initClient();
		
		GetResponse response;
		response = client.prepareGet("megacorp", "employee", "1").execute().actionGet();
		System.out.println();
		System.out.println("索引：" + response.getIndex() + "/" + response.getType() + "/" + response.getId() + ",结果:"
				+ response.getSourceAsString());
		System.out.println();
		client.close();
	}
	@After
	public void closeClient(){
		ESUtils.close();
		System.out.println("It has been closed!");
	}

}
