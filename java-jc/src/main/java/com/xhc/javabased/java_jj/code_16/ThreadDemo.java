package com.xhc.javabased.java_jj.code_16;

import lombok.Data;

//volatile
@Data
public class ThreadDemo implements Runnable{ //这个线程是用来修改flag的值的
    public  volatile  boolean flag = false;
    //public    boolean flag = false;
    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("ThreadDemo线程修改后的flag = " + isFlag());
    }
}
