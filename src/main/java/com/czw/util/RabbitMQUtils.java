package com.czw.util;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author ZeviChen
 * @Date 2016-08-04 11:28:37
 */
public class RabbitMQUtils {
	private static ConnectionFactory factory = new ConnectionFactory();;
	private static Connection connection;
	private static Channel channel;
	private final static String QUEUE_NAME = "hello";
	/**
	 * 当sonsumer断开或者RabbitMQ关闭消息队列中的信息会丢失，需要定义durable来持久化信息.但是已经定义的
	 * 消息队列这个参数在RabbitMQ已经生成，如果【重新定义会报错】，所以需要重新定义个消息队列,持久化的消息应该
	 * 在consumer和producer中实现
	 */
	private static boolean durable = false;
	static{
	    factory.setHost("192.168.229.128");
	    factory.setPort(5672);
	    factory.setUsername("zevi");
	    factory.setPassword("123456");
		try {
			connection = factory.newConnection();
			channel = connection.createChannel();
			channel.queueDeclare(QUEUE_NAME, durable, false, false, null);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}
	
	public static Channel getChannel(){
		return channel;
	}
	
	public static void close(){
		ComUtils.end();
		try {
			channel.close();
			connection.close();
		} catch (IOException | TimeoutException e) {
			e.printStackTrace();
		}
		
	}
}
