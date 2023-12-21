package com.fqh.滑动窗口.不定长滑动窗口.求最短最小;

/**
 * @Author: vq
 * @Date: 2023/12/20 18:19
 * @Version V1.0
 */
public class LC_209 {

//209. 长度最小的子数组
//            已解答
//    中等
//            相关标签
//    相关企业
//    给定一个含有 n 个正整数的数组和一个正整数 target 。
//
//    找出该数组中满足其总和大于等于 target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。

    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int sum = 0, j = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                ans = Math.min(ans, i - j + 1);
                sum -= nums[j];
                j++;
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
