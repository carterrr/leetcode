 public class 新21点_837{
    public double new21Game(int n, int k, int maxPts) {
        if(n >= k - 1 + maxPts) return 1; // 到了k就不抽了  最多是k - 1抽到w  因此此时不超过n的概率就是1
        double[] dp = new double[k + maxPts]; // 共k + maxPts - 1位概率  dp[0]就是一开始什么都不抽
        for(int i = k; i <= n; i++) dp[i] = 1.0;
        double window = n - k + 1;// 上一行初始化1的个数
        for(int i = k - 1; i >= 0; i--) {
            dp[i] = window / maxPts;
            window = window - dp[i + maxPts] + dp[i];
        }
        return dp[0];
    }
 }
 