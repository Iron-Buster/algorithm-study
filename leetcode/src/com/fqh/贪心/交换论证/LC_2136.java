package com.fqh.贪心.交换论证;

import java.util.Arrays;

public class LC_2136 {

    //https://leetcode.cn/problems/earliest-possible-day-of-full-bloom/description/

    public int earliestFullBloom(int[] p, int[] g) {
        int n = p.length;
        int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = p[i];
            a[i][1] = g[i];
        }
        // i, j
        // A: p[i] + g[i], B: p[j] + g[j]
        // 假设 A < B 先种A
        // 满足 p[i] + max(g[i], p[j] + g[j]) < p[j] + max(g[j], p[i] + g[i])

        Arrays.sort(a, (x, y) -> {
            int v1 = x[0] + Math.max(y[0] + y[1], x[1]);
            int v2 = y[0] + Math.max(x[0] + x[1], y[1]);
            return v1 - v2;
        });
        int ans = 0;
        int d = 0;
        for (int i = 0; i < n; i++) {
            d += a[i][0];
            ans = Math.max(ans, d + a[i][1]);
        }
        return ans;
    }
}
