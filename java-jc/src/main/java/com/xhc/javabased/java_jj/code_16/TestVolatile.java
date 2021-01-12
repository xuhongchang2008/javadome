package com.xhc.javabased.java_jj.code_16;

public class TestVolatile {
    public static void main(String[] args){ //这个线程是用来读取flag的值的
        testA();
    }

    private static void testA()
    {
        ThreadDemo threadDemo = new ThreadDemo();
        Thread thread = new Thread(threadDemo);
        thread.start();
        while (true){
            if (threadDemo.isFlag()){
                System.out.println("主线程读取到的flag = " + threadDemo.isFlag());
                break;
            }
        }
    }

    private static void testB()
    {
        ThreadDemo threadDemo = new ThreadDemo();
        Thread thread = new Thread(threadDemo);
        thread.start();
        while (true){
            synchronized (threadDemo){
                if (threadDemo.isFlag()){
                    System.out.println("主线程读取到的flag = " + threadDemo.isFlag());
                    break;
                }
            }
        }
    }
}
