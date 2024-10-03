package com.fqh.图论.图DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/4/9 22:04
 **/
public class LC_1928 {

//    https://leetcode.cn/problems/minimum-cost-to-reach-destination-in-time/description/


//    带限制的单源最短路径问题
//    这类题一般是 dijkstra 模板 + memo 控制再入堆的条件：
//    如果还没看过这个点，或者当前的限制条件比之前更优，则加入堆
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n = passingFees.length;
        List<int[]>[] g = new List[n];
        Arrays.setAll(g, v -> new ArrayList<>());
        for (int[] e : edges) {
            int u = e[0], v = e[1], wt = e[2];
            g[u].add(new int[]{v, wt});
            g[v].add(new int[]{u, wt});
        }
        int[][] dist = new int[n][maxTime+1];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        var pq = new PriorityQueue<int[]>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{0, 0, passingFees[0]});
        dist[0][0] = passingFees[0];
        while (!pq.isEmpty()) {
            var p = pq.poll();
            int u = p[0], wt = p[1], cost = p[2];
            if (u == n - 1) {
                return cost;
            }
            for (int[] next : g[u]) {
                int v = next[0], wt1 = next[1], cost1 = passingFees[v];
                if (wt + wt1 > maxTime) continue;
                if (dist[v][wt+wt1] > cost + cost1) {
                    dist[v][wt+wt1] = cost + cost1;
                    pq.offer(new int[]{v, wt + wt1, cost + cost1});
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= maxTime; i++) {
            ans = Math.min(ans, dist[n-1][i]);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
