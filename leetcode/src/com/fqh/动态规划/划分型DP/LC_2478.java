package com.fqh.动态规划.划分型DP;

import java.util.Arrays;

public class LC_2478 {


    // https://leetcode.cn/problems/number-of-beautiful-partitions/description/
    int[][] dp;
    public int beautifulPartitions(String s, int k, int minLength) {
        int n = s.length();
        dp = new int[n][k+1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return dfs(0, k, minLength, s);
    }


    int dfs(int i, int k, int minL, String s) {
        if (i >= s.length()) return k == 0 ? 1 : 0;
        if (k < 0) return 0;
        if (dp[i][k] != -1) return dp[i][k];
        int ans = 0;
        int first = s.charAt(i) - '0';
        if (!isPrime(first)) return 0;
        for (int j = i; j < s.length(); j++) {
            if (j - i + 1 < minL) continue;
            int last = s.charAt(j) - '0';
            if (!isPrime(last)) {
                ans += dfs(j + 1, k - 1, minL, s);
                ans %= 1000000007;
            }
        }
        return dp[i][k] = ans;
    }

    boolean isPrime(int x) {
        return x == 2 || x == 3 || x == 5 || x == 7;
    }
}
