package com.xhc.javabased.java_jj.code_16.JUC_03;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class TestAtomicBooleanDemo {

    //AtomicBoolean，在这个Boolean值的变化的时候不允许在之间插入，保持操作的原子性。方法和举例：compareAndSet(boolean expect, boolean update)。
    // 这个方法主要两个作用         1. 比较AtomicBoolean和expect的值，如果一致，执行方法内的语句。其实就是一个if语句         2. 把AtomicBoolean的值设成update
    // 这连个动作之间不会被打断，任何内部或者外部的语句都不可能在两个动作之间运行

    public static void main(String[] args) {

        AtomicBooleanDemo bar1 = new AtomicBooleanDemo("bar1");
        AtomicBooleanDemo bar2 = new AtomicBooleanDemo("bar2");
        new Thread(bar1).start();
        new Thread(bar2).start();

    }


}


 class AtomicBooleanDemo implements Runnable {

    private static AtomicBoolean exists = new AtomicBoolean(false);


    private String name;

    public AtomicBooleanDemo(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        if (exists.compareAndSet(false, true)) {

            System.out.println(name + " enter");
            try {
                System.out.println(name + " working");
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                // do nothing
            }
            System.out.println(name + " leave");
            exists.set(false);
        } else {
            System.out.println(name + " give up");
        }

    }
}