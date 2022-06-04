class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0; // 双指针  贪心匹配
        for(int i = 0,j = 0; i < g.length && j < s.length; j++) { // 下一个饼干试下当前孩子合不合胃口 孩子合胃口了孩子才动  饼干一直后移
            if(g[i] <= s[j]) {
                res ++;
                i ++;
            } 

        }
        return res;
    }
}