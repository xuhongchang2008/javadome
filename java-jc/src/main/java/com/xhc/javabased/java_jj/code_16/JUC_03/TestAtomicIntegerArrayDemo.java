package com.xhc.javabased.java_jj.code_16.JUC_03;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicIntegerArray;

//数组value通过构造方法传递进去，然后AtomicIntegerArray会将当前数组复制一份，所以当AtomicIntegerArray对内部的数组元素进行修改时，不会影响传入的数组

public class TestAtomicIntegerArrayDemo {

    private static int threadCount = 1;
    private static CountDownLatch countDown = new CountDownLatch(threadCount);
    static int[] values = new int[10];
    static AtomicIntegerArray ai = new AtomicIntegerArray(values);

    private static class Counter implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 10; j++) {//所有元素+1
                    ai.getAndIncrement(j);
                }
            }
            countDown.countDown();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread(new Counter());
        }
        for (int i = 0; i < threadCount; i++) {
            threads[i].start();
        }
        countDown.await();
        for (int i = 0; i < 10; i++) {
            System.out.println(ai.get(i) + " ");
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.println(values[i] + " ");
        }
    }
}
