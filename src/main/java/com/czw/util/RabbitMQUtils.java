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
	
	static{
	    factory.setHost("192.168.229.128");
	    factory.setPort(5672);
	    factory.setUsername("zevi");
	    factory.setPassword("123456");
		try {
			connection = factory.newConnection();
			channel = connection.createChannel();
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
