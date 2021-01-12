package com.xhc.javabased.java_jj.code_16;

public class TestReadWriterLock {

    public static void main(String[] args){
        ReadWriterLockDemo rw = new ReadWriterLockDemo();
        new Thread(new Runnable() {//一个线程写
            @Override
            public void run() {
                rw.set((int)Math.random()*101);
                System.out.println("写成功！");
            }
        },"write:").start();
        for (int i = 0;i<100;i++){//100个线程读
            Runnable runnable = () -> rw.get();
            Thread thread = new Thread(runnable);
            thread.start();
        }
    }
}
