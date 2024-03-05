package com.fqh.图论.单源最短路;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/5 09:58
 **/
public class LC_1976 {

//    1976. 到达目的地的方案数
//            已解答
//    第 59 场双周赛
//            Q3
//    2095
//    相关标签
//            相关企业
//    提示
//    你在一个城市里，城市由 n 个路口组成，路口编号为 0 到 n - 1 ，某些路口之间有 双向 道路。输入保证你可以从任意路口出发到达其他任意路口，且任意两个路口之间最多有一条路。
//
//    给你一个整数 n 和二维整数数组 roads ，其中 roads[i] = [ui, vi, timei] 表示在路口 ui 和 vi 之间有一条需要花费 timei 时间才能通过的道路。你想知道花费 最少时间 从路口 0 出发到达路口 n - 1 的方案数。
//
//    请返回花费 最少时间 到达目的地的 路径数目 。由于答案可能很大，将结果对 109 + 7 取余 后返回。


    static final int MOD = (int) (1e9 + 7);
    long[] dist;
    boolean[] vis;
    List<Edge>[] g;
    int[] f;
    // 最短路计数
    public int countPaths(int n, int[][] roads) {
        dist = new long[n];
        vis = new boolean[n];
        g = new List[n];
        f = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = Long.MAX_VALUE;
            g[i] = new ArrayList<>();
        }
        for (int[] road : roads) {
            int x = road[0], y = road[1], wt = road[2];
            g[x].add(new Edge(y, wt));
            g[y].add(new Edge(x, wt));
        }
        dijkstra(0, n-1);
        return f[n-1];
    }

    boolean dijkstra(int start, int end) {
        var pq = new PriorityQueue<Edge>((a, b) -> Long.compare(a.w, b.w));
        pq.offer(new Edge(start, 0));
        dist[start] = 0;
        f[0] = 1;
        while (!pq.isEmpty()) {
            var p = pq.poll();
            int u = p.v;
            if (u == end) {
                return true;
            }
            if (vis[u]) continue;
            vis[u] = true;
            for (Edge next : g[u]) {
                int v = next.v;
                long w = next.w;
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    f[v] = f[u]; // 到v的最短路个数与u相同
                    pq.offer(new Edge(v, dist[v]));
                } else if (dist[u] + w == dist[v]) {
                    f[v] = (f[v] + f[u]) % MOD;
                }
            }
        }
        return false;
    }

    class Edge {
        int v;
        long w;

        Edge(int v, long w) {
            this.v = v;
            this.w = w;
        }
    }


    //[[0,4,2],[4,1,5],[5,4,2],[2,5,3],[1,3,2],[4,6,2],[3,9,1],[8,6,5],[2,7,5],[2,6,2],[4,7,5],[6,1,2]]
    public static void main(String[] args) {
        int[][] roads = {{0,4,2},{4,1,5},{5,4,2},{2,5,3},{1,3,2},{4,6,2},{3,9,1},{8,6,5},{2,7,5},{2,6,2},{4,7,5},{6,1,2}};
        int n = 10;
        System.out.println(new LC_1976().countPaths(n, roads));
    }
}
