package redo;

/**
 * 左子树一定小于右子树  因此 种类数等于  sum（不同顶点下左子树种类数 * 右子树种类数）
 */
public class 不同的二叉搜索树_96 {
  class Solution {
    public int numTrees(int n) {
      int[] dp = new int[n + 1];
      dp[0] = dp[1] = 1; // 某个节点没有左分支  左分支只有一个节点  都是一种情况
      for(int i = 2; i < n + 1; i ++) { // 总结点数量
        for(int j = 0; j < i; j++) { // 二叉树左边节点数量  右边就是i- j  再减去顶点
          dp[i] += dp[j] * dp[i - j - 1];
        }
      }
      return dp[n];
    }
  }
}
