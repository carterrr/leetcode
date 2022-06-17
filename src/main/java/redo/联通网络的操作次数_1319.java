package redo;

public class 联通网络的操作次数_1319 {
  public static void main(String[] args) {
    联通网络的操作次数_1319 s = new 联通网络的操作次数_1319();
    s.makeConnected(5, new int[][]{{0,1},{0,2},{3,4},{2,3}}
        );
  }


  public int makeConnected(int n, int[][] connections) {
    UF uf = new UF(n);
    for (int i = 0; i < connections.length; i++) {
        uf.union(connections[i][0], connections[i][1]);
    }
    if(uf.count < n - 1) return -1;
    return uf.size - 1;
  }

  class UF {
    int[] root;
    int size;
    int count;

    public UF(int n) {
      this.root = new int[n];
      for (int i = 0; i < n; i++) {
        root[i] = i;
      }
      size = n;
      count = 0;
    }

    public void union(int p ,int q) {
      count++; // 绳子多一根
      int pr = findRoot(p);
      int qr = findRoot(q);
      if(pr != qr) {
        root[pr] = qr;
        size --;
      }
    }


    public int findRoot(int p) {
      if(root[p] == p) return p;
      return root[p] = findRoot(root[p]);
    }

  }
}
