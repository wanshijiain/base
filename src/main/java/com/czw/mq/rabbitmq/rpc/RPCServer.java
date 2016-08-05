package com.czw.mq.rabbitmq.rpc;

import com.czw.util.RabbitMQUtils;
import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.QueueingConsumer;

/**
 * deliveryMode : 同durable字段,持久化信息，即使服务器关闭了 contentType :
 * 传输的数据类型mime-type,例如：json数据的mime类型是 application/json replyTo ： 指定反馈队列queue
 * correlationId:
 * 给每个request创建个callback队列显然是效率低下的，可以指定一个单独的队列来处理response，关联request
 * 给每个request设置个唯一的值，响应中就可以收到这个值，当查看这个值不属于这个请求和响应关联组就会丢弃.丢弃是因为服务器 发送request后go
 * die了，重启后又重启发送一遍会出现两个的情况.
 * 
 * @author ZeviChen
 * @Date 2016-08-05 14:02:01
 */
public class RPCServer {
	private static final String RPC_QUEUE_NAME = "rpc_queue";

	public static void main(String[] args) throws Exception {
		Channel channel = RabbitMQUtils.getChannel();

		channel.queueDeclare(RPC_QUEUE_NAME, false, false, false, null);
		channel.basicQos(1);

		QueueingConsumer consumer = new QueueingConsumer(channel);
		channel.basicConsume(RPC_QUEUE_NAME, false, consumer);

		System.out.println(" [x] Awaiting RPC requests");

		while (true) {
			QueueingConsumer.Delivery delivery = consumer.nextDelivery();

			BasicProperties props = delivery.getProperties();
			BasicProperties replyProps = new BasicProperties.Builder().correlationId(props.getCorrelationId()).build();

			String message = new String(delivery.getBody());
			int n = Integer.parseInt(message);

			System.out.println(" [.] fib(" + message + ")");
			String response = "" + fib(n);

			channel.basicPublish("", props.getReplyTo(), replyProps, response.getBytes());

			channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
		}
	}

	private static int fib(int n) throws Exception {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		return fib(n - 1) + fib(n - 2);
	}
}
