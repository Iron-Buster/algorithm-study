package com.fqh.动态规划.LIS;

public class LC_1671 {

    // https://leetcode.cn/problems/minimum-number-of-removals-to-make-mountain-array/description/
    public int minimumMountainRemovals(int[] nums) {
        // 枚举nums[i]是山顶元素、
        // 那么分别计算出 nums[i]前面的递增子序列长度lmx 和 nums[i]后面的递减子序列长度rmx
        // 以nums[i]为山顶元素的最少删除次数 = n - lmx - rmx + 1
        int n = nums.length;
        // 递增的
        int[] dp1 = new int[n];
        for (int i = 0; i < nums.length; i++) {
            dp1[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp1[i] = Math.max(dp1[i], dp1[j] + 1);
                }
            }
        }
        // 递减的
        int[] dp2 = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            dp2[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (nums[i] > nums[j]) {
                    dp2[i] = Math.max(dp2[i], dp2[j] + 1);
                }
            }
        }
        int ans = n + 1;
        for (int i = 1; i < n - 1; i++) {
            int lmx = dp1[i];
            int rmx = dp2[i];
            if (lmx == 1 || rmx == 1) continue;
            ans = Math.min(ans, n - lmx - rmx + 1);
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] nums = {100,92,89,77,74,66,64,66,64};
        System.out.println(new LC_1671().minimumMountainRemovals(nums));
    }
}
