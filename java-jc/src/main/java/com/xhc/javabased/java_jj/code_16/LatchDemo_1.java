package com.xhc.javabased.java_jj.code_16;

import java.util.concurrent.CountDownLatch;

//ContDownLatch是一个同步辅助类，在完成某些运算时，只有其他所有线程的运算全部完成，当前运算才继续执行，这就叫闭锁
//主要就是用latch.countDown()和latch.await()实现闭锁
public class LatchDemo_1 implements Runnable {
    private CountDownLatch latch;
    public LatchDemo_1(CountDownLatch latch) {
        this.latch = latch;
    }
    @Override
    public void run() {
        synchronized (this) {
            try {
                for (int i = 0; i < 50000; i++) {
                    if (i % 2 == 0) {//50000以内的偶数
                        System.out.println(i);
                    }
                }
            } finally {
                latch.countDown();//每执行完一个就递减一个
            }
        }
    }
}
