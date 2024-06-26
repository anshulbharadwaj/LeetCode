package com.practice.concepts.ds.linkedlist;

/**
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
 * Internally, pos is used to denote the index of the node that tail's next pointer is connected to.
 * Note that pos is not passed as a parameter.
 * Return true if there is a cycle in the linked list. Otherwise, return false
 */
public class DetectCycle {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        DetectCycle dc = new DetectCycle();
        boolean hasCycle = dc.hasCycle(createCycle());
        System.out.println(hasCycle);
    }

    static ListNode createCycle() {
        //Create Nodes
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        // Link Nodes sequentially
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        // Create the cycle by pointing the last node to the second node
        node4.next = node2;
        // return the head of the cyclic node
        return node1;
    }
}
