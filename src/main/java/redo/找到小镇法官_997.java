package redo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 找到小镇法官_997 {
    public int findJudge_(int n, int[][] trust) {
        Set<Integer> outDegree = new HashSet<>();  // 哪些人信任了其他人
        Map<Integer, Integer> inDegree = new HashMap<>();// 每个人被信任次数
        for(int[] i : trust) {
            outDegree.add(i[0]);
            inDegree.put(i[1], inDegree.getOrDefault(i[1], 0) + 1);
        }
        for (int i = 1 ; i < n + 1; i++) {
            if(!outDegree.contains(i)) { // 没信任其他人
                if(inDegree.getOrDefault(i, 0) == n - 1) return i; // 被信任次数为n-1  getOrDefault(i, 0) 是 防止 n = 1 trust = []这种情况
            }
        }
        return -1;
    }

    public int findJudge(int n, int[][] trust) {
        int[] vote = new int[n + 1]; // 将投票和未被投票信息合并成一个  被投票次数最多 n - 1 次   投票次数最少 0 次  和最大 n - 1
        for(int[] t : trust) {
            vote[t[0]] --;
            vote[t[1]] ++;
        }

        for (int i = 1; i < n + 1; i++) {
            if(vote[i] == n - 1) return i;
        }
        return -1;
    }
}
