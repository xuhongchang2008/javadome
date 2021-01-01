package com.xhc.springsource.beanperiod;

import org.springframework.stereotype.Component;


public class PersonLink {

    public PersonLink() {

        System.out.println("=========================================");
        System.out.println("---->PersonLink constructor...");
        System.out.println("=========================================");
    }

    public String getLikename() {
        return likename;
    }

    public void setLikename(String likename) {
        System.out.println("【注入属性】注入属性likename="+likename);
        this.likename = likename;
    }

    private String likename;

    @Override
    public String toString() {
        return "PersonLink{" +
                "likename='" + likename + '\'' +
                '}';
    }
}
