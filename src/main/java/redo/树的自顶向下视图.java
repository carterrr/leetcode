package redo;

import redo.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * https://binarysearch.com/problems/Top-View-of-a-Tree
 */
public class 树的自顶向下视图 {
  
  public int[] solve(TreeNode root){
    Queue<BFSNode> q = new LinkedList<>();
    SortedMap<Integer, Integer> map = new TreeMap<>();
    q.offer(new BFSNode(0, root));
    map.put(0, root.val);
    while(!q.isEmpty()) {
      BFSNode cur = q.poll();
      int vertical = cur.vertical;
      TreeNode left = cur.TreeNode.left;
      TreeNode right = cur.TreeNode.right;

      if(left != null) {
        BFSNode leftNode = new BFSNode(vertical - 1, left);
        if(!map.containsKey(vertical - 1)) {
          map.put(vertical - 1, left.val);
        }
        q.offer(leftNode);
      }

      if(right != null) {
        BFSNode rightNode = new BFSNode(vertical + 1, left);
        if(!map.containsKey(vertical + 1)) {
          map.put(vertical + 1, right.val);
        }
        q.offer(rightNode);
      }
    }
    int[] res = new int[map.size()];
    int idx = 0;
    for(int i : map.values()) {
      res[idx++] = i;
    }
    return res;
  }

  private class BFSNode{
    int vertical;
    TreeNode TreeNode;

    public BFSNode(int vertical,TreeNode TreeNode) {
      this.vertical = vertical;
      this.TreeNode = TreeNode;
    }
  }
  
}
