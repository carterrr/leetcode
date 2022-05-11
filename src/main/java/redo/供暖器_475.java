package redo;

import java.util.Arrays;

public class 供暖器_475 {

    public static void main(String[] args) {
        供暖器_475 s = new 供暖器_475();
        s.findRadius(new int[]{1,2,3,4}, new int[]{4,1});
    }

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int minRadius = 0;
        for (int i = 0; i < houses.length; i++) {
            // find right heater
            int l = 0, r = heaters.length - 1;
            while(l < r) {
                int mid = l + ((r - l) >> 1);
                if(heaters[mid] < houses[i]) {  // 找到大于等于的第一个值
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }

            int minDist = 0;
            if(heaters[l] > houses[i]) {
                minDist = heaters[l] - houses[i];
                if(l > 0) minDist = Math.min(minDist, houses[i] - heaters[l - 1]);
            } else if(heaters[l] < houses[i]) { // 最大的加热器坐标没有房子坐标大
                minDist = houses[i] - heaters[l];
            }
            minRadius = Math.max(minRadius, minDist);
        }
        return minRadius;
    }
}
