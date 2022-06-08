package redo;

class 零钱兑换_322{
    public int coinChange(int[] coins, int amount) {
        int len = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for(int i = 1; i < amount + 1; i ++) dp[i] = amount + 1;// 不可能值  求min的时候用大的+1 求max 用min - 1
        
            for(int i = 1; i <= amount; i++) {
                for(int coin : coins) {
                    if(i >= coin) 
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);         // 对每个amount 都枚举每个硬币更新一下          
            }
        }
        return dp[amount] == amount + 1? -1 : dp[amount];
    }
}