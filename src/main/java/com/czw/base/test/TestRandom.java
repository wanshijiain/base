package com.czw.base.test;

import java.util.Random;

/**
 * @author ZeviChen 2016/10/17 17:22
 */
public class TestRandom {
    public static void main(String[] args){
        Random r = new Random(1);
        Random r1 = new Random(1);

        System.out.println("r:"+r.nextInt(100));
        System.out.println("r:"+r.nextInt(100));
        System.out.println("r:"+r.nextInt(100));
        System.out.println("r:"+r.nextInt(100));
        System.out.println("r:"+r.nextInt(100));
        System.out.println("r1:"+r1.nextInt(100));
        System.out.println("r1:"+r1.nextInt(100));
        System.out.println("r1:"+r1.nextInt(100));
        System.out.println("r1:"+r1.nextInt(100));
        System.out.println("r1:"+r1.nextInt(100));

    }

}
