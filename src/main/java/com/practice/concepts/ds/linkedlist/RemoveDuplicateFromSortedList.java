package com.practice.concepts.ds.linkedlist;

public class RemoveDuplicateFromSortedList {

    /**
     * Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
     * Return the linked list sorted as well.
     *
     * Input: head = [1,1,2]
     * Output: [1,2]
     *
     * Input: head = [1,1,2,3,3]
     * Output: [1,2,3]
     */

    // Definition for singly-linked list.
     class ListNode {
          int val;
          ListNode next;
      }

    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode prev = head;
            if(head ==null || head.next == null ){
                return head;
            }
            while(prev.next != null) {
                if(prev.val == prev.next.val) {
                    prev.next = prev.next.next;
                } else {
                    prev = prev.next;
                }
            }
            return head;
        }
    }
}
