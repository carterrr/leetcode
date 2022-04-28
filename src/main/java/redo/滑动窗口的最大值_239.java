package redo;

import java.util.LinkedList;

/**
 * 单调队列的使用
 * 保证队列中存储的是当前窗口的排序序列
 * 窗口滑动后 因为 先入队的下标一定比后入队的小
 *               队尾往队首是从大到小排列
 *               每次至少移除一个窗口左边界的  就能保证队列中的数据一定在队列中  队尾最大
 */
public class 滑动窗口的最大值_239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] res = new int[len - k + 1];
        LinkedList<int[]> ll = new LinkedList<>();
        for(int r = 0; r < len; r ++ ) {
            while(!ll.isEmpty() && ll.peekFirst()[0] < nums[r]) {
                ll.pollFirst();
            }
            if(!ll.isEmpty() && ll.peekLast()[1] < r - k + 1) {
                ll.pollLast();
            }
            ll.addFirst(new int[]{nums[r], r}); // 最大放在Last  先进队的也放在Last
            if(r - k + 1 >= 0) res[r - k + 1] = ll.peekLast()[0];
        }
        return res;
    }
}
