/**
 *
 */
package com.czw.server.jetty;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;

import com.czw.server.jetty.action.HelloHandler;

/**
 * @author ZeviChen
 * @date 2016-09-15 17:30:24
 */
public class ExampleServer {

    /**
     * 嵌入式Jetty,通过Java代码配置Jetty
     * 也可通过在webapps中的*.xml配置
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Server server = new Server(80);

        // Add a single handler on context "/hello"
        ContextHandler context = new ContextHandler();
        context.setContextPath("/hello");
        //context set war.
        context.setHandler(new HelloHandler());
        // Can be accessed using http://localhost:80/hello
        server.setHandler(context);
        // Start the server
        server.start();
        server.join();
    }

}
