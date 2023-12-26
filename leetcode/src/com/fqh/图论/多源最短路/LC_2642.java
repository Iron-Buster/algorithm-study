package com.fqh.图论.多源最短路;

import java.util.Arrays;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2023/12/26 17:47
 **/
public class LC_2642 {

    class Graph {

        long[][] dist;

        public Graph(int n, int[][] edges) {
            dist = new long[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(dist[i], Long.MAX_VALUE / 2);
                dist[i][i] = 0;
            }
            for (int[] edge : edges) {
                int from = edge[0];
                int to = edge[1];
                int w = edge[2];
                dist[from][to] = w;
            }
            floyd(dist);
        }

        public void addEdge(int[] edge) {
            int from = edge[0];
            int to = edge[1];
            int wt = edge[2];
            // 无法让任何最短路变短
            if (wt >= dist[from][to]) {
                return;
            }
            for (int i = 0; i < dist.length; i++) {
                for (int j = 0; j < dist.length; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][from] + wt + dist[to][j]);
                }
            }
        }

        public int shortestPath(int node1, int node2) {
            return dist[node1][node2] == Long.MAX_VALUE / 2 ? -1 : (int) dist[node1][node2];
        }

        public long[][] floyd(long[][] dist) {
            int n = dist.length;
            for (int k = 0; k < n; ++k) {
                for (int i = 0; i < n; ++i) {
                    for (int j = 0; j < n; ++j) {
                        // 不选 k，选 k
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
            return dist;
        }
    }


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
}
