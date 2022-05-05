package redo;

public class 满足三条件之一需改变的最少字符数_1737 {
    public int minCharacters(String a, String b) {
        int la = a.length();
        int lb = b.length();
        int[] ca = new int[26],  // 字符计数
              cb = new int[26],
              psa = new int[26], // 前缀计数
              psb = new int[26];
        for (char c : a.toCharArray()) {
            ca[c - 'a'] ++;
        }
        for (char c : b.toCharArray()) {
            cb[c - 'a'] ++;
        }

        for (int i = 0; i < 26; i++) {
            psa[i] = i == 0 ? ca[0] : psa[i - 1] + ca[i];
            psb[i] = i == 0 ? cb[0] : psb[i - 1] + cb[i];
        }
        int res = la + lb; // 最大结果

        for (int i = 0; i < 25; i++) {
            // a 中所有小于等于 'a' + i 的 改成 'a' + i + 1 b中 所有大于'a' + i 的改成'a' + i
            res = Math.min(res, psa[i] + lb - psb[i]);
            // b 中所有小于等于 'a' + i 的 改成 'a' + i + 1 a中 所有大于'a' + i 的改成'a' + i
            res = Math.min(res, psb[i] + la - psa[i]);

            res = Math.min(res, la - ca[i] + lb - cb[i]);
        }

        res = Math.min(res, la - ca[25] + lb - cb[25]); // 没有比字母z大的  只能全改成字母z

        return res;
    }

    public static void main(String[] args) {
        满足三条件之一需改变的最少字符数_1737 s = new 满足三条件之一需改变的最少字符数_1737();
        s.minCharacters("acac",
                "bd");
    }
}
