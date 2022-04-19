package redo;

import java.util.HashMap;
import java.util.Map;

public class 两数之和_1 {


    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i< nums.length; i++) {
                Integer other = map.get(nums[i]);
                if(other != null) {
                    return new int[]{other, i};
                }
                map.put(target - nums[i], i);
            }
            return null;
        }
    }
}
