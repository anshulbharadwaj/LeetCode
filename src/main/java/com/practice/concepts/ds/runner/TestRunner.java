package com.practice.concepts.ds.runner;

import com.practice.concepts.ds.MyLinkedList;

public class TestRunner {
    public static void main(String[] args) {
        //System.out.println("This is a test com.practice.concepts.string");
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(5);
        int index = myLinkedList.get(2);
        System.out.println(index);
    }
}
