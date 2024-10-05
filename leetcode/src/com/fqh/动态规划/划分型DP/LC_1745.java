package com.fqh.动态规划.划分型DP;

public class LC_1745 {

    // https://leetcode.cn/problems/palindrome-partitioning-iv/description/

    boolean[][] ok;
    Boolean[][] dp;

    // 预处理回文 + 划分型DP
    public boolean checkPartitioning(String s) {
        int n = s.length();
        dp = new Boolean[n][4];
        // 预处理出任意s[i:j]是否是回文串
        ok = new boolean[n][n];
        for (int i = 0; i < 2 * n - 1; i++) {
            int l = i / 2;
            int r = i / 2 + i % 2;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                ok[l][r] = true;
                l--;
                r++;
            }
        }
        return dfs(0, 3, s);
    }

    boolean dfs(int i, int k, String s) {
        if (i >= s.length()) return k == 0;
        if (k == 0) return false;
        if (dp[i][k] != null) return dp[i][k];
        boolean res = false;
        for (int j = i; j < s.length(); j++) {
            if (ok[i][j]) {
                res |= dfs(j + 1, k - 1, s);
            }
        }
        return dp[i][k] = res;
    }

    public static void main(String[] args) {
        System.out.println(new LC_1745().checkPartitioning("abcbdd"));
    }
}
