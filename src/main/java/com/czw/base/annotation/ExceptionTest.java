package com.czw.base.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ZeviChen 2016/10/14 9:28
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ExceptionTest {
    //@ExceptionTest(ArithmeticException.class)
    Class<? extends Exception> value();

    //@ExceptionTest({IndexOutOfBoundsException.class,NullPointerException.class})
//	Class<? extends Exception>[] value();


}
