package com.fqh.图论.单源最短路;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author: vq
 * @Date: 2023/12/11 21:50
 * @Version V1.0
 */
public class LC_743 {

//    743. 网络延迟时间
//            中等
//    相关标签
//            相关企业
//    提示
//    有 n 个网络节点，标记为 1 到 n。
//
//    给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， wi 是一个信号从源节点传递到目标节点的时间。
//
//    现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。


    public int networkDelayTime1(int[][] times, int n, int k) {
        List<int[]>[] g = new List[n + 1];
        Arrays.setAll(g, v -> new ArrayList<>());
        for (int[] t : times) {
            int u = t[0], v = t[1], w = t[2];
            g[u].add(new int[]{v, w});
        }
        int[] dist = new int[n + 1];
        dijkstra0(k, n, g, dist);
        int ans = Arrays.stream(dist).max().getAsInt();
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    /**
     * 堆优化dijkstra
     * @param start 起始节点
     * @param end   目的节点
     * @param g     图
     * @param dist  距离数组
     */
    static void dijkstra0(int start, int end, List<int[]>[] g, int[] dist) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        boolean[] vis = new boolean[g.length];
        pq.offer(new int[]{start, 0});
        dist[start] = 0;
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int u = p[0];
            if (u == end) return;
            if (vis[u]) continue;
            vis[u] = true;
            for (int[] next : g[u]) {
                int v = next[0], w = next[1];
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.offer(new int[]{v, dist[v]});
                }
            }
        }
    }


    // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    public int networkDelayTime(int[][] times, int n, int k) {
        g = new ArrayList[n + 1];
        dist = new long[n + 1];
        vis = new boolean[n + 1];
        for (int i = 1; i <= n; ++i) {
            g[i] = new ArrayList<>();
            dist[i] = 0x3f3f3f;
        }
        for (int[] t : times) {
            int u = t[0], v = t[1];
            long w = t[2];
            g[u].add(new Edge(v, w));
        }
        dijkstra(k, n);
        long ans = Arrays.stream(dist).max().getAsLong();
        return ans == 0x3f3f3f ? -1 : (int) ans;
    }

    long[] dist;
    boolean[] vis;
    List<Edge>[] g;

    class Edge {
        int v;
        long w;

        Edge(int v, long w) {
            this.v = v;
            this.w = w;
        }
    }

    boolean dijkstra(int start, int end) {
        var pq = new PriorityQueue<Edge>((a, b) -> Long.compare(a.w, b.w));
        pq.offer(new Edge(start, 0));
        dist[start] = 0;
        while (!pq.isEmpty()) {
            var p = pq.poll();
            int u = p.v;
            vis[u] = true;
            for (Edge next : g[u]) {
                int v = next.v;
                long w = next.w;
                if (!vis[v] && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.offer(new Edge(v, dist[v]));
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] times = {{1, 2, 1}};
        System.out.println(new LC_743().networkDelayTime(times, 2, 2));
    }
}
