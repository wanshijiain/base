package com.czw.mq.rabbitmq.workqueue;

import java.io.IOException;
import java.util.Scanner;

import com.czw.util.ComUtils;
import com.czw.util.RabbitMQUtils;
import com.rabbitmq.client.Channel;

/**
 * @author ZeviChen
 * @Date 2016-08-04 15:55:55
 */
public class NewTask {

	private final static String QUEUE_NAME = "hello";
	
	
	/**
	 * Fair dispatch 公平分发
	 * channel.BasicQos(0, 1, false);
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		ComUtils.start();
		Channel channel = RabbitMQUtils.getChannel();
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			if (sc.nextLine().equals(""))
				break;
			String message = getMessage(sc.nextLine());
			channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
			// channel.basicPublish("", QUEUE_NAME,
			// MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
			System.out.println(" [x] Sent '" + message + "'");
		}
		RabbitMQUtils.close();
		sc.close();
	}

	private static String getMessage(String strings) {
		if (strings.length() < 1)
			return "Hello World!";
		return joinStrings(strings, " ");
	}

	private static String joinStrings(String strings, String delimiter) {
		int length = strings.length();
		if (length == 0)
			return "";
		StringBuilder words = new StringBuilder(strings);
		words.append(delimiter).append(strings);
		return words.toString();
	}
}
