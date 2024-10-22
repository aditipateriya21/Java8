package org.example.functionalInterfaces;

import org.example.Main;

import java.util.function.BiConsumer;

public class BiConsumerExample {
    public static void main(String[] args) {
        BiConsumer<String,String> biConsumer = (a,b)-> System.out.println("a"+a+""+"b"+b);
        biConsumer.accept("hello","world");
    }
}
