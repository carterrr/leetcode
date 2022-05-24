package redo;

public class 使用最小花费爬楼梯_746 {

  class Solution {
    public int minCostClimbingStairs(int[] cost) {
      int[] dp = new int[cost.length]; // 从i向上爬需要的最小花费
      dp[0] = cost[0];
      dp[1] = cost[1];
      for(int i = 2; i < cost.length; i++) {
        dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
      }
      // 跳到顶部可能从最后一阶上来 也可能从倒数第二阶上来
      return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }
  }
}
