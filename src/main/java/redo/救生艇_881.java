package redo;

import java.util.Arrays;

public class 救生艇_881 {
  class Solution {
    public int numRescueBoats(int[] people, int limit) {
      // 贪心  每次 最大 + 最小  不行就最大   (一定有 people[i] <=limit  所以不用取小的那个)
      Arrays.sort(people);
      int min = 0, max = people.length - 1, res = 0; // 双指针
      while(min <= max) {
        if(people[min] + people[max] <= limit) {
          min++;
        }
        max --; // 一定有 people[i] <=limit
        res ++;
      }
      return res;
    }
  }
}
