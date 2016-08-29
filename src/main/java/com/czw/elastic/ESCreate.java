package com.czw.elastic;

import static com.czw.util.ESUtils.initClient;

import java.io.IOException;
import java.util.Date;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.czw.util.DateUtils;

/**
 * @author ZeviChen
 * @Date 2016-08-29 14:35:50
 */
public class ESCreate {
	private Client client = initClient();
	protected static Logger log = LoggerFactory.getLogger(ESCreate.class);

	String user1 = "{\"name\":\"zhangsan\",\"age\":20,\"regTime\":\"" + DateUtils.dtts(new Date())
			+ "\",\"message\":\"举例子最常见的名字之一\"}";

	@Test
	public void createIndex1() throws IOException {
		XContentBuilder appendField = XContentFactory.jsonBuilder().startObject().field("user", "lisi").field("age", 30)
				.field("regTime", DateUtils.dtts(new Date())).field("message", "trying out Elasticsearch")
				.endObject();

		IndexResponse response = client.prepareIndex("people", "user", "1").setSource(user1).get();

		log.info("head info {},shard info{}", response.getHeaders().toArray(), response.getShardInfo().getTotal());

	}

}
