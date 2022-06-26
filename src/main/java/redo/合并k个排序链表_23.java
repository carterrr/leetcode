package redo;

import redo.base.ListNode;

/**
 * 分治  通过合并两个排序链表来归并
 */
public class 合并k个排序链表_23 {
  public ListNode mergeKLists(ListNode[] lists) {
    if(lists == null) return null;
    return mergeDivide(lists, 0, lists.length - 1);
  }

  public ListNode mergeDivide(ListNode[] lists, int l, int r) {
    if(l == r) return lists[l];
    if(r == l + 1) return merge2Lists(lists[l], lists[r]);
    int mid = l + ((r - l) >> 1);// + 号比 >> 符号运算优先级高  !!! 一定要加上括号
    return merge2Lists(mergeDivide(lists, l, mid), mergeDivide(lists, mid + 1, r));
  }

  public ListNode merge2Lists(ListNode l1, ListNode l2) {
    if(l1 == null) return l2;
    if(l2 == null) return l1;
    ListNode dummyHead = new ListNode();
    ListNode cur = dummyHead;
    while(l1 != null && l2 != null) {
      if(l1.val < l2.val) {
        cur.next = l1;
        l1 = l1.next;
      } else {
        cur.next = l2;
        l2 = l2.next;
      }
      cur = cur.next;
    }
    if(l1 != null) cur.next = l1;
    if(l2 != null) cur.next = l2;
    return dummyHead.next;
  }


/*public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for(ListNode l : lists) {
            if(l != null) {
                q.offer(l);
            }
        }
        ListNode dummyHead = new ListNode();
        ListNode cur = dummyHead;
        while(!q.isEmpty()) {
            ListNode min = q.poll();
            cur.next = min;
            cur = cur.next;
            if(min.next != null) {
                q.offer(min.next);
            }
        }
        return dummyHead.next;
    }*/

    
  public static void main(String[] args) {
    System.out.println(1 + (2 -0) >> 1);
    System.out.println(1 + ((2 -0) >> 1));

    ListNode f = new ListNode(5);
    ListNode e = new ListNode(4, f);
    ListNode a = new ListNode(1, e);

    ListNode ee = new ListNode(4);
    ListNode c = new ListNode(3, ee);
    ListNode aa = new ListNode(1, c);

    ListNode g = new ListNode(6);
    ListNode b = new ListNode(2, g);

    ListNode[] lists = new ListNode[]{null, null, null, null, null, null, null, null, null, null, null/*a, aa, b*/};
    合并k个排序链表_23 s = new 合并k个排序链表_23();
    s.mergeKLists(lists);

  }
}
