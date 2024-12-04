package com.fqh.contests.wk426;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C {


    // https://leetcode.cn/problems/maximize-the-number-of-target-nodes-after-connecting-trees-i/description/
    // 暴力枚举 + DFS
    List<Integer>[] g1;
    List<Integer>[] g2;

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length;
        int m = edges2.length;
        g1 = new List[n+1];
        g2 = new List[m+1];
        Arrays.setAll(g1, v -> new ArrayList<>());
        Arrays.setAll(g2, v -> new ArrayList<>());
        for (int[] edge : edges1) {
            int u = edge[0];
            int v = edge[1];
            g1[u].add(v);
            g1[v].add(u);
        }
        for (int[] edge : edges2) {
            int u = edge[0];
            int v = edge[1];
            g2[u].add(v);
            g2[v].add(u);
        }
        int mx2 = 0;
        for (int i = 0; i < m + 1; i++) {
            mx2 = Math.max(mx2, dfs(i, -1, 0, k - 1, g2));
        }
        int[] ans = new int[n+1];
        for (int i = 0; i <= n; i++) {
            ans[i] = dfs(i, -1, 0, k, g1) + mx2;
        }
        return ans;
    }


    int dfs(int x, int fa, int cnt, int k, List<Integer>[] g) {
        if (cnt > k) return 0;
        int ans = 1;
        for (int y : g[x]) {
            if (y == fa) continue;
            ans += dfs(y, x, cnt + 1, k, g);
        }
        return ans;
    }
}
