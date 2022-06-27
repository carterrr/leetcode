package redo;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class 根据字符出现频率排序_451 {

  public String frequencySort(String s) {
    Map<Character, Integer> map = new HashMap<>();
    char[] sa = s.toCharArray();
    for(char sac : sa) {
      map.put(sac, map.getOrDefault(sac, 0) + 1);
    }
    Queue<Holder> q = new PriorityQueue<>((a, b) -> b.i - a.i);
    for(Map.Entry<Character, Integer> e : map.entrySet()) {
      q.offer(new Holder(e.getKey(), e.getValue()));
    }
    StringBuilder res = new StringBuilder();
    while(!q.isEmpty()) {
      Holder poll = q.poll();
      while(poll.i-- > 0) {
        res.append(poll.c);
      }
    }
    return res.toString();
  }


  static  class Holder {
    char c;
    int i;

    public Holder(final char c, final int i) {
      this.c = c;
      this.i = i;
    }
  }
}
