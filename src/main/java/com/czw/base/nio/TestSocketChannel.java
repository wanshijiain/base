package com.czw.base.nio;

import com.czw.util.DateUtils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Random;

/**
 * Created by Administrator on 2016/9/21.
 */
public class TestSocketChannel {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        SocketChannel client = SocketChannel.open(new InetSocketAddress("localhost", 9527));
                        System.out.println("Client sending messages to server...");
                        while (true){
                            Thread.sleep(new Random().nextInt(10)*1000);
                            String msg = Thread.currentThread().getName()+" , "+ DateUtils.dtts(new Date())+" send ...";
                            client.write(ByteBuffer.wrap(msg.getBytes()));
                        }
                    } catch (IOException|InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }

    }
}
