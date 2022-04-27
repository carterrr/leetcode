package redo;

public class 搜索插入位置_35 {

    public static void main(String[] args) {
        searchInsert(new int[]{1,3,5,6}, 7);
    }

    // 小技巧 ：直接把 r = len  将搜索范围扩大到 0 - len 可以避免最后的判断
    public static int searchInsert(int[] nums, int target) {
        int len = nums.length, l = 0, r = len - 1;
        while( l < r) {
            int mid = l + ( (r - l) >> 1 );
            if(nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[l] < target ? l + 1 : l;
    }

    public static int searchInsert_dead_loop(int[] nums, int target) {
        int l = 0, r = nums.length - 1, mid;
        // l < r 不用判断返回的是 l  还是 r  最终一定有 l = r
        // 只剩  两个数字时 只会 l + 1 = r 或者 r = l
        while(l < r) {
            mid = (l + r) >> 1;
            if(nums[mid] < target) {
                l = mid ;
            } else {
                r = mid - 1;
            }
        }
        //最终l == r 随便哪个都行
        return l;
    }


}
