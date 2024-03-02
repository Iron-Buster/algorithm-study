package com.fqh.hot100;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/2 12:28
 **/
public class HouseRobber {

    //https://leetcode.cn/problems/house-robber/description/?envType=study-plan-v2&envId=top-100-liked

    public int rob(int[] nums) {
        int n = nums.length;
        int[] f = new int[n];
        f[0] = nums[0];
        if (n > 1) f[1] = Math.max(f[0], nums[1]);
        for (int i = 2; i < n; i++) {
            f[i] = Math.max(f[i-1], f[i-2] + nums[i]);
        }
        return f[n-1];
    }
}
