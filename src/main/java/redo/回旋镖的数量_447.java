package redo;

import java.util.HashMap;
import java.util.Map;

public class 回旋镖的数量_447 {
    class Solution {
        public int numberOfBoomerangs(int[][] points) {
            Map<Integer, Integer> map = new HashMap<>();
            int res = 0;
            for(int i = 0; i < points.length; i++) {
                for(int j = 0; j <points.length; j++) {
                    if(i == j) continue;
                    int a = points[j][0] - points[i][0];
                    int b = points[j][1] - points[i][1];
                    int dist = b * b + a * a;
                    map.put(dist, map.getOrDefault(dist, 0) + 1);
                }
                for(Integer c : map.values()) {
                    if(c > 1) {
                        res += c * (c - 1); // Cn2 = n * (n - 1) / 2 这里就应该算是两种 因而去掉 / 2
                    }
                }
                map.clear();
            }
            return res;
        }
    }
}
