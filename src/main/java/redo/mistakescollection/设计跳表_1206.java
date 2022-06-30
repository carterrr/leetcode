package redo.mistakescollection;

/**
 * 跳表可以参考  https://www.jianshu.com/p/9d8296562806
 * 这里的图比较形象 https://leetcode.cn/problems/design-skiplist/solution/by-wugeyicheng-t5cx/
 */
public class 设计跳表_1206 {

  static class Node{
    static final double p = 1.0 / 4;
    public static final int MAX_LEVEL = 32;

    Node[] next; // 指向右侧每一级节点
    int val;

    public Node(int level, int val) {
      this.next = new Node[level];
      this.val = val;
    }

    public Node(int val) {
      this(randomLevel(), val);
    }

    static int randomLevel() {
      int level = 1; // 1/4 概率是 2层  1/16概率是3层  p直接影响高层的个数  redis设置的是0.25 也可以设置为0.5
      while(Math.random() < p && level++ <= MAX_LEVEL);
      return level;
    }
  }

  class Skiplist{

    Node emptyHead;

    public Skiplist() {
      emptyHead = new Node(32, -1);
    }

    public boolean search(int target) {
      Node cur = emptyHead;
      for (int i = Node.MAX_LEVEL - 1; i >= 0 ; i--) {
        while(cur.next[i] != null && cur.next[i].val < target) {
          cur = cur.next[i];
        }
        if(cur.next[i] != null && cur.next[i].val == target) return true;
      }
      return false;
    }

    public void add(int num) {
      int level = Node.randomLevel();
      Node node = new Node(level, num);
      Node cur = emptyHead;
      // 每层找到刚好小于的值插入节点
      // 上一层cur 和 cur.next[i] 之间  下一层可能有数据  因此采用向下向右查找的方式
      for(int i = Node.MAX_LEVEL - 1; i >= 0; i--) {
        while(cur.next[i] != null && cur.next[i].val < num) cur = cur.next[i];
        if(i > level - 1) continue;
        node.next[i] = cur.next[i];
        cur.next[i] = node;
      }
    }

    public boolean erase(int num) {
      Node cur = emptyHead;
      boolean finded = false;
      for (int i = Node.MAX_LEVEL - 1; i >= 0 ; i--) {
        while(cur.next[i] != null && cur.next[i].val < num) {
          cur = cur.next[i];
        }
        if(cur.next[i] != null && cur.next[i].val == num) {
          cur.next[i] = cur.next[i].next[i];
          finded = true;
        }
      }
      return finded;
    }
  }
}

