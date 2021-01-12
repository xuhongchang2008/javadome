package com.xhc.javabased.java_jj.code_16;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class TestForkJoinPool {
    public static void main(String[] args){
        ForkJoinPool pool = new ForkJoinPool();

        ForkJoinTask<Long> task = new ForkJoinSumCalculate(0L, 100000000L);

        Long sum = pool.invoke(task);

        System.out.println(sum);
    }
}
