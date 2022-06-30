package redo.mistakescollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 组合总和II_40 {
  class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> tmp = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
      Arrays.sort(candidates);
      bt(candidates, target, 0);
      return res;
    }

    private void bt(int[] candidates, int remain, int fromIdx) {
      if(remain == 0) {
        res.add(new ArrayList<>(tmp)); return;
      }

      if(remain < 0 || fromIdx  >= candidates.length) return;
      for(int i = fromIdx; i < candidates.length; i++) {
        // 关键  循环内部剪枝  重复的组合不能再次出现 应该被剪掉
        if(i > fromIdx && candidates[i] == candidates[i - 1]) continue; // 第一层进来 i == fromIdx 可以使用重复但不同位的数字， 其他层不允许  因为前面取过了
        tmp.add(candidates[i]);
        bt(candidates, remain - candidates[i], i + 1);
        tmp.remove(tmp.size() - 1);
      }
    }
  }
}
