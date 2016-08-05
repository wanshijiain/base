package com.czw.mq.rabbitmq.routing;

import java.util.Scanner;

import com.czw.util.RabbitMQUtils;
import com.rabbitmq.client.Channel;

/**
 * 给指定队列放送指定路由的信息
 * 
 * @author ZeviChen
 * @Date 2016-08-05 10:37:09
 */
public class EmitLogsDirect {
	private static final String EXCHANGE_NAME = "direct_logs";

	public static void main(String[] argv) throws java.io.IOException {

		Channel channel = RabbitMQUtils.getChannel();
		
		channel.exchangeDeclare(EXCHANGE_NAME, "direct");
		
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
			String severity = str.substring(0, str.indexOf(" "));
			String message = str.substring(str.indexOf(" ")+1,str.length());
			
			channel.basicPublish(EXCHANGE_NAME, severity, null, message.getBytes());
			System.out.println(" [x] Sent '" + severity + "':'" + message + "'");
			
		}
	}
}
