package com.xhc.springsource.dao;

import org.springframework.stereotype.Repository;

//名字默认是类名首字母小写
@Repository("bookDao0")
public class BookDao {

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }

    public void setStr(String str) {
        this.str = str;
    }

    private String lable = "0";

    public String getStr() {
        return str;
    }

    private String str="abcde";






    @Override
    public String toString() {
        return "BookDao=[" + this.getLable()+"+"+this.getStr()+ "]";
    }




}
