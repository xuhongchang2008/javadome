package com.xhc.javabased.java_jj.code_16;

import java.util.concurrent.Callable;

//现在Callable接口和实现Runable接口的区别就是，Callable带泛型，其call方法有返回值。使用的时候，需要用FutureTask来接收返回值。而且它也要等到线程执行完调用get方法才会执行，也可以用于闭锁操作。

public class CallableDemo implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0;i<=100;i++){
            sum += i;
        }
        return sum;
    }
}
