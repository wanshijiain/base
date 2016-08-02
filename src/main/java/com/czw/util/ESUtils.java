package com.czw.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Set;

import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

import com.czw.config.Constants;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

/**
 * @author Zevi Chan
 * @Date 2016-07-26 17:41:20
 */
public class ESUtils {
	private static Settings settings;
	private static Client client;
	private static GetRequest getRequest;
	private static GetResponse getResponse;
	private static InetSocketTransportAddress inetSocketTransportAddress;
	private static StringBuilder sb = new StringBuilder();
	
	public static void initSettings(){
		settings = Settings.settingsBuilder().put("cluster.name", Constants.ES_CLUSTER_NAME)
				.put("client.transport.sniff", true).build();
	}
	
	public static Client initClient(){
		initSettings();
		try {
			client = TransportClient.builder().settings(settings).build()
					.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"),9300));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return client;
    }

	
	/**
	 * 打印GetResponse结果
	 * @param response
	 */
	public static void printResponse(GetResponse response){
		if(null ==response || !response.isExists())
			System.out.println("\nGetResponse is't exist !");
		else
			System.out.println("\nURL:"+resURL(response)+",结果:"+response.getSourceAsString());
	}
	/**
	 * 打印GetResponse结果
	 * @param response
	 */
	public static void printResponse(UpdateResponse response){
		if(null ==response || !response.isCreated() || !response.getGetResult().isExists())
			System.out.println("\nUpdateResponse or getresult is't exist !");
		else
			System.out.println("\nURL:"+resURL(response)+",结果:"+response.getGetResult().sourceAsString());
	}
	/**
	 * 打印IndexResponse结果
	 * @param response
	 */
	public static void printResponse(IndexResponse response){
		if(null == response)
			System.out.println("\nIndexResponse !");
		else
			System.out.println("\nURL:"+resURL(response)+",结果:"+parseHeaderJson(response.getHeaders()));
	}
	
	public static String resURL(GetResponse response){
		return spliceURL(response.getIndex())
					.append("/")
					.append(response.getType())
					.append("/")
					.append(response.getId()).toString();
	}
	public static String resURL(UpdateResponse response){
		return spliceURL(response.getIndex())
				.append("/")
				.append(response.getType())
				.append("/")
				.append(response.getId()).toString();
	}
	public static String resURL(IndexResponse response){
		return spliceURL(response.getIndex())
				.append("/")
				.append(response.getType())
				.append("/")
				.append(response.getId()).toString();
	}
	public static StringBuilder spliceURL(String str){
		sb.delete(0, sb.length());
		return sb.append(str);
	}
	
	public static String parseHeaderJson(Set<String> header){
		StringBuilder sb = new StringBuilder("header:【 ");
		for(String s : header){
			sb.append(s+",");
		}
		return sb.deleteCharAt(sb.length()-1).append("】").toString();
	}
	
	public static  void close(){
		client.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
