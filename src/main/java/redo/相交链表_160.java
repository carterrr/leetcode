package redo;

import redo.base.ListNode;

public class 相交链表_160 {class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA, curB = headB;
        while(curA != curB) {
            // 不能 if null  cura = headb  ； cura = cura.next; 不可以先改后移动 移动了两次 有问题
            if(curA == null) {
                curA = headB;
            } else {
                curA = curA.next;

            }
            if(curB == null) {
                curB = headA;
            } else {
                curB = curB.next;
            }

        }
        return curA;
    }
}
}