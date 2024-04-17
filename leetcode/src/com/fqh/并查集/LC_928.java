package com.fqh.并查集;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/4/17 10:32
 **/
public class LC_928 {

    //https://leetcode.cn/problems/minimize-malware-spread-ii/description/?envType=daily-question&envId=2024-04-17

    public int minMalwareSpread(int[][] graph, int[] initial) {
        int n =  graph.length;
        var set = new HashSet<Integer>();
        for (int x : initial) set.add(x);
        int ans = 0x3f3f3f;
        int mx = -0x3f3f3f;
        for (int x : initial) {
            var uf = new UnionFind(n, set);
            // 重构并查集
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (x != i && x != j && graph[i][j] == 1) {
                        uf.merge(i, j);
                    }
                }
            }
            var roots = new HashSet<Integer>();
            for (int i = 0; i < n; i++) {
                if (i == x) continue;
                roots.add(uf.find(i));
            }
            int res = 0;
            for (int root : roots) {
                res += uf.bad[root] == 0 ? uf.size[root] : 0;
            }
            if (res > mx || (res == mx && x < ans)) {
                ans = x;
                mx = res;
            }
        }
        return ans;
    }


    class UnionFind {
        int[] fa;
        int[] size;
        int[] bad;

        public UnionFind(int n, HashSet<Integer> set) {
            fa = new int[n]; // 如果n从1开始，则n+1
            size = new int[n];
            bad = new int[n];
            for (int i = 0; i < n; i++) { // <= n
                fa[i] = i;
                size[i] = 1;
                if (set.contains(i)) bad[i] = 1;
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
            if (size[rootA] < size[rootB]) {
                fa[rootA] = rootB;
                size[rootB] += size[rootA];
                bad[rootB] += bad[rootA];
            } else {
                fa[rootB] = rootA;
                size[rootA] += size[rootB];
                bad[rootA] += bad[rootB];
            }
        }
    }


    public static void main(String[] args) {
        int[][] graph = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        int[] initial = {0, 1};
        System.out.println(new LC_928().minMalwareSpread(graph, initial));
    }
}
