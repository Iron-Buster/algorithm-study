package com.fqh.图论.最短路;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author: vq
 * @Date: 2023/12/12 14:03
 * @Version V1.0
 */
public class LC_2642 {

//    2642. 设计可以求最短路径的图类
//            已解答
//    第 102 场双周赛
//            Q4
//1811
//    相关标签
//            相关企业
//    提示
//    给你一个有 n 个节点的 有向带权 图，节点编号为 0 到 n - 1 。图中的初始边用数组 edges 表示，其中 edges[i] = [fromi, toi, edgeCosti] 表示从 fromi 到 toi 有一条代价为 edgeCosti 的边。
//
//    请你实现一个 Graph 类：
//
//    Graph(int n, int[][] edges) 初始化图有 n 个节点，并输入初始边。
//    addEdge(int[] edge) 向边集中添加一条边，其中 edge = [from, to, edgeCost] 。数据保证添加这条边之前对应的两个节点之间没有有向边。
//    int shortestPath(int node1, int node2) 返回从节点 node1 到 node2 的路径 最小 代价。如果路径不存在，返回 -1 。一条路径的代价是路径中所有边代价之和。


    class Graph {

        public Graph(int n, int[][] edges) {
            dist = new long[n + 1];
            vis = new boolean[n + 1];
            g = new List[n + 1];
            Arrays.setAll(g, v -> new ArrayList<>());
            for (int[] edge : edges) {
                int u = edge[0], v = edge[1];
                long w = edge[2];
                g[u].add(new Edge(v, w));
            }
        }

        public void addEdge(int[] edge) {
            g[edge[0]].add(new Edge(edge[1], edge[2]));
        }

        public int shortestPath(int node1, int node2) {
            Arrays.fill(dist, Long.MAX_VALUE);
            Arrays.fill(vis, false);
            return dijkstra(node1, node2) ? (int) dist[node2] : -1;
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
                if (u == end) return true;
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
    }
}
