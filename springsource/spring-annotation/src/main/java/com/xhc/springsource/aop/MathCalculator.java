package com.xhc.springsource.aop;

public class MathCalculator {

    public int div(int i, int j) {

        int k=i / j;

        System.out.println("MathCalculator...div...k="+k);

        return k;
    }
}
