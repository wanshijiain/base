/**
 * 
 */
package com.czw.server.jetty.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

/**
 * @author ZeviChen
 * @date 2016-09-15 17:44:30
 */
public class HelloServlet extends HttpServlet {

	private static final long serialVersionUID = -1268198890833599177L;

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("HelloServlet ...");
		super.service(req, res);
	}
	
	
	
}
