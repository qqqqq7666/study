package com.example;

public class Singleton {
    private static Singleton singleton = new Singleton();
    public int num;
    private Singleton(){}

    public static Singleton getInstance() {
        return singleton;
    }

    public void plus(){
        num += 10;
    }
}
