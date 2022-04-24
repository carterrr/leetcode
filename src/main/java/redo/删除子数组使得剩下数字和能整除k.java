package redo;

import java.util.HashMap;
import java.util.Map;

public class 删除子数组使得剩下数字和能整除k {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve(new int[]{1,2}, 2);
    }

    static class Solution {
        public static int solve(int[] nums, int k) {
            int sum = 0, res = nums.length + 1;
            for(int num : nums) {
                sum += num;
            }
            int target = sum % k;
            System.out.println(target);
            sum = 0;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, -1);
            for(int i = 0; i < nums.length; i++) {
                sum += nums[i];
                int mod = sum % k;
                Integer left = map.get(mod -target);
                if(left != null) {
                    System.out.println(left + "-" + i);
                    res = Math.min(i - left, res);
                }
                map.put(mod - target, i);
            }
            return res == nums.length + 1 ? -1 : res;
        }
    }
}
