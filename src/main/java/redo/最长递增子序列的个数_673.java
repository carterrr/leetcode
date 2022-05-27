package redo;

import java.util.Arrays;


/**
 * @see https://leetcode.cn/problems/number-of-longest-increasing-subsequence/solution/673-zui-chang-di-zeng-zi-xu-lie-de-ge-sh-g7a0/
 * 双层循环推导的方式
 */
public class 最长递增子序列的个数_673 {
  public int findNumberOfLIS(int[] nums) {
    if(nums.length == 1) return 1;
    int[] dpl = new int[nums.length]; // 截至到i  最长递增子序列长度
    int[] dpc = new int[nums.length];
    Arrays.fill(dpl, 1);
    Arrays.fill(dpc, 1);
    int maxLength = 1;
    for(int i = 1; i < nums.length; i++) {
      for(int j = 0; j < i; j ++) {
        if(nums[i] > nums[j]) {
          if(dpl[i] < dpl[j] + 1) {
            dpl[i] = dpl[j] + 1;
            dpc[i] = dpc[j];
          } else if(dpl[i] == dpl[j] + 1) {
            dpc[i] += dpc[j];
          }
        }

      }
      maxLength = Math.max(maxLength, dpl[i]);
    }

    int res = 0;
    for(int i = 0; i < nums.length; i++) {
      if(maxLength == dpl[i]) res += dpc[i];
    }
    return res;
  }
}
