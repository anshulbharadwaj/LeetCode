package com.practice.concepts.ds.linkedlist;

public class MyLinkedList {
    Node head;
    int numberOfNodes = 0;

    public MyLinkedList() {
    }

    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    /**
     * Get the value of the index-th node in the linked list.
     * If the index is invalid, return -1
     *
     * @param index index of element
     * @return value of element at index
     */
    public int get(int index) {
        if (index < 0 || index >= numberOfNodes)
            return -1;
        Node curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.value;
    }

    /**
     * Add a node of value val before the first element of the linked list.
     * After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        numberOfNodes++;
        Node node = new Node(val);
        if (head == null) {
            head = node;
        }
        node.next = head;
        head = node;
    }

    /**
     * Appends a node of value val as the last element of the linked list
     *
     * @param val value to be added at tail
     */
    public void addAtTail(int val) {
        Node node = new Node(val);
        Node curr = head;
        if (curr == null) {
            curr = node;
            head = curr;
        } else {
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = node;
        }

        numberOfNodes++;
    }

    /**
     * Add a node of value val before the indexth node in the linked list.
     * If index equals the length of the linked list, the node will be appended to the end of the linked list.
     * If index is greater than the length, the node will not be inserted.
     *
     * @param index index of the element
     * @param val   value to be added at index
     */
    public void addAtIndex(int index, int val) {
        if (index > numberOfNodes)
            return;
        if (index <= 0)
            addAtHead(val);
        else if (index == numberOfNodes)
            addAtTail(val);
        else {
            Node curr = head;
            for (int i = 1; i < index; i++)
                curr = curr.next;
            Node node = new Node(val);
            node.next = curr.next;
            curr.next = node;
            numberOfNodes++;
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= numberOfNodes)
            return;
        if (index == 0) {
            if (head == null)
                return;
            else {
                Node node = head.next;
                head = node;
            }
        } else {
            Node curr = head;
            int i = 1;
            for (; i < index; i++) {
                curr = curr.next;
            }
            if (i == numberOfNodes - 1) {
                curr.next = null;
            } else {
                curr.next = curr.next.next;
            }
        }
        numberOfNodes--;
    }
}
