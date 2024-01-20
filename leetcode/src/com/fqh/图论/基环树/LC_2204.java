package com.fqh.图论.基环树;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/20 10:52
 **/
public class LC_2204 {

//    2204. 无向图中到环的距离
//            困难
//    相关标签
//            相关企业
//    提示
//    给定一个正整数 n，表示一个 连通无向图 中的节点数，该图 只包含一个 环。节点编号为 0 ~ n - 1(含)。
//
//    你还得到了一个二维整数数组 edges，其中 edges[i] = [node1i, node2i] 表示有一条 双向 边连接图中的 node1i 和 node2i。
//
//    两个节点 a 和 b 之间的距离定义为从 a 到 b 所需的 最小边数。
//
//    返回一个长度为 n 的整数数组 answer，其中 answer[i] 是第 i 个节点与环中任何节点之间的最小距离。

//    输入: n = 7, edges = [[1,2],[2,4],[4,3],[3,1],[0,1],[5,2],[6,5]]
//    输出: [1,0,0,0,0,1,2]
//    解释:
//    节点 1, 2, 3, 和 4 来自环。
//            0 到 1 的距离是 1。
//            1 到 1 的距离是 0。
//            2 到 2 的距离是 0。
//            3 到 3 的距离是 0。
//            4 到 4 的距离是 0。
//            5 到 2 的距离是 1。
//            6 到 2 的距离是 2。
    // 基环树（拓扑排序 + 多源BFS）
    public int[] distanceToCycle(int n, int[][] edges) {
        int[] rd = new int[n];
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            g[x].add(y);
            g[y].add(x);
            rd[x]++; rd[y]++;
        }
        topoSort(g, rd);
        // 多源BFS 从环上的点出发更新到其他节点的最短距离
        var dist = new int[n];
        var vis = new boolean[n];
        var q = new ArrayDeque<Integer>();
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
            if (rd[i] > 1) { // 环上的点
                q.offer(i);
                dist[i] = 0;
                vis[i] = true;
            }
        }
        while (!q.isEmpty()) {
            int x = q.poll();
            for (int y : g[x]) {
                if (vis[y]) continue;
                dist[y] = Math.min(dist[y], dist[x] + 1);
                q.offer(y);
                vis[y] = true;
            }
        }
        return dist;
    }

    private void topoSort(List<Integer>[] g, int[] rd) {
        var q = new ArrayDeque<Integer>();
        for (int i = 0; i < g.length; i++) {
            if (rd[i] == 1) q.offer(i);
        }
        while (!q.isEmpty()) {          // 用叶结点做拓扑排序，将挂在基树环上的点都标记入度为0
            int u = q.poll();
            for (int v : g[u]) {
                if (v != -1 && --rd[v] == 1) q.offer(v);
            }
        }
    }

    public static void main(String[] args) {
        int n = 7;
        int[][] edges = {{1,2},{2,4},{4,3},{3,1},{0,1},{5,2},{6,5}};
        System.out.println(Arrays.toString(new LC_2204().distanceToCycle(n, edges)));
    }
}
