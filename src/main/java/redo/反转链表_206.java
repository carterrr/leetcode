package redo;

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

 public class 反转链表_206 {class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode fst = head, snd = head.next;
        while(snd != null) {
            ListNode nextnext = snd.next;
            snd.next = fst;
            fst = snd; // 窗口平移
            snd = nextnext;
        }
        head.next = null;
        return fst;
    }
    public ListNode reverseList_(ListNode head) {
        if(head == null) return null;
        if (head.next == null) return head;
        ListNode finalHead = reverseList(head.next); // 返回最后一个节点
        head.next.next = head; // 倒数第二个开始  反转指针
        head.next = null; // 避免原始头节点和第二个节点之间有双向指针
        return finalHead;
    }

}}



 class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }