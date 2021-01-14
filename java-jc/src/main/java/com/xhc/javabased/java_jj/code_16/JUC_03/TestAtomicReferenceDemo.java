package com.xhc.javabased.java_jj.code_16.JUC_03;

import java.util.concurrent.atomic.AtomicReference;

//新建AtomicReference对象ar时，将它初始化为p1。
//紧接着，通过CAS函数对它进行设置。如果ar的值为p1的话，则将其设置为p2。
//最后，获取ar对应的对象，并打印结果。p3.equals(p1)的结果为false

public class TestAtomicReferenceDemo {

    public static void main(String[] args) {

        // 创建两个Person对象，它们的id分别是101和102。
        Person p1 = new Person(101);
        Person p2 = new Person(102);
        // 新建AtomicReference对象，初始化它的值为p1对象
        AtomicReference ar = new AtomicReference(p1);
        // 通过CAS设置ar。如果ar的值为p1的话，则将其设置为p2。
        ar.compareAndSet(p1, p2);

        Person p3 = (Person) ar.get();
        System.out.println("p3 is " + p3);
        System.out.println("p3.equals(p1)=" + p3.equals(p1));
    }
}

class Person {
    volatile long id;

    public Person(long id) {
        this.id = id;
    }

    public String toString() {
        return "id:" + id;
    }

}
