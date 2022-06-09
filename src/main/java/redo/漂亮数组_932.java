class Solution {
    public int[] beautifulArray(int n) {
        // 奇数 + 偶数 = 奇数  不可能等于偶数 因此 把n分为 前半部分奇数  后半部分偶数  奇数部分 = n+1)/2 部分的奇数 * 2 -1 推导得到  偶数部分 n/2 部分 * 2 得到  奇数部分 偶数部分都是漂亮数组  正向计算  会算一堆无关数据  可以考虑反向递归
        Map<Integer, int[]> map = new HashMap<>();
        map.put(1, new int[]{1});
        
        for(int i = 2; i <= n; i++) {
            int[] tmp = new int[i];
            int[] left = map.get((i + 1)/2);
            int[] right = map.get(i / 2);
            int j = 0;
            for(int l : left) {
                tmp[j++] = l * 2 - 1;
            }
            for(int r : right) {
                tmp[j++] = r * 2; 
            }
            map.put(i, tmp);
        }
        return map.get(n);
    }
}