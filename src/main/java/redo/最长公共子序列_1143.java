package redo;

public class 最长公共子序列_1143 {

  public static void main(String[] args) {
    最长公共子序列_1143 s  = new 最长公共子序列_1143();
    s.longestCommonSubsequence("ezupkr",
        "ubmrapg");
  }

  public int longestCommonSubsequence_(String text1, String text2) {
    char[] t1 = text1.toCharArray();
    char[] t2 = text2.toCharArray();
    int[][] dp = new int[t1.length][t2.length];
    dp[0][0] = t1[0] == t2[0] ? 1 : 0;
    if(t1.length > 1) {
      dp[1][0] = t1[1] == t2[0] ? 1 : dp[0][0];
    }
    if(t2.length > 1) {
      dp[0][1] = t1[0] == t2[1] ? 1 : dp[0][0];
    }

   // 这种是有问题的  如果 t1[0] 等于  t2[2]  这种就统计 不到
    for(int i = 1; i < t1.length; i++) {
      for(int j = 1; j < t2.length; j++) {
        if(t1[i] == t2[j]) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    return dp[t1.length - 1][t2.length - 1];
  }

  public int longestCommonSubsequence(String text1, String text2) {
    char[] t1 = text1.toCharArray();
    char[] t2 = text2.toCharArray();
    // 避免了i = 0 时  无法使用 i- 1 的问题
    int[][] dp = new int[t1.length + 1][t2.length + 1];
    /*
    这种方式
    dp 初始值涵盖在循环里面  不用单独处理了
    dp[0][0] = t1[0] == t2[0] ? 1 : 0;
    if(t1.length > 1) {
      dp[1][0] = t1[1] == t2[0] ? 1 : dp[0][0];
    }
    if(t2.length > 1) {
      dp[0][1] = t1[0] == t2[1] ? 1 : dp[0][0];
    }*/

    for(int i = 1; i <= t1.length; i++) {
      for(int j = 1; j <= t2.length; j++) {
        if(t1[i - 1] == t2[j - 1]) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    return dp[t1.length][t2.length];
  }
}
