package com.xhc.javabased.java_jj.code_02.demo03.Generic;

import java.util.ArrayList;
import java.util.Collection;

/*
    泛型的上限限定: ? extends E  代表使用的泛型只能是E类型的子类/本身
    泛型的下限限定: ? super E    代表使用的泛型只能是E类型的父类/本身
 */
public class Demo06Generic {


    public static void main(String[] args) {

        Collection<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(2);


        Collection<String> list2 = new ArrayList<String>();
        list2.add("a");
        list2.add("b");


        Collection<Number> list3 = new ArrayList<Number>();
        list3.add(1.0);
        list3.add(2.0);

        Collection<Object> list4 = new ArrayList<Object>();
        list4.add(list1);
        list4.add(list2);
        list4.add(list3);

        getElement1(list1);
        //getElement1(list2);//报错
        getElement1(list3);
        //getElement1(list4);//报错

        //getElement2(list1);//报错
        //getElement2(list2);//报错
        getElement2(list3);
        getElement2(list4);

        /*
            类与类之间的继承关系
            Integer extends Number extends Object
            String extends Object
         */

    }
    // 泛型的上限：此时的泛型?，必须是Number类型或者Number类型的子类
    public static void getElement1(Collection<? extends Number> coll){
        System.out.println(coll.toString());
    }
    // 泛型的下限：此时的泛型?，必须是Number类型或者Number类型的父类
    public static void getElement2(Collection<? super Number> coll){
        System.out.println(coll.toString());
    }
}
