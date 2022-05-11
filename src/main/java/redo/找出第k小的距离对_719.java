package redo;

import java.util.Arrays;

/**
 * 注意两种边界处理方式
 */
public class 找出第k小的距离对_719 {
    public static void main(String[] args) {
        找出第k小的距离对_719 s = new 找出第k小的距离对_719();
        s.smallestDistancePair(new int[]{1,3,1}, 1)
                ;
    }
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, r = nums[nums.length - 1] - nums[0];
        while(l < r) {
            int mid = l + ((r - l + 1) >> 1);
            // 距离小于mid的对数 大于等于k  说明mid大了
            if(getLessThan(nums, mid) >= k ) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return l;
    }

    private int getLessThan(int[] nums, int mid) {
        int res = 0;
        for (int l = 0, r = 0; r < nums.length; r++) {
            while(nums[r] - nums[l] >= mid) l++; // 小于mid的对数
            res += r - l;
        }
        return res;
    }

    // 以下  第二种边界处理方式
    public int smallestDistancePair_(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, r = nums[nums.length - 1] - nums[0];
        while(l < r) {
            int mid = l + ((r - l) >> 1);
            // 找到距离小于等于mid的个数 恰好等于k的mid   小于等于mid为k  说明mid也是第k小的
            if(getLessOrEqualThan(nums, mid) >= k ) { // 大于等于说明可能是要求的值
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private int getLessOrEqualThan(int[] nums, int mid) {
        int res = 0;
        for (int l = 0, r = 0; r < nums.length; r++) {
            // 找到第一个小于等于mid的   r - l 刚好是对数  （从l 到 r - 1 的数字每个都和r组成一对数字）
            while(nums[r] - nums[l] > mid) l++;
            res += r - l;
        }
        return res;
    }
}
