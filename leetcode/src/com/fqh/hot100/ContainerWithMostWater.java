package com.fqh.hot100;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/2 11:59
 **/
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int ans = 0;
        while (i < j) {
            ans = Math.min(ans, Math.min(height[i], height[j]) * (j - i));
            if (height[i] > height[j]) j--;
            else i++;
        }
        return ans;
    }
}
