package redo;

import redo.base.ListNode;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class 环形链表II{
    class Solution {
        public ListNode detectCycle(ListNode head) {
            ListNode fast = head, slow = head;
            while(fast != null && fast.next !=null) {
                fast = fast.next.next;
                slow = slow.next;
                if(fast == slow) break;
            }
            if(fast == null || fast.next == null) return null;
            // 相遇时 f = 2s  f = s + nb   s=nb  入口点为a + nb 因此slow 走a步到达入口点  两个指针再次一起走就行
            fast = head;
            while(fast != slow) {
                fast =fast.next;
                slow = slow.next;
            }
            return slow;
        }
    }
}
