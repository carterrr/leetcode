package redo;

public class 打家劫舍_198 {

  class Solution {
    public int rob(int[] nums) {
      if(nums.length == 1) return nums[0];
      int[] dp = new int[nums.length]; // 前i 家能偷到的最大值
      dp[0] = nums[0];
      dp[1] = Math.max(dp[0], nums[1]);
      for(int i = 2; i < nums.length; i++) {
        dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]); // 前一家的最大值 或者 前前一家的最大值加上自己
        System.out.println(dp[i]);
      }

      return dp[nums.length - 1];
    }  //  100  2 9 54  这种其实最大值 154  dp[1] = dp[0] = 100 dp[2] = 109 dp[3] = 154  因为dp[1] 不是 2 而是 100
  }


}
