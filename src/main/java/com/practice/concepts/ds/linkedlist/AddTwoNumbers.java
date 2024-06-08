package com.practice.concepts.ds.linkedlist;
/*
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order, and each of their nodes contains a single digit.
Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]

*/

/**
 * The pseudocode is as following:
 * Initialize current node to dummy head of the returning list.
 * Initialize carry to 0.
 * Loop through lists l1 and l2 until you reach both ends and carry is 0.
 * Set x to node l1's value. If l1 has reached the end of l1, set to 0.
 * Set y to node l2's value. If l2 has reached the end of l2, set to 0.
 * Set sum=x+y+carry
 * Update carry=sum/10carry.
 * Create a new node with the digit value of (sum mod 10) and set it to current node's next, then advance current node to next.
 * Advance both l1 and l2.
 * Return dummy head's next node.
 */
public class AddTwoNumbers {
    class ListNode {
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tempHead = new ListNode(0);
        ListNode current = tempHead;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;

        }
        return tempHead.next;
    }


}
