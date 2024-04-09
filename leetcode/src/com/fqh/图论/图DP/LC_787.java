package com.fqh.图论.图DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/4/9 22:35
 **/
public class LC_787 {


//    https://leetcode.cn/problems/cheapest-flights-within-k-stops/description/

    List<int[]>[] g;
    long[][] dp;
    int dest;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        g = new List[n+1];
        dp = new long[n+1][k+2];
        dest = dst;
        Arrays.setAll(g, v -> new ArrayList<>());
        for (int[] f : flights) {
            int u = f[0], v = f[1], wt = f[2];
            g[u].add(new int[]{v, wt});
        }
        for(long[] d : dp) {
            Arrays.fill(d, -1L);
        }
        long ans = dfs(src, k);
        return ans == 0x3f3f3f3f ? -1 : (int) ans;
    }

    public long dfs(int cur, int k) {
        if (cur == dest) return 0;
        if (k < 0) return 0x3f3f3f3f;
        if (dp[cur][k] != -1) return dp[cur][k];
        long ans = 0x3f3f3f3f;
        for (int[] next : g[cur]) {
            int nxt = next[0], wt = next[1];
            ans = Math.min(ans, dfs(nxt, k - 1) + wt);
        }
        return dp[cur][k] = ans;
    }
}
