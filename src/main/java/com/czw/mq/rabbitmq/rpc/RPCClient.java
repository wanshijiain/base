package com.czw.mq.rabbitmq.rpc;

import com.czw.util.RabbitMQUtils;
import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.QueueingConsumer;

/**
 * @author ZeviChen
 * @Date 2016-08-05 14:22:12
 */
public class RPCClient {
	private Channel channel;
	private String requestQueueName = "rpc_queue";
	private String replyQueueName;
	private QueueingConsumer consumer;

	public RPCClient() throws Exception {
		channel = RabbitMQUtils.getChannel();

		replyQueueName = channel.queueDeclare().getQueue();
		consumer = new QueueingConsumer(channel);
		channel.basicConsume(replyQueueName, true, consumer);
	}

	public String call(String message) throws Exception {
		String response = null;
		String corrId = java.util.UUID.randomUUID().toString();

		BasicProperties props = new BasicProperties.Builder().correlationId(corrId).replyTo(replyQueueName).build();

		channel.basicPublish("", requestQueueName, props, message.getBytes());

		while (true) {
			QueueingConsumer.Delivery delivery = consumer.nextDelivery();
			if (delivery.getProperties().getCorrelationId().equals(corrId)) {
				response = new String(delivery.getBody());
				break;
			}
		}

		return response;
	}

	public static void main(String[] args) throws Exception {
		RPCClient fibonacciRpc = new RPCClient();

		System.out.println(" [x] Requesting fib(30)");   
		String response = fibonacciRpc.call("30");
		System.out.println(" [.] Got '" + response + "'");

		RabbitMQUtils.close();
	}
}
