package redo;

import redo.base.ListNode;

public class 旋转链表_61{private class Solution_ {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0) return head;
        int l = 1 ;
        ListNode dummyHead = head;
        while(head.next != null) {
            head = head.next;
            l++;
        }
        ListNode tail = head;
        k = k % l;
        if(k == 0) return dummyHead;
        l -= k;

        head = dummyHead;
        while(--l > 0) {
            head = head.next;
        }

        ListNode newHead = head.next;
        head.next = null;
        tail.next = dummyHead;
        return newHead;
    }
}}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
