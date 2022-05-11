package redo;

import java.util.ArrayList;
import java.util.List;

public class 翻转对_493 {
    public int reversePairs(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(nums[nums.length - 1]);
        list.add(Integer.MAX_VALUE); // 占位符 防止l = 0 = r = list.size() - 1 = 0
        int res = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            // 查找小于的 list[j] 个数  因为从0 开始  最终找到的个数要加一
            // 可以找第一个不满足条件的
            // 即找到第一个大于等于nums[i]的
            int l = 0 , r = list.size() - 1;
            while(l < r) {
                int mid = l + ((r - l) >> 1);
                if (list.get(mid) >= nums[i] / 2.0) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }

            res += l ;
            //二分查找插入到list 找到第一个大于的位置
            l = 0; r = list.size() - 1;
            while(l < r) {
                int mid = l + ((r - l) >> 1);
                if(list.get(mid) <= nums[i]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }

            list.add(l, nums[i]);
        }
        return res;
    }


    public static void main(String[] args) {
        翻转对_493 s = new 翻转对_493();
        s.reversePairs(new int[]{1,3,2,3,1});
    }
}
