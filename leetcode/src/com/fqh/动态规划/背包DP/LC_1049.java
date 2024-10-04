package com.fqh.动态规划.背包DP;

import java.util.Arrays;

public class LC_1049 {

    // https://leetcode.cn/problems/last-stone-weight-ii/description/

    // dp计算出一个接近于t的最小非负整数
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = Arrays.stream(stones).sum();
        int t = sum / 2;
        int[][] dp = new int[n+1][t+1];
        for (int i = 1; i <= n; i++) {
            int v = stones[i-1];
            for (int j = 0; j <= t; j++) {
                dp[i][j] = dp[i-1][j];
                if (j >= v) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-v] + v);
                }
            }
        }
        return sum - 2 * dp[n][t];
    }
}
