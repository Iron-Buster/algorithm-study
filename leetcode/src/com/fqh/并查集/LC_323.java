package com.fqh.并查集;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/19 11:53
 **/
public class LC_323 {


//    323. 无向图中连通分量的数目
//            中等
//    相关标签
//            相关企业
//    你有一个包含 n 个节点的图。给定一个整数 n 和一个数组 edges ，其中 edges[i] = [ai, bi] 表示图中 ai 和 bi 之间有一条边。
//
//    返回 图中已连接分量的数目 。
    public int countComponents(int n, int[][] edges) {
        var uf = new UnionFind(n);
        for (int[] e : edges) {
            int x = e[0], y = e[1];
            uf.merge(x, y);
        }
        return uf.count;
    }

    class UnionFind {
        int[] parent;
        int count;
        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
            }
            count = n;
        }

        public int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void merge(int a, int b) {
            int p_a = find(a);
            int p_b = find(b);
            if (p_a == p_b) return;
            parent[p_b] = p_a;
            count--;
        }
    }
}
