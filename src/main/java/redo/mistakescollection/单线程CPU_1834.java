public class 单线程CPU_1834{

     public int[] getOrder(int[][] tasks) {
        int len = tasks.length;
        // 建堆 执行完获取数组中小于等于的入堆并重新poll执行
        Queue<int[]> q = new PriorityQueue<>((a,b) -> {
            if(a[1] == b[1]) return a[2] - b[2]; // 否则下标小的先出队
            return a[1] - b[1];                  // 执行时间小的先出队
        });
        for (int i = 0; i < len; i++) {
            tasks[i] = new int[]{tasks[i][0],tasks[i][1], i};
        }
        // 排序后保留原来的下标
        Arrays.sort(tasks, Comparator.comparingInt(a -> a[0]));
        int[] res = new int[len];
        int idx = 0, i = 0, curTime = tasks[0][0];
        while(i < len && tasks[i][0] <= curTime) {
            q.offer(tasks[i]);
            i++;
        }
        while(!q.isEmpty()) {
            int[] poll = q.poll();
            curTime += poll[1];
            if(i < len && curTime < tasks[i][0] && q.isEmpty()) { // 上一个任务完成了  但是没到下一个任务开始时间  队列也是空的了 直接跳过去加进来  这里是难点
                curTime = tasks[i][0];
            }
            res[idx++] = poll[2];
            while(i < len && tasks[i][0] <= curTime) { // 当前时间之前的全部加入排序 用于下一次poll
                q.offer(tasks[i]);
                i ++;
            }
        }
        return res;
    }

}