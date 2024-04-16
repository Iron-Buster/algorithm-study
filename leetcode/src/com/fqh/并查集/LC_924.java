package com.fqh.并查集;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/4/16 21:22
 **/
public class LC_924 {



//    https://leetcode.cn/problems/minimize-malware-spread/description/
    public int minMalwareSpread(int[][] graph, int[] initial) {
        int n = graph.length;
        Arrays.sort(initial);
        var set = new HashSet<Integer>();
        for (int x : initial) set.add(x);
        var uf = new UnionFind(n, set);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 1) {
                    uf.merge(i, j);
                }
            }
        }
        int mx = Integer.MIN_VALUE;
        int ans = initial[0];
        // 每个联通分量中
        // 如果只有1个坏节点 那么好的节点数量等于 cnt-1
        // 如果超过1个坏节点 那么最后好节点数量为 0
        for (int x : initial) {
            int fa = uf.find(x);
            if (uf.bad[fa] > 1) continue;
            if (uf.size[fa] > mx) {
                mx = uf.size[fa];
                ans = x;
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
        int[][] g = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int[] in = {0, 1, 2};
        System.out.println(new LC_924().minMalwareSpread(g, in));
    }
}
