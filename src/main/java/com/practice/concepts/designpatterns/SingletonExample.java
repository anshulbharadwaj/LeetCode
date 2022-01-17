package com.practice.concepts.designpatterns;

public class SingletonExample {

    private SingletonExample() {

    }
    public static SingletonExample instance = new SingletonExample();

    public static SingletonExample getInstance(){
        return instance;
    }
}
