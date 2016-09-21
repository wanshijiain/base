package com.czw.base.nio;

import com.czw.util.DateUtils;
import io.netty.buffer.ByteBuf;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
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
                        Selector selector = Selector.open();
                        SocketChannel sc = SocketChannel.open();
                        sc.connect(new InetSocketAddress("localhost", 9527));
                        sc.configureBlocking(false);
                        sc.register(selector, SelectionKey.OP_CONNECT);
                        while (true) {
                            selector.select();
                            Iterator it = selector.selectedKeys().iterator();
                            SelectionKey key = (SelectionKey) it.next();
                            it.remove();
                            while (it.hasNext()){
                                System.out.println(Thread.currentThread().getName());
                                Thread.sleep(new Random().nextInt(10) * 700);
                                if(key.isConnectable()){
                                    SocketChannel sc2 = (SocketChannel) key.channel();
                                    if(sc2.isConnectionPending())
                                        sc2.finishConnect();
                                    sc2.configureBlocking(false);

                                    //在这里可以给服务端发送信息哦
                                    sc2.write(ByteBuffer.wrap(new String("向服务端发送了一条信息").getBytes()));
                                    //在和服务端连接成功之后，为了可以接收到服务端的信息，需要给通道设置读的权限。
                                    sc2.register(selector, SelectionKey.OP_READ|SelectionKey.OP_WRITE);
                                }else if(key.isReadable()){
                                    SelectionKey sk = (SelectionKey) it.next();
                                    SocketChannel sc1 = (SocketChannel) sk.channel();
                                    ByteBuffer bb = ByteBuffer.allocate(2048);
                                    int flag = sc1.read(bb);
                                    if(flag !=-1){
                                        System.out.println(Thread.currentThread().getName()+","+new String(bb.array()));
                                    }
                                }
                                SocketChannel sc3 = (SocketChannel) key.channel();
                                String s = Thread.currentThread().getName()+","+DateUtils.dtts(new Date());
                                sc3.write(ByteBuffer.wrap(s.getBytes()));
                            }


                        }
                    } catch (IOException|InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }

    }
}
