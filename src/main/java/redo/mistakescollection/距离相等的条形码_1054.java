package redo.mistakescollection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 贪心堆  堆的多行元素处理
 * 类似于 有序矩阵中第k小的元素_378
 */
public class 距离相等的条形码_1054 {
  public int[] rearrangeBarcodes(int[] barcodes) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int b : barcodes) {
      map.put(b, map.getOrDefault(b, 0) + 1);
    }
    Queue<int[]> q = new PriorityQueue<>((a,b) -> b[1] - a[1]);
    Iterator<Map.Entry<Integer,Integer>> iterator = map.entrySet().iterator();
    while(iterator.hasNext()) {
      Map.Entry<Integer, Integer> next = iterator.next();
      q.offer(new int[]{next.getKey(), next.getValue()});
    }
    int i = 0;
    while(q.size() > 1) {
      int[] a = q.poll();
      int[] b = q.poll();
      barcodes[i++] = a[0];
      barcodes[i++] = b[0];
      a[1] -= 1;
      b[1] -= 1;
      if(a[1] > 0) {
        q.offer(a);
      }
      if(b[1] > 0) {
        q.offer(b);
      }
    }
    if(!q.isEmpty()) {
      int[] c = q.poll();
      for (int j = c[1]; j > 0 ; j--) {
        barcodes[i++] = c[0];
      }
    }
    return barcodes;
  }
}
