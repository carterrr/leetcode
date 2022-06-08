package redo;

public class x的平方根_69 {
    // 二分法求小于等于的最大整数
    public int mySqrt(int x) {
        int l = 0, r = x;
        while (l < r) {
            // int mid = l + ((r - l) >> 1);
            int mid = l + ((r - l + 1) >> 1); // 但是避免这里r 为 Integer.MAX_VALUE + 1溢出  l 初始值不能等于0 应该为1
            if(mid > x / mid) {  // 注意乘法  加法导致的数据溢出
                r = mid - 1;
            } else {
                // 尤其注意  l = mid 这样会出现死循环
                // 但是如题意这种取小于等于的  必须写成l = mid的
                // 将mid应该向上取整   写成 int mid = l + ((r - l + l)>>1)
                // mid 最后缩小为 r -l = 2 或 1 时 最终都为l + 1
                l = mid;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        x的平方根_69 x = new x的平方根_69();
        x.mySqrt(2147483647);
    }
}
