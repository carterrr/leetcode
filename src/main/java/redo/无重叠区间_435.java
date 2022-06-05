public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0) return 0;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));// 贪心思路 保证一直取到最小右边界 剩下的可能取到的区间会更多
        int res = 0;
        for (int i = 1, cur = intervals[0][1]; i < intervals.length; i++) {
            if(intervals[i][0] < cur ) {
                res ++;     // 去掉无效的区间
                continue;
            }
            if(intervals[i][1] >cur) cur = intervals[i][1]; // 或者更新右边界

        }
        return res;
    }