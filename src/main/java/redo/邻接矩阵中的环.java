import java.util.*;


// 给一个二维数组表示的邻接矩阵  及 一个点  请找出包含这个点最短的环
/* 例如 graph = [
    [1],
    [2],
    [4],
    [],
    [0]
]
target = 3
*/
class Solution {
    
    public int solve(int[][] graph, int target) {
       // from target,find next until target by bfs
        // save the steps, return steps first if find the target  or return -1 at the end 
        // step incr in every round
       
        int step = 0;
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.offer(target);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++) {
                Integer cur = q.poll();
                for(int c : graph[cur]) {
                    if(c == target) {
                        return step +1 ;
                    }
                    if(!visited.contains(c)) { // 没访问过就加入下次访问集合 访问过说明之前已经找了这个点的后继  路径肯定比现在再访问短
                        q.offer(c);
                        visited.add(c);
                    }
            }
            }
            
            step ++; // 一个size 才加一次
        }
        return -1;
    }
}