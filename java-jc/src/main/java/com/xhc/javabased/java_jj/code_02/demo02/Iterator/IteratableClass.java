package com.xhc.javabased.java_jj.code_02.demo02.Iterator;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class IteratableClass implements Iterable<String> {


    public void setWords(String[] words) {
        this.words = words;
    }


    private  String[] words;


    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index = 0;

            public boolean hasNext() {
                return index < words.length;
            }

            public String next() {
                return words[index++];
            }

            public void remove() {

            }
        };
    }
}
