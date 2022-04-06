package redo;

import java.util.Arrays;

public class 字符串的最短距离_821 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.shortestToChar( "aaba",'b'));
    }
    private static class Solution {
        public int[] shortestToChar(String s, char c) {
            char[] array = s.toCharArray();
            int len = s.length();
            int[] res = new int[len];
            Arrays.fill(res, len);
            int idx_c = -1;
            for(int i = 0; i < len ; i++) {
                if(array[i] == c) {
                    idx_c = i;
                    res[i] = 0;
                    continue;
                }
                if(idx_c != -1) {
                    res[i] = i - idx_c;
                }
            }
            for(int i = len - 1; i >= 0 ; i--) {
                if(array[i] == c) {
                    idx_c = i;
                    continue;
                }
                if(idx_c > i) {
                    res[i] = Math.min(res[i], idx_c - i);
                }

            }
            return res;
        }
    }
}


