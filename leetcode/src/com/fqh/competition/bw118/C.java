package com.fqh.competition.bw118;

import javax.swing.text.MaskFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: vq
 * @Date: 2023/11/25 20:11
 * @Version V1.0
 */
public class C {
    Integer[] dp;
    int[] p;

    public int minimumCoins(int[] prices) {
        int n = prices.length;
        dp = new Integer[1001];
        p = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            p[i + 1] = prices[i];
        }
        return dfs(1);
    }

    int dfs(int i) {
        if (i >= p.length) return 0;
        if (dp[i] != null) return dp[i];
        int cost = p[i];
        int ans = Integer.MAX_VALUE;
        for (int j = i + 1; j <= i * 2 + 1; ++j) {
            ans = Math.min(ans, dfs(j));
        }
        dp[i] = ans + cost;
        return dp[i];
    }


    public static void main(String[] args) {
        System.out.println(new C().minimumCoins(new int[]{26,18,6,12,49,7,45,45}));
    }
}
