package com.czw.elastic;

import static com.czw.util.ESUtils.initClient;
import static com.czw.util.ComUtils.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.elasticsearch.action.search.MultiSearchResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.histogram.DateHistogramInterval;
import org.elasticsearch.search.aggregations.bucket.histogram.InternalDateHistogram;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.metrics.MetricsAggregationBuilder;
import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;

import com.czw.util.ComUtils;
import com.czw.util.ESUtils;

/**
 * Deprecated in 2.1.0. Use the search api instead and set size to 0.
 * 
 * Thread Mode: 1.NO_THREADS 当前线程执行 2.SINGLE_THREAD 另起一个线程执行所有分片
 * 3.THREAD_PER_SHARD 每个分片起个线程执行操作
 * 
 * @author Zevi Chan
 * @Date 2016-07-27 15:07:11
 */
public class ESSearch {
	private Client client = initClient();

	@Test
	public void searchTest() {
		start();
		Map<String,String> query = new HashMap<>();
		query.put("goodsCode", "gss_xiangjiao4");
		
		QueryBuilder query1 = QueryBuilders.matchPhraseQuery("goods", "gss ao");
		
		SearchResponse response2 = client.prepareSearch("goods").setTypes("info").setQuery(query)
				.execute().actionGet();
		System.out.println("TotalHits:" + response2.getHits().getTotalHits());
		for (int i = 0; i < response2.getHits().totalHits(); i++) {
			System.out.println(response2.getHits().getAt(i).sourceAsString());
		}
	}

	@Test
	@Ignore
	public void searchTest2() {
		/*
		 * ComUtils.start();
		 * 
		 * SearchResponse response =
		 * client.prepareSearch("goods").setTypes("info")
		 * .setSearchType(SearchType.DFS_QUERY_THEN_FETCH).setQuery(
		 * QueryBuilders.termQuery("id",152)) // Query //
		 * .setPostFilter(QueryBuilders.rangeQuery("age").from(12).to(18)) //
		 * Filter // .setFrom(0).setSize(60).setExplain(true)
		 * .execute().actionGet(); printResponse(response);
		 */

	}

	@Test
	@Ignore
	public void searchScroll1() {
		ComUtils.start();
		SearchResponse scrollResponse = client.prepareSearch("goods").setSearchType(SearchType.SCAN).setSize(10000)
				.setScroll(TimeValue.timeValueMinutes(1)).execute().actionGet();
		long count = scrollResponse.getHits().getTotalHits();// 第一次不返回数据
		for (int i = 0, sum = 0; sum < count; i++) {
			scrollResponse = client.prepareSearchScroll(scrollResponse.getScrollId())
					.setScroll(TimeValue.timeValueMinutes(8)).execute().actionGet();
			sum += scrollResponse.getHits().hits().length;
			System.out.println("总量" + count + " 已经查到" + sum);
		}
	}

	/**
	 * 滚动 size-from or scan
	 * 
	 * setTerminateAfter(1000) finish after 1000 docs
	 */
	@Test
	@Ignore
	public void scrollTest() {
		ComUtils.start();
		QueryBuilder qb = QueryBuilders.termQuery("goodsName", "山东");
		/*
		 * SearchResponse scrollResp = client.prepareSearch("goods")
		 * .addSort(SortParseElement.DOC_FIELD_NAME,
		 * SortOrder.ASC).setScroll(new TimeValue(60000)).setQuery(qb)
		 * .setSize(100).execute().actionGet();
		 */
		SearchResponse scrollResp = client.prepareSearch("goods").setSearchType(SearchType.DEFAULT)
				.setScroll(new TimeValue(60000)).setQuery(qb).setSize(100).execute().actionGet();
		// 100
		// hits
		// per
		// shard
		// will
		// be
		// returned
		// for
		// each
		// scroll
		// Scroll until no hits are returned

		// 保存查询快照100m时间
		// 100 hits per shard will be returned for each scroll
		// Scroll until no hits are returned
		/*
		 * while (true) {
		 * 
		 * for (SearchHit hit : scrollResp.getHits().getHits()) { // Handle the
		 * hit... System.out.println(hit.getSourceAsString()); } scrollResp =
		 * client.prepareSearchScroll(scrollResp.getScrollId()).setScroll(new
		 * TimeValue(60000)).execute() .actionGet(); // Break condition: No hits
		 * are returned if (scrollResp.getHits().getHits().length == 0) { break;
		 * } }
		 */
		System.out.println("开始循环");
		while (true) {
			scrollResp = client.prepareSearchScroll(scrollResp.getScrollId()).setScroll(new TimeValue(600000)).execute()
					.actionGet();
			for (SearchHit hit : scrollResp.getHits()) {
				Iterator<Entry<String, Object>> rpItor = hit.getSource().entrySet().iterator();
				while (rpItor.hasNext()) {
					Entry<String, Object> rpEnt = rpItor.next();
					System.out.println(rpEnt.getKey() + " : " + rpEnt.getValue());
				}
			}
			// Break condition: No hits are returned
			if (scrollResp.getHits().hits().length == 0) {
				break;
			}
		}
		System.out.println("结束循环");

	}

	/**
	 * 多查询组合
	 */
	@Test
	@Ignore
	public void mutiSearchTest() {
		SearchRequestBuilder srb1 = client.prepareSearch().setQuery(QueryBuilders.queryStringQuery("香蕉")).setSize(1);
		SearchRequestBuilder srb2 = client.prepareSearch().setQuery(QueryBuilders.matchQuery("goodsName", "海南特小凤"))
				.setSize(1);

		MultiSearchResponse sr = client.prepareMultiSearch().add(srb1).add(srb2).execute().actionGet();

		// You will get all individual responses from
		// MultiSearchResponse#getResponses()
		long nbHits = 0;
		for (MultiSearchResponse.Item item : sr.getResponses()) {
			SearchResponse response = item.getResponse();
			nbHits += response.getHits().getTotalHits();
		}
	}

	/**
	 * 聚合查询类似group by
	 */
	@Test
	@Ignore
	public void aggregationTest() {
		SearchResponse sr = client.prepareSearch().setQuery(QueryBuilders.matchAllQuery())
				.addAggregation(AggregationBuilders.terms("agg1").field("field"))
				.addAggregation(
						AggregationBuilders.dateHistogram("agg2").field("birth").interval(DateHistogramInterval.YEAR))
				.execute().actionGet();

		// Get your facet results
		Terms agg1 = sr.getAggregations().get("agg1");
		InternalDateHistogram agg2 = sr.getAggregations().get("agg2");
	}

	/**
	 * more infomations gov
	 * url:https://www.elastic.co/guide/en/elasticsearch/reference/2.3/search-aggregations.html
	 */
	@Test
	@Ignore
	public void structuringAggregationsTest() {
		/*
		 * SearchResponse sr = client.prepareSearch() .addAggregation(
		 * AggregationBuilders.terms("by_country").field("country")
		 * .subAggregation(AggregationBuilders.dateHistogram("by_year")
		 * .field("dateOfBirth") .interval((DateHistogramInterval.YEAR)
		 * .subAggregation(AggregationBuilders.avg("avg_children").field(
		 * "children")) ) ) .execute().actionGet();
		 */
	}

	/**
	 * gov api: mutrics aggregation operations
	 * url:https://www.elastic.co/guide/en/elasticsearch/client/java-api/current/_metrics_aggregations.html
	 */
	@Test
	@Ignore
	public void mutricsAggregationTest() {
		MetricsAggregationBuilder<?> aggregation = AggregationBuilders.min("agg").field("height");

		// sr is SearchResponse
		// Min agg = sr.getAggregations().get("agg");
		// double value = agg.getValue();
	}

	/**
	 * gov api:bucket aggregation operations
	 * url:https://www.elastic.co/guide/en/elasticsearch/client/java-api/current/_bucket_aggregations.html
	 */
	@Test
	@Ignore
	public void bucketAggregationTest() {
		AggregationBuilders.global("agg").subAggregation(AggregationBuilders.terms("genders").field("gender"));

		// sr is here your SearchResponse object
		// Global agg = sr.getAggregations().get("agg");
		// agg.getDocCount(); // Doc count
	}

	@Test
	@Ignore
	public void queryBuilderTest() {
		// QueryBuilder qb = XContentFactory.termQuery("content", "amazing");
		//
		// //Index the query = register it in the percolator
		// client.prepareIndex("myIndexName", ".percolator",
		// "myDesignatedQueryName")
		// .setSource(jsonBuilder()
		// .startObject()
		// .field("query", qb) // Register the query
		// .endObject())
		// .setRefresh(true) // Needed when the query shall be available
		// immediately
		// .execute().actionGet();
	}

	@After
	public void closeClient() {
		ComUtils.end();
		ESUtils.close();
		System.out.println("It has been closed!");
	}

}
