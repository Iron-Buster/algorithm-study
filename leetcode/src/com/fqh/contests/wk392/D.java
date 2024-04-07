package com.fqh.contests.wk392;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/4/7 20:23
 **/
public class D {

    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        UnionFind uf = new UnionFind(n);
        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            uf.merge(u, v, w);
        }
        int m = query.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int s = query[i][0], t = query[i][1];
            if (s == t) continue;
            if (uf.find(s) != uf.find(t)) {
                ans[i] = -1;
            } else {
                ans[i] = uf.rank[uf.find(s)];
            }
        }
        return ans;
    }

    class UnionFind {
        int[] fa;
        int[] rank;

        public UnionFind(int n) {
            this.fa = new int[n];
            this.rank = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
                rank[i] = -1;
            }
        }

        public int find(int x) {
            while (x != fa[x]) {
                fa[x] = fa[fa[x]];
                x = fa[x];
            }
            return x;
        }

        public void merge(int x, int y, int w) {
            int rootX = find(x);
            int rootY = find(y);
            rank[rootY] &= w;
            if (rootX == rootY) return;
            rank[rootY] &= rank[rootX];
            fa[rootX] = rootY;
        }
    }
}
