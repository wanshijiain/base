package com.czw.mq.rabbitmq.pubsub;

import java.util.Scanner;
import java.util.concurrent.TimeoutException;

import com.czw.util.RabbitMQUtils;
import com.rabbitmq.client.Channel;

/**
 * 这种模式的结构是：发布者发布消息到exchange中,exchange处理消息并进行预先配置过的相关处理.然后发布给各种队列
 * 然后指定队列中的接收者就接受到消息.
 * 
 * channel.basicPublish("", "hello", null, message.getBytes());
 * 		channel发送的消息交由exchange处理，后续会进入哪个queue它不知道.默认的exchange是""
 * 
 * 		通过<code>sudo rabbitmqctl list_exchanges</code>来查看rabbitmq中的exchange
 * 
 * channel.exchangeDeclare("logs", "fanout");
 * 		定义一个exchange,类型有： direct, topic, headers and fanout
 * 			fanout:广播message到queue
 * 
 * 释放连接的消费者队列应该被自动删除,创建一个自动删除的非持久的单个队列方式：
 * 		String queueName = channel.queueDeclare().getQueue();
 * 		队列名会类似这种：amq.gen-JzTY20BRgKO-HjmUJj0wLg
 * 
 * @author ZeviChen
 * @Date 2016-08-05 09:36:48
 */
public class EmitLogs {

	 private static final String EXCHANGE_NAME = "logs";

     public static void main(String[] arg)
                  throws java.io.IOException, TimeoutException {
    	
        Channel channel = RabbitMQUtils.getChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");

        //String message = getMessage(args);
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
        	String message = sc.nextLine();
        	if("a".equals(message)) break;
        	channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
        	System.out.println(" [x] Sent '" + message + "'");
        }

        RabbitMQUtils.close();
     }

}
