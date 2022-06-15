package redo;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入：
 * big = "mississippi"
 * smalls = ["is","ppi","hi","sis","i","ssippi"]
 * 输出： [[1,4],[8],[],[3],[1,4,7,10],[5]]
 *
 * tips : 这个其实就是elasticserach 的trie实现
 *
 */
public class 面试题17多次搜索 {
    public int[][] multiSearch(String big, String[] smalls) {
      Trie trie = new Trie(smalls);
      return trie.search(big);
    }

    private class Trie{
      private Trie[] next;
      private int idx = -1;
      private int reslen = 0;
      public Trie() {
        next = new Trie[26];
      }

      public Trie(String[] smalls) {
        this();
        reslen = smalls.length;
        for (int i = 0; i < smalls.length; i++) {
          insert(smalls[i], i);
        }
      }

      private void insert(String small, int idx) {
        Trie cur = this;
        for (char c : small.toCharArray()) {
          int n = c - 'a';
          if(cur.next[n] == null) cur.next[n] = new Trie();
          cur = cur.next[n];
        }
        cur.idx = idx;
      }

      public int[][] search(String big) {
        int len = big.length();
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < reslen; i++) {
          list.add(new ArrayList<>());
        }
        for (int i = 0; i < len; i++) {
          String slice = big.substring(i, len);
          Trie cur = this;
          for (char c : slice.toCharArray()) {
            int n = c - 'a';
            cur = cur.next[n];
            if (cur == null) break;
            if(cur.idx != -1) list.get(cur.idx).add(i);
          }
        }
        int[][] res = new int[reslen][];
        for (int i = 0; i < reslen; i++) {
          List<Integer> s = list.get(i);
          res[i] = new int[s.size()];
          for (int j = 0; j < s.size(); j++) {
            res[i][j] = s.get(j);
          }
        }
        return res;
      }
    }

  public static void main(String[] args) {

    面试题17多次搜索 s = new 面试题17多次搜索();
    s.multiSearch("mississippi", new String[]{"is","ppi","hi","sis","i","ssippi"});
  }
}
