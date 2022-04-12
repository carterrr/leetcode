package redo; /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

import redo.base.ListNode;
import redo.base.TreeNode;

public class 有序链表转换二叉搜索树_109{
    class Solution {
        public TreeNode sortedListToBST(ListNode head) {
            if(head == null ) return null;
            if(head.next == null) return new TreeNode(head.val);
            ListNode pre = null, slow = head, fast = head;
            while(fast!= null && fast.next != null) {
                pre = slow;
                slow = slow.next;
                fast = fast.next.next;
            }
            TreeNode root = new TreeNode(slow.val);
            pre.next = null;
            root.left = sortedListToBST(head);
            root.right = sortedListToBST(slow.next);
            return root;

        }
    }
}

