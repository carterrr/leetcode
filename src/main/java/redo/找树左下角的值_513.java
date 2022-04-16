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
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        int[] res = new int[]{-1, 0};
        dfs(root, res, 0);
        return res[1];
    }

    // 二元组  level  val
    public void dfs(TreeNode node, int[] bottomLeft, int h) { // h 水平坐标
        if(h > bottomLeft[0]){
            bottomLeft[0] = h;
            bottomLeft[1] = node.val;
        } 
        if(node.left != null) dfs(node.left, bottomLeft, h + 1);
        if(node.right != null) dfs(node.right, bottomLeft, h + 1);
    }
}