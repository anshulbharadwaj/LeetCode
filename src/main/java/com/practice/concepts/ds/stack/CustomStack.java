package com.practice.concepts.ds.stack;

public class CustomStack {
    private Node head; // the first node

    // nest class to define linked list node
    private class Node {
        int value;
        Node next;
    }

    public CustomStack() {
        head = null;
    }

    // Remove value from the beginning of the list for demonstrating behaviour of stack
    public int pop() throws Exception {
        if (head == null) {
            throw new Exception(" Linked List is Empty");
        }
        int value = head.value;
        head = head.next;
        return value;
    }

    // Add value to the beginning of the list for demonstrating behaviour of stack
    public void push(int value) {
        Node oldHead = head;
        head = new Node();
        head.value = value;
        head.next = oldHead;
    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.format("%d ", temp.value);
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        CustomStack cs = new CustomStack();
        cs.push(20);
        cs.push(50);
        cs.push(80);
        cs.push(40);
        cs.push(60);
        cs.push(75);

        System.out.println("Element removed from LinkedList: " + cs.pop());
        System.out.println("Element removed from LinkedList: " + cs.pop());
        cs.push(10);

        System.out.println("Element removed from LinkedList: " + cs.pop());
        printList(cs.head);


    }

}