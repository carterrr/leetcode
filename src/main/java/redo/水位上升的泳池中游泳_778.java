package redo;

import java.util.LinkedList;
import java.util.Queue;

public class 水位上升的泳池中游泳_778 {

    public static void main(String[] args) {
        水位上升的泳池中游泳_778 s = new 水位上升的泳池中游泳_778();
        s.swimInWater(new int[][]{{0}});
    }


    public int swimInWater(int[][] grid) {
        int len = grid.length;
        int l = 0 , r = len * len;
        while(l < r) {
            int mid = l + ((r - l) >> 1);
            if(canPass(grid, mid)) { //找到最小的能通过的值
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean canPass(int[][] grid, int t) {
        if(grid[0][0] > t) return false;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        boolean[][] visited = new boolean[grid.length][grid.length];
        visited[0][0] = true;
        int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        // 广度优先  寻找路径
        while(!q.isEmpty()) {
            int[] loc = q.poll();
            if (loc[0] == grid.length - 1 && loc[1] == grid.length - 1)
            for (int[] dir : directions) {
                int x = loc[0] + dir[0];
                int y = loc[1] + dir[1];
                if( x >= 0 && x < grid.length
                        && y >= 0 && y < grid.length
                        && !visited[x][y]
                        && grid[x][y] <=t) {
                    q.offer(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }
        return false;
    }
}
