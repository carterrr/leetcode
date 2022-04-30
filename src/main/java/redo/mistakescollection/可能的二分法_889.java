


public class  可能的二分法_889{
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[][] graph = new int[n+1][n+1]; // 邻接矩阵初始化
        for (int[] dislike : dislikes) {
            graph[dislike[0]][dislike[1]] = 1;  // 无向图是  a - > b 1  b -> a 1 
            graph[dislike[1]][dislike[0]] = 1;
        }
        int[] color = new int[n + 1]; // -1  1 表示两种颜色  0表示未被染色
        for (int i = 1; i <= n; i++) {
            if(color[i] == 0) { // 未被染色过  就 dfs一次  每次彻底的dfs之后  剩下的和之前的不是一个联通分量的 第一个节点随便赋值1 还是  -1
                if(!dfs(graph, i, color)) return false;
            }
        }
        return true;
    }

    public boolean dfs(int[][] graph, int start, int[] color) {
        color[start] = color[start] == 0 ? 1 : color[start]; // 外层for中第一次进入  每次第一个值赋值是1  还是  -1 都不要紧 关键是一个联通分量里面交替染色不能有同色的
        // 这里的关键是将联通的节点交替染色   
        for (int i = 1; i < color.length; i++) {
            if(graph[start][i] == 1) {
                if(color[i] == color[start]) {
                    return false;   // dfs下去不能相同
                }
                if(color[i] == 0) {
                    color[i] = -1 * color[start];
                    if(!dfs(graph, i, color)) return false;
                }
            }
        }
        return true;
    }
}