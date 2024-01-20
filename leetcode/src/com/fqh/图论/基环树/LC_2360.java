package com.fqh.图论.基环树;

import java.util.ArrayDeque;
import java.util.List;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/20 11:17
 **/
public class LC_2360 {

//    2360. 图中的最长环
//            已解答
//    第 304 场周赛
//            Q4
//1897
//    相关标签
//            相关企业
//    提示
//    给你一个 n 个节点的 有向图 ，节点编号为 0 到 n - 1 ，其中每个节点 至多 有一条出边。
//
//    图用一个大小为 n 下标从 0 开始的数组 edges 表示，节点 i 到节点 edges[i] 之间有一条有向边。如果节点 i 没有出边，那么 edges[i] == -1 。
//
//    请你返回图中的 最长 环，如果没有任何环，请返回 -1 。
//
//    一个环指的是起点和终点是 同一个 节点的路径。

    // 内向基环树
    // 1.拓扑排序将环分离出来
    // 2.然后再枚举所有环维护最大值
    public int longestCycle(int[] edges) {
        int n = edges.length;
        int[] rd = new int[n];
        for (int x : edges) {
            if (x != -1) rd[x]++;
        }
        var q = new ArrayDeque<Integer>();
        for (int i = 0; i < n; i++) {
            if (rd[i] == 0) q.offer(i);
        }
        while (!q.isEmpty()) {
            int x = q.poll();
            int y = edges[x];
            if (y != -1 && --rd[y] == 0) q.offer(y);
        }
        int ans = -1;
        for (int i = 0; i < n; i++) {
            if (rd[i] == 0) continue; // 不是环上的点
            int size = 1;
            for (int w = edges[i]; w != i && rd[w] != -1; w = edges[w]) { // 环上跑计算 size
                rd[w] = -1;
                size++;
            }
            ans = Math.max(ans, size);
        }
        return ans;
    }

}
