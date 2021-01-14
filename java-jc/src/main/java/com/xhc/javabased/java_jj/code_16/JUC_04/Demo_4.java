package com.xhc.javabased.java_jj.code_16.JUC_04;

//两个线程调用两个对象的同步方法，其中一个方法有Thread.sleep()
//结果说明：
//被synchronized修饰的方法，锁的对象是方法的调用者。因为用了两个对象调用各自的方法，所以两个方法的调用者不是同一个，所以两个方法用的不是同一个锁，后调用的方法不需要等待先调用的方法。

public class Demo_4 {
    public static void main(String[] args) {
        Number4 numberOne = new Number4();
        Number4 numberTwo = new Number4();

        new Thread(new Runnable() {
            @Override
            public void run() {
                numberOne.getOne();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                numberTwo.getTwo();
            }
        }).start();
    }
}

class Number4 {
    public synchronized void getOne() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("one");
    }

    public synchronized void getTwo() {
        System.out.println("two");
    }
}
