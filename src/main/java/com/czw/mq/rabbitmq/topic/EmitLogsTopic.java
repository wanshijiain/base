package com.czw.mq.rabbitmq.topic;

import java.util.Scanner;

import com.czw.util.RabbitMQUtils;
import com.rabbitmq.client.Channel;

/**
 * 在topic中routingKey的定义方式:
 * [*]代表一个单词,例如:*.orange.*
 * [#]代表零个或者多个单词,例如lazy.#  ,  lazy.red.animal,lazy.black.animal...
 * 
 * @author ZeviChen
 * @Date 2016-08-05 13:25:48
 */
public class EmitLogsTopic {
	private static final String EXCHANGE_NAME = "topic_logs";

	public static void main(String[] args) throws Exception {
		
		Channel channel = RabbitMQUtils.getChannel();
		channel.exchangeDeclare(EXCHANGE_NAME, "topic");

		System.out.println("Exchange:"+EXCHANGE_NAME+"...输入routingKey和message,空格分隔：");
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String str = sc.nextLine();
			if("stop".equals(str)){
				sc.close();
				RabbitMQUtils.close();
				break;
			}
			//info,warning,error,trace,debug
			String routingKey = str.substring(0, str.indexOf(" "));
			String message = str.substring(str.indexOf(" ")+1,str.length());
			
			channel.basicPublish(EXCHANGE_NAME, routingKey, null, message.getBytes());
			System.out.println(" [x] Sent '" + routingKey + "':'" + message + "'");
			
		}

	}
}
