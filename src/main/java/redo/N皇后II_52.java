package redo;

/**
 * 关键点
 * 1. 3个visited数组  列  正斜线 反斜线
 * 2. 行不记录 按行向下回溯选择每一列
 * 3. 回溯完一列 要删除访问记录 避免干扰下一轮
 */
public class N皇后II_52 {

  public int totalNQueens(int n) {
    boolean[] col = new boolean[n];
    boolean[] slash = new boolean[2 * n - 1];
    boolean[] backSlash = new boolean[2 * n - 1];
    return backtrack(0, n, col, slash, backSlash);

  }


  private int backtrack(int row, int n, boolean[] colVisited,  boolean[] slashVisited, boolean[] backSlashVisited) {
    if(row == n) return 1; // 越过了最后一行
    int res = 0;
    for (int col = 0; col < n; col++) {
      if(available(row, col, colVisited, slashVisited, backSlashVisited)) {
        colVisited[col] = true;
        slashVisited[row + col] = true;
        backSlashVisited[row - col + n - 1] = true;
        res += backtrack(row + 1, n , colVisited, slashVisited, backSlashVisited);
        colVisited[col] = false;
        slashVisited[row + col] = false;
        backSlashVisited[row - col + n - 1] = false;
      }
    }
    return res;
  }

  private boolean available(int row, int col, boolean[] colVisited, boolean[] slashVisited, boolean[] backSlashVisited) {
    if( colVisited[col] || slashVisited[col + row] || backSlashVisited[row - col + colVisited.length - 1]) {
      return false;
    }
    return true;
  }


}
