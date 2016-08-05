package com.czw.mq.rabbitmq.workqueue;

import java.io.IOException;

import com.czw.util.ComUtils;
import com.czw.util.RabbitMQUtils;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

/**
 * @author ZeviChen
 * @Date 2016-08-04 15:55:55
 */
public class NewTask {

	private static final String TASK_QUEUE_NAME = "task_queue";
	private static boolean durable = false;

	/**
	 * Fair dispatch 公平分发 channel.BasicQos(0, 1, false);
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		ComUtils.start();
		Channel channel = RabbitMQUtils.getChannel();
		channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);
		System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

		channel.basicQos(1);

		final Consumer consumer = new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
					byte[] body) throws IOException {
				String message = new String(body, "UTF-8");

				System.out.println(" [x] Received '" + message + "'");
				try {
					doWork(message);
				} finally {
					System.out.println(" [x] Done");
					channel.basicAck(envelope.getDeliveryTag(), false);
				}
			}
		};
		channel.basicConsume(TASK_QUEUE_NAME, false, consumer);
	}

	private static void doWork(String task) {
		for (char ch : task.toCharArray()) {
			if (ch == '.') {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException _ignored) {
					Thread.currentThread().interrupt();
				}
			}
		}
	}
}
