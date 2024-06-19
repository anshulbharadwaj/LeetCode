package com.practice.concepts.ds.linkedlist;

public class MergeTwoSortedList {


    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode tempNode = new ListNode(0);
        ListNode currentNode = tempNode;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                currentNode.next = list1;
                list1 = list1.next;
            } else {
                currentNode.next = list2;
                list2 = list2.next;
            }
            currentNode = currentNode.next;
        }
        if (list1 != null) {
            currentNode.next = list1;
            list1 = list1.next;
        }

        if (list2 != null) {
            currentNode.next = list2;
            list2 = list2.next;
        }
        return tempNode.next;

    }

    public static void main(String[] args) {
        MergeTwoSortedList merge = new MergeTwoSortedList();
        ListNode result = merge.mergeTwoLists(merge.createListOne(), merge.createListTwo());
        merge.traverse(result);

    }

    ListNode createListOne() {
        // creating list1: 1->2->4
        ListNode listOne = new ListNode(1);
        listOne.next = new ListNode(2);
        listOne.next.next = new ListNode(4);
        return listOne;
    }

    ListNode createListTwo() {
        //creating list2: 1->3->4
        ListNode listTwo = new ListNode(1);
        listTwo.next = new ListNode(3);
        listTwo.next.next = new ListNode(4);
        return listTwo;
    }

    void traverse(ListNode node){
        ListNode current = node;
        while(current!=null){
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}
