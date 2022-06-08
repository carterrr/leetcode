package redo;

class 分割等和子集_416 { // https://leetcode.cn/problems/partition-equal-subset-sum/solution/by-flix-szk7/
    public boolean canPartition(int[] nums) {
        int target = 0;
        for(int num : nums) {
            target += num;
        }
        if(target % 2 == 1) return false; // 和是奇数 没法对半分
        target = target >> 1; 
        // 剩下就是无放回的背包问题  重点参考 二维dp问题  dp[i][j] 表示前i个数字能使得和为j与否
        //for(int i = 0; i < nums.length ; i++) {
        //    for(int j = 1; j <= target; j++) {
        //        if(j < nums[i]) {
        //            dp[i][j] = dp[i - 1][j];
        //        } else {
        //            dp[i][j] = dp[i - 1][j-nums[i]] || dp[i - 1][j] // 选或不选
        //        }
        //    }
        //}

        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // 选择若干个数字使得和为0  不选数字就行
        for(int i = 1; i < nums.length; i ++) {// 更新nums.length轮  
            for(int j = target; j >= nums[i - 1]; j -- ) { 
                    dp[j] |= dp[j - nums[i - 1]]; // j < nums[i]的时候   dp[j] = dp[j] 不用额外判断
            }
        }
        return dp[target];
    }
}