package redo.mistakescollection;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class 有序矩阵中第k小的元素_378 {


  /**
   * by heap
   * @param matrix
   * @param k
   * @return
   */
  public int kthSmallest(int[][] matrix, int k) {
    int len = matrix.length;
    Queue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
    for (int i = 0; i < matrix.length; i++) {
      q.offer(new int[]{matrix[i][0], i, 0});
    }
    for (int i = 0; i < k - 1; i++) {
      int[] poll = q.poll();
      int x = poll[1];
      int y = poll[2] + 1;
      if (y < len) {
        q.offer(new int[]{matrix[x][y], x, y});
      }
    }
    return q.poll()[0];
  }


  /**
   * 万物皆可二分
   * 二分的神奇之处在于能够将复杂度由n -> log2(n)
   */
  public int kthSmallest_divide2(int[][] matrix, int k) {
    int len = matrix.length;
    int l = matrix[0][0], r = matrix[len - 1][len - 1];
    while(l < r) {
      int mid = (l + r) >> 1;
      if(countLe(matrix, mid) < k) {
        l = mid + 1;// 小于等于mid的个数小于k  说明mid 小了
      } else {
        r = mid;  // 大于等于k不一定说明mid小了所以r = mid
      }
    }
    return l;
  }

  private int countLe(int[][] matrix, int target) { // 统计小于等于target的个数
    int x = matrix.length - 1, y = 0, count = 0;
    while (x >= 0 && y < matrix.length) {
      if (matrix[x][y] <= target) {
        count += x + 1;
        y ++;
      } else {
        x --;
      }
    }
    return count;
  }
}
