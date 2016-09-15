/**
 * 
 */
package com.czw.server.jetty.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.DefaultHandler;

/**
 * @author ZeviChen
 * @date 2016-09-15 18:20:03
 */
public class HelloHandler extends DefaultHandler {

	@Override
	public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("hellohandler ...");
		super.handle(target, baseRequest, request, response);
	}

}
