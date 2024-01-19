package com.fqh.并查集;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/19 10:45
 **/
public class LC_261 {

//    261. 以图判树
//            中等
//    相关标签
//            相关企业
//    提示
//    给定编号从 0 到 n - 1 的 n 个结点。给定一个整数 n 和一个 edges 列表，其中 edges[i] = [ai, bi] 表示图中节点 ai 和 bi 之间存在一条无向边。
//
//    如果这些边能够形成一个合法有效的树结构，则返回 true ，否则返回 false 。

//    [[0,1],[2,3]]
    public boolean validTree(int n, int[][] edges) {
        var uf = new UnionFind(n);
        for (int[] e : edges) {
            int x = e[0], y = e[1];
            if (uf.find(x) == uf.find(y)) {
                return false;
            }
            uf.merge(x, y);
        }
        return uf.count == 1;
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
