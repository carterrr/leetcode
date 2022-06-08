package redo;

class 目标和_494 {
    // 背包问题和能否为j dp[j] = dp[j] | dp[j - mum]  和为j个数 dp[j] = dp[j] + dp[j - num]
    public int findTargetSumWays(int[] nums, int target) {
        for(int i : nums) {
            target += i;
        }
        
        if(target % 2 == 1) return 0;
        target = Math.abs(target >> 1); // 正负无所谓  就是把那些加+号的数字和加-号的数字互换符号即可
        int[] dp = new int[target + 1];
        dp[0] = 1; // 无论总共几个数字  只有什么都不选才能使得和为0  1种情况
        for(int num : nums) {
            for(int j = target; j >= num; j --) {
dp[j] = dp[j] + dp[j - num]; // dp[i][j] = dp[i - 1][j] + dp[i - 1][j - num];  前i个数字  和为j多少种情况  不选第i个数字num 此时为dp[i][j] 选的话就是dp[i - 1][j - num]
            }
            
        }

        return dp[target];
    }
}