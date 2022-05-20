package redo;

public class 岛屿的最大面积_695 {

  final int[][] dxy = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

  public int maxAreaOfIsland(int[][] grid) {
    int row = grid.length;
    int col = grid[0].length;
    boolean[][] visited = new boolean[grid.length][grid[0].length];
    int res = 0;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if(!visited[i][j]) {
          visited[i][j] = true;
          if(grid[i][j] == 1) {
            int maxArea = dfs(i, j, visited, grid); // 注意区分回溯和dfs区别
            res = Math.max(res, maxArea);
          }
        }
      }
    }
    return res;
  }

  private int dfs(int i, int j, boolean[][] visited, int[][] grid) {
    visited[i][j] = true;
    if(grid[i][j] == 0) { // dfs终止条件
      return 0;
    }
    int res = 1; // 如果是陆地 就向下遍历
    for (int k = 0; k < 4; k++) {
      int x = i + dxy[k][0];
      int y = j + dxy[k][1];
      if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && !visited[x][y]) {
        res += dfs(x, y, visited, grid); // 遍历过程把所有grid[i][j] == 1的加起来
      }
    }
    return res;
  }

}
