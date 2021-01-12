package com.xhc.javabased.java_jj.code_16;

import java.util.concurrent.atomic.AtomicInteger;

//原子性
public class AtomicDemo implements Runnable{
//    private int i = 0;
//    public int getI(){
//        return i++;
//    }

    AtomicInteger i = new AtomicInteger();
    public int getI(){
        return i.getAndIncrement();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getI());
    }
}
