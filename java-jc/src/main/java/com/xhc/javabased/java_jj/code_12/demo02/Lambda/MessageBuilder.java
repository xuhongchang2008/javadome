package com.xhc.javabased.java_jj.code_12.demo02.Lambda;

@FunctionalInterface
public interface MessageBuilder {
    //定义一个拼接消息的抽象方法,返回被拼接的消息
    public abstract String builderMessage();
}
