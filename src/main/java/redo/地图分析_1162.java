package redo;

import java.util.LinkedList;
import java.util.Queue;

public class 地图分析_1162 {  // 同时从多个源头进行bfs  找这多个源头距离最远或最近的目标
    final int[][] dxy = {{0,-1},{0,1},{-1,0},{1,0}};
    public int maxDistance(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == 1) {
                    q.offer(new int[]{i, j}); 
                }
            }
        }
        if(q.size() == 0 || q.size() ==row * col) return -1;
        int[] cur = null;
        while(!q.isEmpty()) {
            cur = q.poll();
            for(int i = 0; i < 4; i++) {
                int x = cur[0] + dxy[i][0];
                int y = cur[1] + dxy[i][1];
                if(x >= 0 && y >= 0 && x < row && y < col && grid[x][y] == 0) { // 不是陆地 或者从其他陆地波及的海洋点  即没访问过的海洋点
                    grid[x][y] = grid[cur[0]][cur[1]] + 1;
                    q.offer(new int[]{x, y});
                }
            }
        }
        return grid[cur[0]][cur[1]] - 1;  // 最后访问的那个海洋点  减去最早陆地的1   不能用 x y  因为最后一次计算 x y 可能都是不满足条件的
    }
   
}