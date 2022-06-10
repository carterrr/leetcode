package redo;

public class 只出现一次的数字III_260 {
  class Solution {
    public int[] singleNumber(int[] nums) {
      int xor = 0 ,a = 0, b = 0;
      for(int num : nums) {
        xor ^= num;
      }
      xor = xor & (-xor); // 取 a b 两个数异或的最右边的1    ab 两个数这一位一定不同
      for(int num : nums) {
        if((xor&num) == 0) {
          a ^= num;
        } else {
          b ^= num;
        }
      }
      return new int[]{a,b};
    }
  }
}
