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
        server.bind(new InetSocketAddress("localhost", 9527));
        int ops = server.validOps();
        Selector selector = Selector.open();
        server.register(selector, ops, null);

        while (true) {
            System.out.println("Waiting for select ...");
            selector.select();
            Iterator<SelectionKey> it = selector.selectedKeys().iterator();
            while (it.hasNext()) {
                SelectionKey selectionKey = it.next();

                if (selectionKey.isAcceptable()) {
                    SocketChannel client = server.accept();
                    client.configureBlocking(false);

                    client.write(ByteBuffer.wrap(new String("已经建立连接...").getBytes()));
                    client.register(selector, SelectionKey.OP_READ);
                    System.out.println("Accepted new connection from client: " + client);

                } else if (selectionKey.isReadable()) {
                    SocketChannel client = (SocketChannel) selectionKey.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(2048);
                    client.read(buffer);
                    String output = new String(buffer.array()).trim();
                    System.out.println("Message read from client: " + output);
                    if (output.equals("88")) {
                        client.close();
                        System.out.println("Client messages are complete; close.");
                    }

                }
                it.remove();
            }
        }
    }


}
