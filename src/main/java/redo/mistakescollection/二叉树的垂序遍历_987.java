package redo.mistakescollection;

import redo.base.TreeNode;

import java.util.*;

/**
 * 本质 ： dfs or bfs遍历 + 排序
 */
public class 二叉树的垂序遍历_987 {

    public static void main(String[] args) {

        TreeNode _3 = new TreeNode(3);
        TreeNode _9 = new TreeNode(9);
        TreeNode _20 = new TreeNode(20);
        TreeNode _15 = new TreeNode(15);
        TreeNode _7 = new TreeNode(7);
        _3.left = _9;
        _3.right = _20;
        _20.left = _15;
        _20.right = _7;
        Solution solution = new Solution();
        solution.verticalTraversal(_3);

    }


    static class Solution {
        public List<List<Integer>> verticalTraversal(TreeNode root) {
            PriorityQueue<int[]> q = new PriorityQueue<int[]>((a, b) ->{
                if(a[0] != b[0]) return a[0] - b[0];// x从小到大
                if(a[1] != b[1]) return a[1] - b[1];// y从小到大
                return a[2] - b[2]; // val 从小到大
            });
            dfs(root, q, 0, 0);
            List<List<Integer>> res = new ArrayList<>();
            while(!q.isEmpty()) {
                List<Integer> tmp = new ArrayList<>();
                int[] item = q.poll();
                tmp.add(item[2]);
                while(!q.isEmpty() && q.peek()[0] == item[0]) { // 同一列
                    tmp.add(q.poll()[2]);
                }
                res.add(tmp);
            }
            return res;
        }

        private void dfs(TreeNode node, Queue<int[]> queue, int x, int y) {
            if(node == null) return;
            queue.add(new int[]{x,y,node.val});
            dfs(node.left, queue, x - 1, y + 1);
            dfs(node.right, queue, x + 1, y + 1);
        }
        private void bfs(TreeNode node, Queue<int[]> queue, int x, int y) {

        }

    }
}
