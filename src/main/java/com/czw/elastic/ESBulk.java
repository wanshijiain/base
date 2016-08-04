package com.czw.elastic;

import static com.czw.util.ESUtils.initClient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import org.elasticsearch.action.bulk.BackoffPolicy;
import org.elasticsearch.action.bulk.BulkProcessor;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.unit.ByteSizeUnit;
import org.elasticsearch.common.unit.ByteSizeValue;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHits;
import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;

import com.czw.elastic.entity.IndexTypeBean;
import com.czw.util.ESUtils;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Zevi Chan
 * @Date 2016-07-27 13:16:09
 */
public class ESBulk {

	/**
	 * 批量查询
	 */
	@Test
	@Ignore
	public void bulkTest() {
		Client client = initClient();
		BulkRequestBuilder bulkRequest = client.prepareBulk();
		// either use client#prepare, or use Requests# to directly build
		// index/delete requests
		try {
			bulkRequest.add(client.prepareIndex("megacorp", "employee", "1")
					.setSource(XContentFactory.jsonBuilder().startObject().field("user", "kimchy")
							.field("postDate", new Date()).field("message", "trying out Elasticsearch").endObject()));

			bulkRequest.add(client.prepareIndex("megacorp", "employee", "2")
					.setSource(XContentFactory.jsonBuilder().startObject().field("user", "kimchy")
							.field("postDate", new Date()).field("message", "another post").endObject()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		BulkResponse bulkResponse = bulkRequest.get();
		if (bulkResponse.hasFailures()) {
			// process failures by iterating through each bulk response item
		}
	}

	/**
	 * 批量操作
	 */
	@Test
	@Ignore
	public void bulkProcessorTest() {

		BulkProcessor bulkProcessor = BulkProcessor.builder(initClient(), new BulkProcessor.Listener() {
			// for example request.numberOfActions()
			@Override
			public void beforeBulk(long executionId, BulkRequest request) {
			}

			// for example response.hasFailures()
			@Override
			public void afterBulk(long executionId, BulkRequest request, BulkResponse response) {
			}

			// when failed and raised a Throwable
			@Override
			public void afterBulk(long executionId, BulkRequest request, Throwable failure) {
			}
		}).setBulkActions(10000) // 10000 requests execute
				.setBulkSize(new ByteSizeValue(1, ByteSizeUnit.GB)) // 1gb
																	// execute
				.setFlushInterval(TimeValue.timeValueSeconds(5)) // 5s execute
				.setConcurrentRequests(1) // 0 single request executes,1 execute
											// while accumulating new bulk
											// requests.
				.setBackoffPolicy(BackoffPolicy.exponentialBackoff(TimeValue.timeValueMillis(100), 3)).build();

		bulkProcessor.add((IndexRequest) new IndexRequest("twitter", "tweet", "1")
				.source(/* your doc here */));
		bulkProcessor.add(new DeleteRequest("twitter", "tweet", "2"));
	}
	
	
	/**
	 * 将导出的文本文件批量导入es中
	 */
	@Test
	public void bulkBatchImport() {
//		IndexTypeBean itb = new IndexTypeBean("goods","info","d:\\tmp\\goods_info.dat");
//		IndexTypeBean itb = new IndexTypeBean("operate","log","d:\\tmp\\admin_op_log.dat");		数据太大需要优化
//		IndexTypeBean itb = new IndexTypeBean("bill","record","d:\\tmp\\bill_record_info.dat");
//		IndexTypeBean itb = new IndexTypeBean("city","name","d:\\tmp\\city.dat");
		IndexTypeBean itb = new IndexTypeBean("county","name","d:\\tmp\\county.dat");
//		IndexTypeBean itb = new IndexTypeBean("coupon","info","d:\\tmp\\coupon_info.dat");
		Client client = initClient();
		try {
			BufferedReader br = new BufferedReader(new FileReader(itb.getFilePath()));
			String json = null;
			BulkResponse bulkResponse = null;
			int count = 0;
			BulkRequestBuilder bulkRequest = client.prepareBulk();
			while ((json = br.readLine()) != null) {
				// ObjectMapper om = new ObjectMapper();
				// JsonNode jn = om.readTree(json);
				// System.out.println("_id="+jn.get("_id"));
				// , jn.get("_id") + "-" + jn.get("goodsCode")
				System.out.println(count);
				bulkRequest.add(client.prepareIndex(itb.getIndex(), itb.getType()).setId(count+1+"").setSource(json));
				if (count % 1000 == 0) {
					bulkResponse = bulkRequest.execute().actionGet();
					System.out.println("提交了：" + count);
				}
				count++;
			}
			bulkRequest.execute().actionGet();
			if (bulkResponse != null) {
				if (bulkResponse.hasFailures())
					System.out.println(bulkResponse.buildFailureMessage());
				else
					System.out.println("插入完毕." + bulkResponse.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 批量导出es中的文件
	 */
	@Test
	@Ignore
	public void bulkBatchExport() {
		Client client = initClient();
		SearchResponse response = client.prepareSearch("goods").setTypes("info").setQuery(QueryBuilders.matchAllQuery())
				.setSize(10000).setScroll(new TimeValue(600000)).setSearchType(SearchType.SCAN).execute().actionGet();// setSearchType(SearchType.Scan)

		// 告诉ES不需要排序只要结果返回即可
		// setScroll(new
		// TimeValue(600000))
		// 设置滚动的时间
		String scrollid = response.getScrollId();
		try {
			// 把导出的结果以JSON的格式写到文件里
			BufferedWriter out = new BufferedWriter(new FileWriter("es", true));

			// 每次返回数据10000条。一直循环查询直到所有的数据都查询出来
			while (true) {
				SearchResponse response2 = client.prepareSearchScroll(scrollid).setScroll(new TimeValue(1000000))
						.execute().actionGet();
				SearchHits searchHit = response2.getHits();
				// 再次查询不到数据时跳出循环
				if (searchHit.getHits().length == 0) {
					break;
				}
				System.out.println("查询数量 ：" + searchHit.getHits().length);
				for (int i = 0; i < searchHit.getHits().length; i++) {
					String json = searchHit.getHits()[i].getSourceAsString();
					out.write(json);
					out.write("\r\n");
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@After
	public void closeClient(){
		ESUtils.close();
	}

}
