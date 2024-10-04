package com.fqh.动态规划.LIS;

import java.util.Arrays;

public class LC_1626 {

    // https://leetcode.cn/problems/best-team-with-no-conflicts/description/

    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        if (n == 1) return scores[0];
        int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = ages[i];
            a[i][1] = scores[i];
        }
        Arrays.sort(a, (x, y) -> x[0] == y[0] ? x[1] - y[1] : x[0] - y[0]);
        int[] ans = new int[n];
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            ans[i] = Math.max(ans[i], a[i][1]);
            for (int j = 0; j < i; j++) {
                if (a[i][1] >= a[j][1]) {
                    ans[i] = Math.max(ans[i], ans[j] + a[i][1]);
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return Arrays.stream(ans).max().getAsInt();
    }
}
