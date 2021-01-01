package com.xhc.javabased.java_jj.code_03.demo05.Collections;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        //按照年龄升序排序
        int result =  o1.getAge()-o2.getAge();
        //如果两个人年龄相同,再使用姓名的第一个字比较
        if(result==0){
            result =  o1.getName().charAt(0)-o2.getName().charAt(0);
        }
        return  result;
    }

}
