package redo;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯几个要点
 * 1. 递归同时将fromIdx传到下一级中  用作for（int i = fromIdx; i < XXX; i++) 循环起点
 * 2. 递归中提前剪枝return
 * 3. 必要时使用remain 判断是否需要保存回溯结果
 */
public class 二进制手表_401 {
  final int[] hours = new int[]{1,2,4,8};
  final int[] mins = new int[]{1,2,4,8,16,32};

  public List<String> readBinaryWatch(int turnedOn) {
    List<String> res = new ArrayList<>();
    if(turnedOn >= 9) return res;
    backtrack(res, turnedOn, 0, 0, 0);
    return res;
  }

  private void backtrack(List<String> res, int remain, int fromIdx, int hour, int min) {
    if(hour > 11 || min > 59) return;
    if(remain == 0) {
      res.add(hour +  (min < 10 ? ":0" : ":" ) + min);
      return;
    }
    for (int i = fromIdx; i < 10; i ++) { // 分钟个数6 + 小时个数4 = 10 依次取  取到之后往后遍历  不满足条件的下一层进行剪枝
        if(i < 4) {
          backtrack(res, remain - 1, i + 1, hour + hours[i], min );
        } else {
          backtrack(res, remain - 1, i + 1, hour, min + mins[i - 4]);
        }
    }
  }

  public static void main(String[] args) {
  }
}
