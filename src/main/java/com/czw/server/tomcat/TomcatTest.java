package com.czw.server.tomcat;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.junit.Test;

/**
 * 
 * @author ZeviChen
 * @Date 2016-09-14 17:15:32
 */
public class TomcatTest {
	
	@Test
	public void test() throws LifecycleException{
		Tomcat tomcat = new Tomcat();
		
		tomcat.start();
		tomcat.stop();
	}
	
	
	
	
}
