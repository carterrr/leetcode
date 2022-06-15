package redo.mistakescollection;

public class 省份数量_547 {

  public static void main(String[] args) {

    int[][] isConnected =   {{1,1,1},{1,1,1},{1,1,1}};
    省份数量_547 s = new 省份数量_547();
    s.findCircleNum(isConnected);
  }

  public int findCircleNum(int[][] isConnected) {
    final int len = isConnected.length;
    UF uf = new UF(len);
    for (int i = 0; i < len; i++) {
      for(int j = 0; j < i; j++) { // i = j时没有union的意义
        if(isConnected[i][j] == 1) uf.union(i, j);
      }
    }
    return uf.size;
  }

  class UF {
    int[] root;
    int size;

    public UF(int n) {
      this.root = new int[n];
      this.size = n + 1;
      for (int i = 0; i < n; i++) {
        root[i] = i;
      }
    }

    public void union(int p , int q) {
      int pr = findRoot(p);
      int qr = findRoot(q);
      if(pr != qr) {
        root[pr] = qr; // 这里应该把所有根为p 或者其他pr的改为qr  但是把路径压缩放到findRoot也行
        this.size --;
      }

    }

    public int findRoot(int r) { // 路径压缩  下次查找的时候把 真正的根节点赋值过来
      if(root[r] == r) return r;
      return root[r] = findRoot(root[r]);
    }
  }
}
