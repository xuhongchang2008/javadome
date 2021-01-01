package com.xhc.javabased.java_jj.code_01.demo01.Object;

import java.util.*;

public class Demo02Equals {

    public static void main(String[] args) {
     b();
    }

    public static void a()
    {
           /*
            Person类默认继承了Object类,所以可以使用Object类的equals方法
            boolean equals(Object obj) 指示其他某个对象是否与此对象“相等”。
            equals方法源码:
                public boolean equals(Object obj) {
                    return (this == obj);
                }
                参数:
                    Object obj:可以传递任意的对象
                    == 比较运算符,返回的是一个布尔值 true false
                    基本数据类型:比较的是值
                    引用数据类型:比价的是两个对象的地址值
               this是谁?那个对象调用的方法,方法中的this就是那个对象;p1调用的equals方法所以this就是p1
               obj是谁?传递过来的参数p2
               this==obj -->p1==p2
         */
        Person p1 = new Person("迪丽热巴",18);
        //Person p2 = new Person("古力娜扎",19);
        Person p2 = new Person("迪丽热巴",18);
        System.out.println("p1:"+p1);//p1:com.itheima.demo01.Object.Person@58ceff1
        System.out.println("p2:"+p2);//p2:com.itheima.demo01.Object.Person@7c30a502

        System.out.println("p1hashCode="+p1.hashCode());
        System.out.println("p2hashCode="+p2.hashCode());
        if(p1==p2)
        {
            System.out.println("p1==p2");
        }

        //p1=p2;//把p2的地址值赋值给p1
        ArrayList<String> list = new ArrayList<>();

        boolean b = p1.equals(p2);
        System.out.println(b);
    }

    public static  void b()
    {
        LinkedList<Person> list = new LinkedList<Person>();
        Set<Person> set = new HashSet<Person>();
        Person p1  = new Person("张三",3);
        Person p2  = new Person("张三",3);

        System.out.println("======================");
        System.out.println("p1=:"+p1);
        System.out.println("p2=:"+p2);
        System.out.println("p1.hashCode="+p1.hashCode());
        System.out.println("p2.hashCode="+p2.hashCode());


        System.out.println("======================");
        System.out.println("p1 == p2 : "+(p1 == p2));
        System.out.println("p1.equals(p2) : "+p1.equals(p2));
        System.out.println("======================");

        list.add(p1);
        list.add(p2);
        System.out.println("list size:"+ list.size());
        System.out.println("list1 =:"+ list.get(0).hashCode());
        System.out.println("list2 =:"+ list.get(1).hashCode());
        System.out.println("======================");

        set.add(p1);
        set.add(p2);
        System.out.println("set size:"+ set.size());
        Iterator it = set.iterator();
        int i=1;
        while(it.hasNext()){
            System.out.println("第"+i+"个"+it.next().hashCode());
            i++;
        }

        System.out.println("======================");

        System.out.println("重打p1:"+p1);//p1:com.itheima.demo01.Object.Person@58ceff1
        System.out.println("重打p2:"+p2);//p2:com.itheima.demo01.Object.Person@7c30a502

        System.out.println("重打p1.hashCode="+p1.hashCode());
        System.out.println("重打p2.hashCode="+p2.hashCode());

        System.out.println("======================");
//        p1.setAge(34);
//        //System.out.println("remove p1 : "+set.remove(p1));
//        System.out.println("set size:"+ set.size());
//
//        System.out.println("p1.hashCode="+p1.hashCode());
//        System.out.println("p2.hashCode="+p2.hashCode());
//
//        System.out.println("==================================");
//         it = set.iterator();
//        i=1;
//        while(it.hasNext()){
//            System.out.println("重打第"+i+"个"+it.next().hashCode());
//            i++;
//        }
    }

}
