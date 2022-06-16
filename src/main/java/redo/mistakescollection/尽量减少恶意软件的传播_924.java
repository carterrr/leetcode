package redo.mistakescollection;

import java.util.Arrays;

public class 尽量减少恶意软件的传播_924 {
  public int minMalwareSpread(int[][] graph, int[] initial) {
    UF uf = new UF(graph.length);
    for(int i = 0; i < graph.length; i++) {
      for(int j = 0; j < i ; j++) {
        if(graph[i][j] == 1) uf.union(i, j);
      }
    }
    Arrays.sort(initial);
    int[] infectedGroupRoot = new int[graph.length];
    for (int i : initial) infectedGroupRoot[uf.findRoot(i)] ++;
    int res = initial[0], max = 0;
    for (int i : initial) {
      final int root = uf.findRoot(i);
      if(infectedGroupRoot[root] >= 2) continue; // 一个联通子图中有两个点被感染 删一个最多少一个  应该返回initial[0]
      if(uf.groupSize[root] > max) {
        max = uf.groupSize[root];
        res = i;
      }
    }
    return res;
  }

  class UF{
    int[] root;
    int[] groupSize;

    public UF(int n) {
      root = new int[n];
      groupSize = new int[n];
      for (int i = 0; i < n; i++) {
        root[i] = i;
        groupSize[i] = 1;
      }
    }

    public void union(int p, int q) {
      int pr = findRoot(p);
      int qr = findRoot(q);
      if(pr != qr) {
        root[pr] = qr;
        groupSize[qr] += groupSize[pr];
      }
    }

    private int findRoot(final int p) {
      if(root[p] == p) return p;
      return root[p] = findRoot(root[p]);
    }
  }

}
