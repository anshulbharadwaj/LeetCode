package com.practice.concepts.ds.linkedlist;

public class CustomLinkedList {
    Node head; // head of the list

    class Node {
        int data;
        Node next;

        Node(int d) {
            this.data = d;
            next = null;
        }
    }

    public CustomLinkedList insert(CustomLinkedList list, int data) {
        Node new_node = new Node(data);
        new_node.next = null;

        // If linked list is empty, then make the new node as head
        if (list.head == null) {
            list.head = new_node;
        } else {
            // Else traverse till the last node and insert new_node there
            Node last = list.head;
            while(last.next!= null){
                last = last.next;
            }
            last.next = new_node;
        }
        // Return the list by head
        return list;
    }

    // Method to print the Linked List
    public void printList(CustomLinkedList list) {
        Node curr_node = list.head;

        while(curr_node != null){
            //Print the current node
            System.out.println(curr_node.data + " ");
            // Go to next node
            curr_node = curr_node.next;
        }
    }

    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList();

        list.insert(list, 5);
        list.insert(list, 6);

        list.printList(list);
    }

}


