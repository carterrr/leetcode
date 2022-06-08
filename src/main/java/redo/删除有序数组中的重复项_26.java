package redo;

public class 删除有序数组中的重复项_26 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4});
    }

    static class Solution {
            public int removeDuplicates(int[] nums) {
                int l = 1, r = 1, len = nums.length;
                while(r < len) {
                    if(nums[r] != nums[l - 1]) {
                        nums[l] =  nums[r];
                        l ++;
                    }
                    r ++;
                }
                return l;
            }
    }

}
