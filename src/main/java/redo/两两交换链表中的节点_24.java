package redo;

public class 两两交换链表中的节点_24 {
    class Solution {
        public ListNode swapPairs(ListNode head) {
            ListNode dummyHead = new ListNode(-1, head);
            ListNode cur = dummyHead;
            while(cur.next != null && cur.next.next != null) {
                ListNode next2 = cur.next.next;
                ListNode next3 = cur.next.next.next;
                cur.next.next = next3;
                next2.next = cur.next;
                cur.next = next2;
                cur = next2.next; // cur 指向两个要交换节点的前一个节点
            }
            return dummyHead.next;
        }
    }
}

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

