package redo;

import java.util.HashMap;
import java.util.Map;

public class 无重复字符的最长字串_3 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.lengthOfLongestSubstring("tmmzuxt");
    }

    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            char[] arr = s.toCharArray();
            int l = 0, r = 0, slen = arr.length, max = 1;
            Map<Character, Integer> map= new HashMap<>(); // 保存字母的最大下标
            while(r < slen ) {
                Integer l1 = map.get(arr[r]);
                if(l1 != null) {
                    l = l < l1 + 1 ? l1 + 1 : l; // 修正窗口左边界为当前左边界和已知元素位置右边位置的最大值
                }
                map.put(arr[r], r); // 覆盖该元素
                max = Math.max(max, r - l + 1);
                r ++;
            }
            return max;
        }
    }
}
