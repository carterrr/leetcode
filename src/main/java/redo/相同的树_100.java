package redo;

import redo.base.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class 相同的树_100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true; // 都为空
        else if( p == null || q == null) return false; // 一个空 一个不空
        return p.val ==q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right); // 值相等且左右子树相等
    }
}