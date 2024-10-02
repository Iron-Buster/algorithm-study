package com.fqh.动态规划.背包DP;

import java.util.Arrays;

public class LC_879 {
    // https://leetcode.cn/problems/profitable-schemes/description/

    long[][][] dp;

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int m = group.length;
        dp = new long[m+1][n+1][minProfit+1];
        for (long[][] row : dp) {
            for(long[] r : row) {
                Arrays.fill(r, -1L);
            }
        }
        return (int) dfs(0, 0, 0, n, minProfit, group, profit);
    }
    // dp[i][cnt][p] 表示第完成第group，参与人数cnt，创造利润为p的方案数
    long dfs(int i, int cnt, int p, int n, int minP, int[] g, int[] profit) {
        if (cnt > n) return 0;
        if (i >= g.length) return p >= minP ? 1 : 0;
        if (dp[i][cnt][p] != -1) return dp[i][cnt][p];
        // 不选
        long a = dfs(i + 1, cnt, p, n, minP, g, profit);
        // 选，p给个min，不然会越界
        long b = dfs(i + 1, cnt + g[i], Math.min(p + profit[i], minP), n, minP, g, profit);
        long ans = (a + b) % 1000000007;
        return dp[i][cnt][p] = ans;
    }
}
