package com.czw.mq.rabbitmq.routing;

import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

import com.czw.util.RabbitMQUtils;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

/**
 * 创建queue1-error 创建queue2-error,info,warning
 * 
 * @author ZeviChen
 * @Date 2016-08-05 10:38:52
 */
public class ReceiveLogsDirect {
	private static final String EXCHANGE_NAME = "direct_logs";
	private static final String QUEUE_NAME = "queue2";

	public static void main(String[] argv) throws Exception {
		Channel channel = RabbitMQUtils.getChannel();

		channel.exchangeDeclare(EXCHANGE_NAME, "direct");
		channel.queueDeclare(QUEUE_NAME, false, false, true, null);
		// channel.queueDeclare().getQueue();
		System.out.println("队列：" + QUEUE_NAME + "...输入routingKey【空格分隔】:");
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String s = sc.nextLine();
			if ("stop".equals(s))
				break;
			String[] sArr = StringUtils.split(s, " ");
			for (String routing : sArr)
				channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, routing);
		}

		sc.close();
		System.out.println(" [*] " + QUEUE_NAME + " Waiting for messages.");

		Consumer consumer = new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
					byte[] body) throws IOException {
				String message = new String(body, "UTF-8");
				System.out.println(" [x] Received '" + envelope.getRoutingKey() + "':'" + message + "'");
			}
		};
		channel.basicConsume(QUEUE_NAME, true, consumer);
	}
}
