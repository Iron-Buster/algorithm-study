package com.fqh.动态规划.划分型DP;

import java.util.Arrays;

public class LC_2547 {

    // https://leetcode.cn/problems/minimum-cost-to-split-an-array/description/

    int[] dp;
    int[][] cost;

    public int minCost(int[] nums, int k) {
        int n = nums.length;
        int mx = Arrays.stream(nums).max().getAsInt();
        dp = new int[n];
        cost = new int[n][n];
        Arrays.fill(dp, -1);
        // 预处理出区间的trimmed.length
        for (int i = 0; i < n; i++) {
            int[] map = new int[mx+1];
            int cnt = 0;
            for (int j = i; j < n; j++) {
                map[nums[j]]++;
                if (map[nums[j]] == 2) cnt += 2;
                else if (map[nums[j]] > 2) cnt++;
                cost[i][j] = cnt;
            }
        }
        return dfs(0, nums, k);
    }

    int dfs(int i, int[] nums, int k) {
        if (i >= nums.length) return 0;
        if (dp[i] != -1) return dp[i];
        int ans = Integer.MAX_VALUE / 2;
        for (int j = i; j < nums.length; j++) {
            ans = Math.min(ans, dfs(j + 1, nums, k) + k + cost[i][j]);
        }
        return dp[i] = ans;
    }

}
