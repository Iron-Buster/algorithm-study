package com.fqh.图论.单源最短路;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author: vq
 * @Date: 2023/12/18 11:07
 * @Version V1.0
 */
public class LC_1514 {


//    1514. 概率最大的路径
//    第 197 场周赛
//            Q3
//1846
//    相关标签
//            相关企业
//    提示
//    给你一个由 n 个节点（下标从 0 开始）组成的无向加权图，该图由一个描述边的列表组成，其中 edges[i] = [a, b] 表示连接节点 a 和 b 的一条无向边，且该边遍历成功的概率为 succProb[i] 。
//
//    指定两个节点分别作为起点 start 和终点 end ，请你找出从起点到终点成功概率最大的路径，并返回其成功概率。
//
//    如果不存在从 start 到 end 的路径，请 返回 0 。只要答案与标准答案的误差不超过 1e-5 ，就会被视作正确答案



    // dijk求最长路
    // 经典Dijsktra可在全负权边图中跑最长路、全正权边图中跑最短路
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        g = new List[n];
        vis = new boolean[n];
        dist = new double[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double w = succProb[i];
            g[u].add(new Edge(v, w));
            g[v].add(new Edge(u, w));
        }
        return dijkstra(start_node, end_node);
    }

    double[] dist;
    List<Edge>[] g;
    boolean[] vis;

    class Edge {
        int v;
        double w;

        Edge(int v, double w) {
            this.v = v;
            this.w = w;
        }
    }

    double dijkstra(int start, int end) {
        var pq = new PriorityQueue<Edge>((a, b) -> Double.compare(a.w, b.w));
        pq.offer(new Edge(start, -1));
        dist[start] = 1;
        while (!pq.isEmpty()) {
            var p = pq.poll();
            int u = p.v;
            double w = p.w;
            w *= -1;
            if (u == end) {
                return w;
            }
            vis[u] = true;
            for (Edge next : g[u]) {
                int v = next.v;
                double next_w = next.w;
                if (!vis[v] && dist[v] < dist[u] * next_w) {
                    dist[v] = dist[u] * next_w;
                    pq.offer(new Edge(v, -dist[v]));
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0,1},{1,2},{0,2}};
        double[] succProb = {0.5,0.5,0.2};
        int start = 0, end = 2;
        System.out.println(new LC_1514().maxProbability(n, edges, succProb, start, end));
    }
}
