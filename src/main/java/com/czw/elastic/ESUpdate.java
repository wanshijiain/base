package com.czw.elastic;

import static com.czw.util.ESUtils.*;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;

import com.czw.util.ESUtils;

/**
 * @author Zevi Chan
 * @Date 2016-07-26 18:03:25
 */
public class ESUpdate {

	@Test
	@Ignore
	public void updateTest() {
		Client client = initClient();
		UpdateRequest updateRequest = new UpdateRequest();
		updateRequest.index("goods");
		updateRequest.type("info");
		updateRequest.id("1");
		try {
			updateRequest.doc(XContentFactory.jsonBuilder()
					.startObject()
					.field("goodsShows", "单果约100-130g，皮薄肉脆，果肉细腻清甜,哈哈--智障")
					.endObject());

			UpdateResponse response = client.update(updateRequest).get();
			printResponse(response);
		} catch (InterruptedException | IOException | ExecutionException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * document/id必须存在
	 */
	@Test
	@Ignore
	public void preparedUpdateTest(){
		Client client = initClient();
		
		//通过文件中的键值对或者字符串键值对来更新
		//如果通过文件使用：ScriptService.ScriptType.FILE
		
		/*client.prepareUpdate("ttl", "doc", "1")
				.setScript(new Script("ctx._source.gender = \"male\"", ScriptService.ScriptType.INLINE, null, null))
				.get();*/
		try {
			
			//不存在document会报错missing
			UpdateResponse response = client.prepareUpdate("goods", "info", "1")
					.setDoc(XContentFactory.jsonBuilder()
							.startObject()
							.field("goodsName", "库尔勒香梨 特级 <什么鬼名字，没听过>")
							.endObject())
					.get();
			printResponse(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * indexRequest-查询不到就加入
	 * UpdateRequest-更新shard
	 */
	@Test
	
	public void updateAddTest(){
		try {
		
			Client client = initClient();
			IndexRequest indexRequest = new IndexRequest("goods", "info", "95535")
			        .source(XContentFactory.jsonBuilder()
			        		.startObject()
			        		.field("goodsName", "库尔勒香梨 特级 <什么鬼名字，没听过>")
							.endObject());
			UpdateRequest updateRequest = new UpdateRequest("goods", "info", "95535")
			        .doc(XContentFactory.jsonBuilder()
			        		.startObject()
			        		.field("goodsName", "库尔勒香梨 特级 <什么鬼名字，没听过>")
							.endObject())
			        .upsert(indexRequest);              
			UpdateResponse response = client.update(updateRequest).get();
			printResponse(response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@Ignore
	public void indexResponse(){
		Client c = initClient();
		IndexResponse ir = c.prepareIndex("goods", "info").setSource("").execute().actionGet();
		printResponse(ir);
	}
	
	
	
	@After
	public void closeClient(){
		ESUtils.close();
		System.out.println("It has been closed!");
	}

}
