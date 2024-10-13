package com.fqh.contests.wk419;

import java.util.Arrays;

public class C {

    int[][][] dp;
    static final int MOD = (int) (1e9 + 7);
    int OFFSET = 0;
    char[] a;

    public int countWinningSequences(String s) {
        int n = s.length();
        a = s.toCharArray();
        OFFSET = n + 1;
        int m = 'W'-'A';
        dp = new int[n][n+OFFSET][m+1];
        for (int[][] arr : dp) {
            for (int[] row : arr) {
                Arrays.fill(row, -1);
            }
        }
        return dfs(0, 0, 'A');
    }

    public int dfs(int i, int v, char prev) {
        if (i >= a.length) return v > 0 ? 1 : 0;
        if (dp[i][v+OFFSET][prev-'A'] != -1) return dp[i][v+OFFSET][prev-'A'];
        int ret = 0;
        if (a[i] == 'F') {
            if (prev != 'E')  ret += dfs(i + 1, v - 1, 'E');  ret %= MOD;
            if (prev != 'F') ret += dfs(i + 1, v, 'F');           ret %= MOD;
            if (prev != 'W') ret += dfs(i + 1, v + 1, 'W');   ret %= MOD;
        } else if (a[i] == 'W') {
            if (prev != 'F') ret += dfs(i + 1, v - 1, 'F');    ret %= MOD;
            if (prev != 'W') ret += dfs(i + 1, v, 'W');            ret %= MOD;
            if (prev != 'E') ret += dfs(i + 1, v + 1, 'E');    ret %= MOD;
        } else {
            if (prev != 'W') ret += dfs(i + 1, v - 1, 'W');     ret %= MOD;
            if (prev != 'E') ret += dfs(i + 1, v, 'E');             ret %= MOD;
            if (prev != 'F') ret += dfs(i + 1, v + 1, 'F');     ret %= MOD;
        }
        dp[i][v+OFFSET][prev-'A'] = ret;
        return ret;
    }
}
