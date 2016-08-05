package com.czw.mq.rabbitmq.workqueue;

import java.io.IOException;
import java.util.Scanner;

import com.czw.util.RabbitMQUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.MessageProperties;

/**
 * @author ZeviChen
 * @Date 2016-08-04 15:59:05
 */
public class Worker {
	/**
	 * 当sonsumer断开或者RabbitMQ关闭消息队列中的信息会丢失，需要定义durable来持久化信息.但是已经定义的
	 * 消息队列这个参数在RabbitMQ已经生成，如果【重新定义会报错】，所以需要重新定义个消息队列,持久化的消息应该
	 * 在consumer和producer中实现
	 */
	private static final String TASK_QUEUE_NAME = "task_queue";

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Channel channel = RabbitMQUtils.getChannel();

		channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);

		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String message = sc.nextLine();
			channel.basicPublish("", TASK_QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
			System.out.println(" [x] Sent '" + message + "'");
		}

		RabbitMQUtils.close();
		sc.close();
	}

}
