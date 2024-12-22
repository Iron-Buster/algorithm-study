package com.fqh.动态规划;

import java.util.Arrays;

public class LC_3393 {

    // https://leetcode.cn/problems/count-paths-with-the-given-xor-value/description/
    long[][][] dp;
    public int countPathsWithXorValue(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new long[m][n][20];
        for (long[][] row : dp) {
            for (long[] r : row) {
                Arrays.fill(r, -1);
            }
        }
        long res = dfs(0, 0, grid[0][0], grid, k);
        return (int) res;
    }

    long dfs(int i, int j, int v, int[][] g, int k) {
        if (i == g.length - 1 && j == g[0].length - 1) {
            return v == k ? 1 : 0;
        }
        if (dp[i][j][v] != -1) return dp[i][j][v];
        long ans = 0;
        if (i + 1 < g.length) {
            ans += dfs(i + 1, j, v ^ g[i+1][j], g, k);
        }
        if (j + 1 < g[0].length) {
            ans += dfs(i, j + 1, v ^ g[i][j+1], g, k);
        }
        ans %= 1000000007;
        return dp[i][j][v] = ans;
    }

}
