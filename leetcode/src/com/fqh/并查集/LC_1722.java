package com.fqh.并查集;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/17 12:37
 **/
public class LC_1722 {

    //https://leetcode.cn/problems/minimize-hamming-distance-after-swap-operations/description/
    // 1722. 执行交换操作后的最小汉明距离
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = target.length;
        var map = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(target[i], v -> new ArrayList<>());
            map.get(target[i]).add(i);
        }
        var uf = new UnionFind(n);
        for (int[] a : allowedSwaps) {
            uf.merge(a[0], a[1]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            var list = map.get(source[i]);
            if (list == null) continue;
            for (int j = 0; j < list.size(); j++) {
                int idx = list.get(j);
                if (uf.find(i) == uf.find(idx)) {
                    ans++;
                    list.remove(j);
                    break;
                }
            }
        }
        return n - ans;
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
