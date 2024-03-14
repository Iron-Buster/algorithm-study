package com.fqh.并查集;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/14 14:57
 **/
public class LC_1579 {
    // https://leetcode.cn/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable/
//    1579. 保证图可完全遍历
//    第 205 场周赛
//            Q4
//    2132
//    相关标签
//            相关企业
//    提示
//    Alice 和 Bob 共有一个无向图，其中包含 n 个节点和 3  种类型的边：
//
//    类型 1：只能由 Alice 遍历。
//    类型 2：只能由 Bob 遍历。
//    类型 3：Alice 和 Bob 都可以遍历。
//    给你一个数组 edges ，其中 edges[i] = [typei, ui, vi] 表示节点 ui 和 vi 之间存在类型为 typei 的双向边。
//    请你在保证图仍能够被 Alice和 Bob 完全遍历的前提下，找出可以删除的最大边数。
//    如果从任何节点开始，Alice 和 Bob 都可以到达所有其他节点，则认为图是可以完全遍历的。
//
//    返回可以删除的最大边数，如果 Alice 和 Bob 无法完全遍历图，则返回 -1 。

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        // 如果u-v之间存在type3的边，那么u-v之间其他的边都可以被删除
        int ans = 0, a = 0, b = 0;
        var uf1 = new UnionFind(n);
        var uf2 = new UnionFind(n);
        for (int[] edge : edges) {
            int type = edge[0], u = edge[1], v = edge[2];
            if (type == 3) {
                if (uf1.find(u) == uf1.find(v)) {
                    ans++; // 公共可以删边的数量
                } else {
                    uf1.merge(u, v);
                    uf2.merge(u, v);
                }
            }
        }

        for (int[] edge : edges) {
            int type = edge[0], u = edge[1], v = edge[2];
            if (type == 1) {
                if (uf1.find(u) == uf1.find(v)) a++;
                else uf1.merge(u, v);
            }
            if (type == 2) {
                if (uf2.find(u) == uf2.find(v)) b++;
                else uf2.merge(u, v);
            }
        }
        if (uf1.count != 1 || uf2.count != 1) return -1;
        return ans + a + b;
    }


    class UnionFind {
        int[] fa;
        int count;

        public UnionFind(int n) {
            fa = new int[n+1]; // 如果n从1开始，则n+1
            for (int i = 1; i <= n; i++) { // <= n
                fa[i] = i;
            }
            count = n;
        }

        public int find(int x) {
            while (x != fa[x]) {
                fa[x] = fa[fa[x]];
                x = fa[x];
            }
            return x;
        }

        public void merge(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA == rootB) return;
            fa[rootB] = rootA;
            count--;
        }
    }

//    n = 4, edges = [[3,1,2],[3,2,3],[1,1,3],[1,2,4],[1,1,2],[2,3,4]]
    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {{3,1,2},{3,2,3},{1,1,3},{1,2,4},{1,1,2},{2,3,4}};
        System.out.println(new LC_1579().maxNumEdgesToRemove(n, edges));
    }
}
