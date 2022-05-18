package redo;

import java.util.ArrayList;
import java.util.List;

class 找到字符串中所有字母异位词_438 {
     public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(),
                window = p.length(),
                r = 0, l = 0;
        int[] pc = new int[26];
        int[] sc = new int[26];
        char[] charsP = p.toCharArray();
        char[] charsS = s.toCharArray();
        List<Integer> res = new ArrayList<>();
        for (char c : charsP) {
            pc[c - 'a'] ++;
        }
        while (r < sLen) {
            int rChar = charsS[r] - 'a';
            sc[rChar]++;
            while (sc[rChar] > pc[rChar]) {
                sc[charsS[l++] - 'a'] --; // sc中 左边界对应的字符数量减一  最多减少到 r = l
            }
            if(r - l + 1== window) { // l到r刚好和p长度相等 而且窗口中对应字符数量和p都相等  那么就是异构词
                res.add(l);
            }
            r ++;
        }
        return res;
    }
}