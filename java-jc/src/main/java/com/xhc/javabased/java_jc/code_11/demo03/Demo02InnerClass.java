package com.xhc.javabased.java_jc.code_11.demo03;

import com.xhc.javabased.java_jc.code_11.demo03.Outer.Inner;

public class Demo02InnerClass {




    public static void main(String[] args) {
        // 外部类名称.内部类名称 对象名 = new 外部类名称().new 内部类名称();
        Inner obj = new Outer().new Inner();
        obj.methodInner();
    }

}
