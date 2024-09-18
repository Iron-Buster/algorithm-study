package com.fqh.动态规划;

import java.util.Arrays;

public class LC_3290 {

    //https://leetcode.cn/problems/maximum-multiplication-score/


    int n;
    long[][] dp;

    long dfs(int i, int j, int[] b, int[] a) {
        if (j >= 4) return 0;
        if (i >= n) return Long.MIN_VALUE / 2;
        if (dp[i][j] != Long.MIN_VALUE) return dp[i][j];
        long x = dfs(i + 1, j + 1, b, a) + (long) b[i] * a[j];
        long y = dfs(i + 1, j, b, a);
        return dp[i][j] = Math.max(x, y);
    }

    public long maxScore(int[] a, int[] b) {
        n = b.length;
        dp = new long[n][4];
        for (long[] row : dp) {
            Arrays.fill(row, Long.MIN_VALUE);
        }
        return dfs(0, 0, b, a);
    }
}
