package com.fqh.hot100;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/2 12:19
 **/
public class MaximumProductSubarray {

    //https://leetcode.cn/problems/maximum-product-subarray/description/?envType=study-plan-v2&envId=top-100-liked

    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[][] f = new int[n][2];
        f[0][0] = f[0][1] = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            f[i][0] = Math.max(nums[i], Math.max(f[i-1][0] * nums[i], f[i-1][1] * nums[i]));
            f[i][1] = Math.min(nums[i], Math.min(f[i-1][0] * nums[i], f[i-1][1] * nums[i]));
            ans = Math.max(ans, f[i][0]);
        }
        return ans;
    }
}
