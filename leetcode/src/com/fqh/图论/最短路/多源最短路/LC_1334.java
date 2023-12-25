package com.fqh.图论.最短路.多源最短路;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author: vq
 * @Date: 2023/12/12 12:12
 * @Version V1.0
 */
public class LC_1334 {

//    1334. 阈值距离内邻居最少的城市
//    第 173 场周赛
//            Q3
//    1855
//    相关标签
//            相关企业
//    提示
//    有 n 个城市，按从 0 到 n-1 编号。给你一个边数组 edges，
//    其中 edges[i] = [fromi, toi, weighti] 代表 fromi 和 toi 两个城市之间的双向加权边，距离阈值是一个整数 distanceThreshold。
//
//    返回能通过某些路径到达其他城市数目最少、且路径距离 最大 为 distanceThreshold 的城市。如果有多个这样的城市，则返回编号最大的城市。
//
//    注意，连接城市 i 和 j 的路径的距离等于沿该路径的所有边的权重之和。
public int findTheCity(int n, int[][] edges, int distanceThreshold) {
    long[][] dist = new long[n][n];
    for (int i = 0; i < n; i++) {
        Arrays.fill(dist[i], Long.MAX_VALUE / 2);
        dist[i][i] = 0;
    }
    for (int[] edge : edges) {
        int u = edge[0];
        int v = edge[1];
        int w = edge[2];
        dist[u][v] = w;
        dist[v][u] = w;
    }
    floyd(dist);
    int ans = -1;
    int minCnt = n + 1;
    for (int i = 0; i < n; i++) {
        int cnt = 0;
        for (int j = 0; j < n; j++) {
            if (i == j) continue;
            if (dist[i][j] <= distanceThreshold) {
                cnt++;
            }
        }
        if (cnt <= minCnt) {
            minCnt = cnt;
            ans = i;
        }
    }
    return ans;
}
    static long[][] floyd(long[][] dist) {
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
