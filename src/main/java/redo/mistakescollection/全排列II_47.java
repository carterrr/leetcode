package redo.mistakescollection;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class 全排列II_47 {
  List<List<Integer>> res = new ArrayList<>();
  Deque<Integer> dq = new ArrayDeque<>(); // 最后一位添加删除最方便
  public List<List<Integer>> permuteUnique(int[] nums) {
    Arrays.sort(nums);
    bt(nums, new boolean[nums.length]);
    return res;
  }

  private void bt( int[] nums, boolean[] visited) {
    if(dq.size() == nums.length) {
      res.add(new ArrayList<>(dq));
      return ;
    }
    for (int i = 0; i < nums.length; i++) {
      if(visited[i]) continue; // 因为是全排列  可以先选后面在选前面  所以必须要用visited数组 而且下一轮一定从0再开始
      // !used[i - 1] 是因为   如果是本分支内第二个1  used[i - 1] = true  整体为false   不会跳过  因为   [1,1,2]  这种不可以剪掉
      //                       如果是第二个分支  已经有了  [1,1,2]
      //                                          现在用第二个1做第一个节点的时候  used[i - 1] 已经被上次for循环设为了 false  这种是需要跳过的
      if(i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) { // 相同前面一个一定会处理的
        continue;
      }
      visited[i] = true;
      dq.addLast(nums[i]);
      bt(nums, visited);
      dq.removeLast();
      visited[i] = false;
    }
  }
}
