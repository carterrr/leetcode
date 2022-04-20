package redo;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class 前k个高频元素_347 {

    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> frequencyMap = new HashMap<>();
            for(int num : nums) {
                frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            }
            PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> -a[1]));
            for(Map.Entry<Integer, Integer> e : frequencyMap.entrySet()) {
                q.offer(new int[]{e.getKey(), e.getValue()});
            }
            int[] res = new int[k];
            for (int i = 0; i < k; i++) {
                res[i] = q.poll()[0];
            }
            return res;
        }
    }
}
