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
public class 求根节点到叶子节点数字之和_129 {
    public int sumNumbers(TreeNode root) {
        return cursion(root, 0);
    }

    public int cursion(TreeNode node, int num) {
        int cur = num*10 + node.val;
        if(node.left == null && node.right == null) return cur;// 叶子节点
        if(node.left == null) return cursion(node.right, cur); // 右分支
        if(node.right == null) return cursion(node.left, cur); // 左分支
        return cursion(node.left, cur) + cursion(node.right, cur); // 二叉
    }
}