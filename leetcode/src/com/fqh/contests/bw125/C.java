package com.fqh.contests.bw125;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/3 12:16
 **/
public class C {

    List<int[]>[] g;

    public int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {
        int n = edges.length + 1;
        g = new List[n];
        Arrays.setAll(g, v -> new ArrayList<>());
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1], w = edge[2];
            g[x].add(new int[]{y, w});
            g[y].add(new int[]{x, w});
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int[] res = bfs(i, signalSpeed);
            int v = 0;
            for (int j = 0; j < res.length; j++) {
                for (int k = j + 1; k < res.length; k++) {
                    v += res[j] * res[k];
                }
            }
            ans[i] = v;
        }
        return ans;
    }
    int[] bfs(int start, int k) {
        List<int[]> ll = g[start];
        int[] res = new int[ll.size()];
        if (ll.size() == 1) return res;
        var q = new ArrayDeque<int[]>();
        int idx = 0;
        boolean[] vis = new boolean[g.length];
        vis[start] = true;
        for (int[] pp : ll) {
            q.offer(new int[]{pp[0], pp[1], idx});
            if (pp[1] % k == 0) res[idx]++;
            idx++;
            vis[pp[0]] = true;
        }
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int x = p[0], w = p[1], ii = p[2];
            for (int[] pp : g[x]) {
                if (!vis[pp[0]]) {
                    q.offer(new int[]{pp[0], w + pp[1], ii});
                    if ((w + pp[1]) % k == 0) {
                        res[ii]++;
                    }
                    vis[pp[0]] = true;
                }
            }
        }
        return res;
    }
}
