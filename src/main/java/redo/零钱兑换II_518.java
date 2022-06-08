package redo;

class 零钱兑换II_518 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        //两层循环coin在外算组合  coin在内算排列
        for(int coin : coins) {
        for(int i = 1; i <= amount; i++) {// 外层amount 内层coin时 会对内层coin重复计算  如和为 3  算了 1 2  也算了 2 1  
                if(coin <= i) {
                    dp[i] += dp[i - coin];
                }
            }
            
        }
        return dp[amount];
    }
}