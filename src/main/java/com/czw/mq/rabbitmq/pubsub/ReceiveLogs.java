package com.czw.mq.rabbitmq.pubsub;

import java.io.IOException;

import com.czw.util.RabbitMQUtils;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

/**
 * @author ZeviChen
 * @Date 2016-08-05 10:05:54
 */
public class ReceiveLogs {

	private static final String EXCHANGE_NAME = "logs";

	public static void main(String[] argv) throws Exception {
		Channel channel = RabbitMQUtils.getChannel();

		channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
		String queueName = channel.queueDeclare().getQueue();
		channel.queueBind(queueName, EXCHANGE_NAME, "");

		System.out.println(" [*] Rec2 Waiting for messages.");

		Consumer consumer = new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
					byte[] body) throws IOException {
				String message = new String(body, "UTF-8");
				System.out.println(" [x] Received '" + message + "'");
			}
		};
		channel.basicConsume(queueName, true, consumer);
	}

}
