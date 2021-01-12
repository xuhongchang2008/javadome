package com.xhc.javabased.java_jj.code_16;

public class TestConcurrent {
    public static void main(String[] args){
        ThreadDemo2 threadDemo2 = new ThreadDemo2();
        for (int i=0;i<10;i++){
            new Thread(threadDemo2).start();
        }
    }
}
