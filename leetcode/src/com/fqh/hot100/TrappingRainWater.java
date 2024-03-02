package com.fqh.hot100;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/2 12:06
 **/
public class TrappingRainWater {

    public int trap(int[] height) {
        int mx = 0, idx = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > mx) {
                mx = height[i];
                idx = i;
            }
        }
        int i = 0, j = height.length - 1;
        int lmx = 0, rmx = 0, ans = 0;
        while (i < idx) {
            if (height[i] > lmx) lmx = height[i];
            else ans += lmx - height[i];
            i++;
        }
        while (j > idx) {
            if (height[j] > rmx) rmx = height[j];
            else ans += rmx - height[j];
            j--;
        }
        return ans;
    }
}
