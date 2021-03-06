package com.xhc.javabased.java_jj.code_16.JUC_04;

//两个线程调用同一个对象的两个同步方法
//结果分析：
//被synchronized修饰的方法，锁的对象是方法的调用者。因为两个方法的调用者是同一个，所以两个方法用的是同一个锁，先调用方法的先执行。
public class Demo_1 {
    public static void main(String[] args) {
        Number1 number = new Number1();

        new Thread(new Runnable() {
            @Override
            public void run() {
                number.getOne();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                number.getTwo();
            }
        }).start();
    }
}

class Number1 {
    public synchronized void getOne() {
        System.out.println("one");
    }

    public synchronized void getTwo() {
        System.out.println("two");
    }
}