package com.fqh.contests.bw128;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/4/14 10:25
 **/
public class C {

    class Edge {
        int v;
        long w;
        int t;

        Edge(int v, long w, int t) {
            this.v = v;
            this.w = w;
            this.t = t;
        }

        Edge(int v, long w) {
            this.v = v;
            this.w = w;
        }
    }

    long[] dist;
    boolean[] vis;
    List<Edge>[] g;
    final Long INF = Long.MAX_VALUE;

    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        g = new ArrayList[n + 1];
        dist = new long[n + 1];
        vis = new boolean[n + 1];

        Arrays.setAll(g, v -> new ArrayList<>());

        for (int i = 0; i < n + 1; i++) {
            g[i] = new ArrayList<>();
            dist[i] = INF;
        }

        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            g[u].add(new Edge(v, w));
            g[v].add(new Edge(u, w));
        }
        dijkstra(0, n - 1, disappear);
        // System.out.println(Arrays.toString(dist));
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if (dist[i] == INF) {
                ans[i] = -1;
            } else {
                ans[i] = (int) dist[i];
            }
        }
        return ans;
    }

    boolean dijkstra(int start, int end, int[] disappear) {
        var pq = new PriorityQueue<Edge>((a, b) -> Long.compare(a.w, b.w));
        pq.offer(new Edge(start, 0, 0));
        dist[start] = 0;
        while (!pq.isEmpty()) {
            var p = pq.poll();
            int u = p.v;
            int t = p.t;

            if (vis[u]) continue;
            vis[u] = true;
            for (Edge next : g[u]) {
                int v = next.v;
                long w = next.w;
                if (t + w >= disappear[v]) continue;
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.offer(new Edge(v, dist[v], (int) (t + w)));
                }
            }
        }
        return false;
    }
}
