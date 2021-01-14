package com.xhc.javabased.java_jj.code_16.JUC_04;

//将两个方法均设置为static方法，并且让两个线程用同一个对象调用两个方法
//结果说明：
//被synchronized和static修饰的方法，锁的对象是类的class对象。因为两个同步方法都被static修饰了，即便用了两个不同的对象调用方法，两个方法用的还是同一个锁，后调用的方法需要等待先调用的方法。

public class Demo_8 {
    public static void main(String[] args) {
        Number8 numberOne = new Number8();
        Number8 numberTwo = new Number8();

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

class Number8 {
    public static synchronized void getOne() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("one");
    }

    public static synchronized void getTwo() {
        System.out.println("two");
    }
}

//总结
//一个类里面如果有多个synchronized方法，在使用同一个对象调用的前提下，某一个时刻内，只要一个线程去调用其中的一个synchronized方法了，其他的线程都只能等待，换句话说，某一时刻内，只能有唯一一个线程去访问这些synchronized方法。
//
//锁的是当前对象this，被锁定后，其他线程都不能进入到当前对象的其他的synchronized方法。
//
//加个普通方法后发现和同步锁无关。
//
//换成静态同步方法后，情况又变化。
//
//所有的非静态同步方法用的都是同一把锁：实例对象本身。
//
//也就是说如果一个对象的非静态同步方法获取锁后，该对象的其他非静态同步方法必须等待获取锁的方法释放锁后才能获取锁，可是其他对象的非静态同步方法因为跟该对象的非静态同步方法用的是不同的锁，所以毋须等待该对象的非静态同步方法释放锁就可以获取他们自己的锁。
//
//所有的静态同步方法用的也是同一把锁：类对象本身。
//
//这两把锁是两个不同的对象，所以静态同步方法与非静态同步方法之间不会有竞争条件。但是一旦一个静态同步方法获取锁后，其他的静态同步方法都必须等待该方法释放锁后才能获取锁，而不管是同一个对象的静态同步方法，还是其他对象的静态同步方法，只要它们属于同一个类的对象，那么就需要等待当前正在执行的静态同步方法释放锁。