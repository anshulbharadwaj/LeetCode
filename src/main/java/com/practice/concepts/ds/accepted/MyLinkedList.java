package com.practice.concepts.ds.accepted;

class MyLinkedList {

    /**
     * Initialize your data structure here.
     */
    class Node {
        int val;
        Node next;

        Node(int x) {
            this.val = x;
        }
    }

    int length;
    Node head;

    public MyLinkedList() {
        this.length = 0;
        this.head = null;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        Node current = head;
        int count = 0;
        if (index >= length)
            return -1;
        while (count < index) {
            count++;
            current = current.next;
        }
        return current.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        Node newdata = new Node(val);
        newdata.next = head;
        head = newdata;
        length++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        Node newdata = new Node(val);
        length++;
        Node current = head;
        if (head == null) {
            head = newdata;
            return;
        }
        int count = 0;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newdata;
        newdata.next = null;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        Node newdata = new Node(val);
        Node current = head;
        if (index == 0) {
            addAtHead(val);
            return;
        }

        if (index > length)
            return;
        else
            length++;

        int count = 0;
        while (count < index - 1) {
            count++;
            current = current.next;
        }
        if (index == length) {
            current.next = newdata;
        } else {
            newdata.next = current.next;
            current.next = newdata;
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        Node current = head;
        int count = 0;
        if (index >= length)
            return;
        else
            length--;
        if (index == 0) {
            head = head.next;
            return;
        }

        while (count < index - 1) {
            count++;
            current = current.next;
        }
        current.next = current.next.next;
    }
}
