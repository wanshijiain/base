package com.czw.mq.rabbitmq.hello;

import java.io.IOException;

import org.junit.Test;

import com.czw.util.RabbitMQUtils;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

/**
 * 
 * @author ZeviChen
 * @Date 2016-08-04 11:26:16
 */
public class ReceiveMQ {
	private final static String QUEUE_NAME = "hello";

	// @Test
	public static void main(String[] args) throws IOException {
		Channel ch = RabbitMQUtils.getChannel();
		ch.queueDeclare(QUEUE_NAME, false, false, false, null);
		System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

		// 需要先启动receive,可能send不存在的情况，需要等待
		Consumer consumer = new DefaultConsumer(ch) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
					byte[] body) throws IOException {
				String message = new String(body, "UTF-8");
				System.out.println(" [x] Received '" + message + "'");
			}
		};
		ch.basicConsume(QUEUE_NAME, true, consumer);
	}

}
