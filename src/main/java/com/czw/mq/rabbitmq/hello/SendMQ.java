package com.czw.mq.rabbitmq.hello;

import java.io.IOException;

import org.junit.Test;

import com.czw.util.RabbitMQUtils;
import com.rabbitmq.client.Channel;

/**
 * @author ZeviChen
 * @Date 2016-08-04 11:26:02
 */
public class SendMQ {
	private final static String QUEUE_NAME = "hello";

	// @Test
	public static void main(String[] args) throws IOException {
		Channel ch = RabbitMQUtils.getChannel();
		ch.queueDeclare(QUEUE_NAME, false, false, false, null);
		String message = "Hello World!";
		ch.basicPublish("", QUEUE_NAME, null, message.getBytes());
		System.out.println(" [x] Sent '" + message + "'");
	}

}
