package com.czw.spring.base;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;

/**
 * @author ZeviChen
 * @Date 2016-09-07 17:19:10
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan
@ImportResource("classpath:spring-test/spring-ioc.xml")
public class Config {

}
