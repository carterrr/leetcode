package redo.mistakescollection;

import java.util.*;

public class  项目管理_1203{
        /**
     * @param n    项目数量
     * @param m    小组数量
     * @param group 项目被承接
     * @param beforeItems  项目依赖关系
     * @return
     */
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        int idNext = m;
        List<List<Integer>> groupGraph = new ArrayList<>();//组间拓扑关系
        List<List<Integer>> inGroupGraph = new ArrayList<>();//组内拓扑关系
        List<Integer> groupId = new ArrayList<>();// 组id
        Map<Integer, List<Integer>> sameGroup = new HashMap<>();// 组id -> 组成员
        int id = m;
        for (int i = 0; i < group.length; i++) {
            if(group[i] == -1) group[i] = id++;
            sameGroup.getOrDefault(group[i], new ArrayList<>()).add(i);
        }
        for (int i = 0; i < n; i++) {
            groupId.add(i);
            inGroupGraph.add(new ArrayList<>()); // 组内 总共只有最多n个组需要考虑组内关系
            groupGraph.add(new ArrayList<>());
        }

        for (int i = n; i < n + m; i++) {
            groupGraph.add(new ArrayList<>());
            groupId.add(i);
        }
        int[] degInGroup = new int[n];
        int[] degOutGroup = new int[m + n];
        for (int i = 0; i < beforeItems.size(); i++) {
            int curGroupId = group[i];
            List<Integer> beforeItem = beforeItems.get(i);
            for (Integer bi : beforeItem) {
                if(group[bi] == curGroupId) {
                    degInGroup[i] ++;
                    inGroupGraph.get(bi).add(i);
                } else {
                    degOutGroup[i] ++;
                    groupGraph.get(group[bi]).add(curGroupId); 
                }
            }
        }
        
        List<Integer> outTop = topSort(degOutGroup, groupId, groupGraph); // 组间top排序
        if (outTop == null) return new int[0];
        int[] res = new int[n];
        int index = 0;
        for (Integer gid : outTop) {
            List<Integer> items = sameGroup.get(gid);
            if (items.size() == 0) continue;
            List<Integer> inTop = topSort(degInGroup, items, inGroupGraph);
            if(inTop == null) return new int[0];
            for (Integer i : inTop) {
                res[index ++] = i;
            }
        }
        return res;
    }

    public List<Integer> topSort(int[] indegree, List<Integer> items, List<List<Integer>> graph) {
        Queue<Integer> q = new LinkedList<>();
        for (Integer i : items) {
            if(indegree[i] == 0)
                q.offer(i);
        }
        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty()) {
            Integer poll = q.poll();
            res.add(poll);
            List<Integer> nexts = graph.get(poll);
            for (Integer n : nexts) {
                if(--indegree[n] == 0) {
                    q.offer(n);
                }
            }
        }
        return res.size() == indegree.length ? res : null;
    }

}