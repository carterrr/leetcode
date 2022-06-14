package redo;

import java.util.HashMap;
import java.util.Map;

public class 键值映射_677 {
}

class MapSum {
  private MapSum[] next;

  private int sum;

  private Map<String, Integer> kvPair = new HashMap<>(); // 用于修正sum

  public MapSum() {
    next = new MapSum[26];
    sum = 0;
  }

  public void insert(String key, int val) {
    MapSum ms = this;
    int diff = val;
    if(kvPair.containsKey(key)) diff = diff - kvPair.get(key);
    kvPair.put(key, val);
    for (int i = 0; i < key.length(); i++) {
      int c = key.charAt(i) - 'a';
      MapSum nms = ms.next[c];
      if(nms == null) {nms = new MapSum(); ms.next[c] = nms;}
      nms.sum += diff;
      ms = nms;
    }
  }

  public int sum(String prefix) {
    MapSum ms = this;
    for (int i = 0; i < prefix.length(); i++) {
      int c = prefix.charAt(i) - 'a';
      MapSum nms = ms.next[c];
      if(nms == null) return 0;
      ms = nms;
    }
    return ms.sum;
  }

  public static void main(String[] args) {
    MapSum ms = new MapSum();
    ms.insert("apple",3);
    ms.sum("apple");
    ms.insert("app",2);
    ms.sum("ap");

  }
}
