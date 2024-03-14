package com.fqh.并查集;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/14 14:33
 **/
public class LC_947 {

    //https://leetcode.cn/problems/most-stones-removed-with-same-row-or-column/description/

    public int removeStones(int[][] stones) {
        int n = stones.length;
        var uf = new UnionFind(n);
        for (int i = 0; i < stones.length; i++) {
            int x1 = stones[i][0], y1 = stones[i][1];
            for (int j = i + 1; j < stones.length; j++) {
                int x2 = stones[j][0], y2 = stones[j][1];
                if (x1 == x2 || y1 == y2) {
                    uf.merge(i, j);
                }
            }
        }
//        var map = new HashMap<Integer, Integer>();
        var set = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            int fa = uf.find(i);
//            map.merge(fa, 1, Integer::sum);
            set.add(fa);
        }
        return n - set.size(); //  所有石头数量减去每个连通分量剩余的1个
//        // 每个连通分量里至少留一个不被移除
//        int ans = 0;
//        for (int v : map.values()) {
//            ans += v - 1;
//        }
//        return ans;

    }


    class UnionFind {
        int[] fa;

        public UnionFind(int n) {
            fa = new int[n]; // 如果n从1开始，则n+1
            for (int i = 0; i < n; i++) { // <= n
                fa[i] = i;
            }
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
        }
    }
}
