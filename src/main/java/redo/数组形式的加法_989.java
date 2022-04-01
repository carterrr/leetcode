package redo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 数组形式的加法_989 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] num = new int[]{0};
        List<Integer> integers = solution.addToArrayForm(num, 10000);
        integers.forEach(System.out::println);
    }
}
class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> res = new ArrayList<>();
        int i = num.length - 1; // num下标
        k += num[i];  // 个位先加
        while( i > 0 ) { // num没加完或者加完了 剩下两位数
            res.add(k % 10);
            k /= 10;
            k += num[--i] ;
        }
        // 加完余数可能很大很大  如 [0]  10000 这种
        while( k / 10 > 0) {
            res.add(k % 10);
            k /= 10;
        }
        if(k > 0) {
            res.add(k);
        }
        Collections.reverse(res);
        // 反转res
        return res;
    }
}