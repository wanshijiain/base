package com.czw.base.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * Created by Administrator on 2016/9/21.
 */
public class TestServerSocketChannel {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel server = ServerSocketChannel.open();
        server.configureBlocking(false);
        server.bind(new InetSocketAddress("localhost",9527));

        Selector selector = Selector.open();
        server.register(selector, SelectionKey.OP_ACCEPT);

        while (true){
            selector.select();
            Iterator it = selector.selectedKeys().iterator();
            while (it.hasNext()){
                SelectionKey selectionKey = (SelectionKey) it.next();
                it.remove();
                if(selectionKey.isAcceptable()) {
                    ServerSocketChannel ssc = (ServerSocketChannel) selectionKey.channel();
                    SocketChannel channel = ssc.accept();
                    channel.configureBlocking(false);

                    channel.write(ByteBuffer.wrap(new String("已经建立连接...").getBytes()));
                    channel.register(selector, SelectionKey.OP_READ);

                }else if(selectionKey.isReadable()){
                    ByteBuffer cb = ByteBuffer.allocate(2048);
                    SocketChannel sc = (SocketChannel) selectionKey.channel();
                    System.out.println(sc);
                    int flag = sc.read(cb);
                    if(flag !=-1){
                        String s = new String(cb.array());
                        System.out.println("Get Msg : "+cb.get());
                        cb.clear();
                    }
                    sc.write(ByteBuffer.wrap("Server had get your msg,end.".getBytes()));
                }
            }
        }
    }


}
