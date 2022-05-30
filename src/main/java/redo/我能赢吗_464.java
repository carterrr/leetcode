package redo;

/**
 * 状态压缩dp  就是将当前状态存在一个二进制值当中， 不断dfs递归并剪枝 dfs过程中填充dp数组  dp数组的位数应该为 1 << max
 */
public class 我能赢吗_464 {
  public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
    if(maxChoosableInteger >= desiredTotal) return true;
    if((maxChoosableInteger + 1) * maxChoosableInteger / 2 < desiredTotal) return false;
    return dfs(maxChoosableInteger, desiredTotal, new Boolean[1 << maxChoosableInteger], 0);// 状态压缩dp  dfs形式填充dp数组
  }

  private boolean dfs(int maxChoosableInteger, int remainTotal, Boolean[] dp, int state) {
    if(dp[state] != null) return dp[state];
    for (int i = 1; i <= maxChoosableInteger; i++) {
      int cur = 1 << (i - 1);
      if((state & cur) != 0) {
        continue; // i这个数字已经被选择过了
      }
      // 下一步对手选了之后输了  那么自己就赢了
      if(i >= remainTotal || !dfs(maxChoosableInteger, remainTotal - i, dp, state | cur)) {
        return dp[state] = true;
      }
    }
    return dp[state] = false; // 遍历完了所有数字还没获胜 就是输了
  }
}
