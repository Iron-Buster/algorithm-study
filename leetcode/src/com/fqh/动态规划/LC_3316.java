package com.fqh.动态规划;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC_3316 {

    char[] s;
    char[] p;
    Set<Integer> set = new HashSet<>();
    int[][] dp;

    public int maxRemovals(String source, String pattern, int[] targetIndices) {
        s = source.toCharArray();
        p = pattern.toCharArray();
        int m = s.length, n = p.length;
        dp = new int[m][n];
        for (int idx : targetIndices) {
            set.add(idx);
        }
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return dfs(0, 0);

    }

    int dfs(int i, int j) {
        if (i >= s.length) return j >= p.length ? 0 : Integer.MIN_VALUE;
        if (j >= p.length) return dfs(i + 1, j) + (set.contains(i) ? 1 : 0);
        if (dp[i][j] != -1) return dp[i][j];
        int res;
        if (s[i] == p[j]) {
            // 不删除
            res = dfs(i + 1, j + 1);
            // 删除
            if (set.contains(i)) {
                res = Math.max(res, dfs(i + 1, j) + 1);
            }
        } else {
            // 不删除
            res = dfs(i + 1, j);
            // 删除
            if (set.contains(i)) {
                res = Math.max(res, dfs(i + 1, j) + 1);
            }
        }
        return dp[i][j] = res;
    }
}
