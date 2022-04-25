package redo;

import redo.base.ListNode;

public class 链表的中间节点_876 {


    class Solution {
        public ListNode middleNode(ListNode head) {
            ListNode slow  = head, fast = head;
            while(fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }
    }
}
