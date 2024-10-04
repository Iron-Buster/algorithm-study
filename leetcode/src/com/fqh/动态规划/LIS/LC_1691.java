package com.fqh.动态规划.LIS;

import java.util.Arrays;

public class LC_1691 {

    // https://leetcode.cn/problems/maximum-height-by-stacking-cuboids/description/
    public int maxHeight(int[][] cuboids) {
        int n = cuboids.length;
        for (int[] c : cuboids) Arrays.sort(c);
        Arrays.sort(cuboids, (a, b) -> a[0] != b[0] ? a[0] - b[0] : (a[1] != b[1] ? a[1] - b[1] : a[2] - b[2]));
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (cuboids[i][1] >= cuboids[j][1] && cuboids[i][2] >= cuboids[j][2]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i] += cuboids[i][2];
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
