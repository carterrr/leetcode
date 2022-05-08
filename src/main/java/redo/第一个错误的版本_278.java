/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 1, r = n;
        while(l < r) {
            int mid = l + ((r - l) >> 1);
            if(isBadVersion(mid)) {
                r = mid;
            } else {
                l = mid + 1; // 从左往右找第一个  因此 分区间为 l - mid + 1  mid - r
            }
        }
        return l;
    }
}