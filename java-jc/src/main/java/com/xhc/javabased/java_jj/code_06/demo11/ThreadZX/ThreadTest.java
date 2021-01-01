package com.xhc.javabased.java_jj.code_06.demo11.ThreadZX;

public class ThreadTest {

    public static void main(String[] args)
    {
        //threadJoin();
        threadYield();
    }

    //join方法
    private static  void  threadJoin()
    {
        System.out.println(Thread.currentThread().getName() + "主线程运行开始!");
        MyThread mTh1 = new MyThread("A");
        MyThread mTh2 = new MyThread("B");
        mTh1.start();
        mTh2.start();
        try {
            mTh1.join(); //join是Thread类的一个方法，启动线程后直接调用，即join()的作用是：“等待该线程终止”，
            // 这里需要理解的就是该线程是指的主线程等待子线程的终止。也就是在子线程调用了join()方法后面的代码，只有等到子线程结束了才能执行。
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            mTh2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "主线程运行结束!");
    }


    private static  void  threadYield()
    {
        MyThread yt1 = new MyThread("张三");
        MyThread yt2 = new MyThread("李四");
        yt1.start();
        yt2.start();
    }


}