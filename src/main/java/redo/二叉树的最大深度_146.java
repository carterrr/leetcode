package redo;


public class 二叉树的最大深度_104 {
}
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        int leftDepth = maxDepth(root.left) ;
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1; // 每次加上自身高度  否则一直往下递归  直到最终两种节点
    }

}