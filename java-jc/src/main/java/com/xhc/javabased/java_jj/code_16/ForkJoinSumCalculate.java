package com.xhc.javabased.java_jj.code_16;

import java.util.concurrent.RecursiveTask;

public class ForkJoinSumCalculate extends RecursiveTask<Long> {

    private static final long serialVersionUID = 24340990L;

    private long start;
    private long end;

    private static final long THURSHOLD = 10000L;  // 拆分临界值

    // 有参构造器
    public ForkJoinSumCalculate(long start, long end){
        this.start = start;
        this.end = end;
    }

    public Long compute(){
        long length = end - start;

        if(length <= THURSHOLD){
            long  sum = 0L;

            for(long i = start; i<=end; i++){
                sum += i;
            }
            return sum;
        }else{
            long middle = (start + end ) / 2;
            ForkJoinSumCalculate left = new ForkJoinSumCalculate(start, middle);
            left.fork(); // 进行拆分,同时压入线程队列

            ForkJoinSumCalculate right = new ForkJoinSumCalculate(middle + 1, end);
            right.fork(); // 进行拆分,同时压入线程队列

            return left.join() + right.join();
        }
    }

}
