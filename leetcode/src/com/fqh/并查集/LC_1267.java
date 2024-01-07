package com.fqh.并查集;

import java.util.ArrayList;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/7 23:16
 **/
public class LC_1267 {


    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        var uf = new UnionFind(m * n);
        var a = new ArrayList<int[]>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    a.add(new int[]{i, j});
                }
            }
        }
        for (int i = 0; i < a.size(); i++) {
            int[] p1 = a.get(i);
            for (int j = 1; j < a.size(); j++) {
                int[] p2 = a.get(j);
                if (p1[0] == p2[0] || p1[1] == p2[1]) {
                    int u = p1[0] * n + p1[1];
                    int v = p2[0] * n + p2[1];
                    uf.merge(u, v);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m * n; i++) {
            int fa = uf.find(i);
            if (i == fa && uf.size[fa] > 1) {
                ans += uf.size[fa];
            }
        }
        return ans;
    }

    class UnionFind {
        int[] fa;
        int[] size;

        public UnionFind(int n) {
            fa = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
                size[i] = 1;
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
            } else {
                fa[rootB] = rootA;
                size[rootA] += size[rootB];
            }
        }
    }




//    1267. 统计参与通信的服务器
//    第 164 场周赛
//            Q2
//1375
//    相关标签
//            相关企业
//    提示
//    这里有一幅服务器分布图，服务器的位置标识在 m * n 的整数矩阵网格 grid 中，1 表示单元格上有服务器，0 表示没有。
//
//    如果两台服务器位于同一行或者同一列，我们就认为它们之间可以进行通信。
//
//    请你统计并返回能够与至少一台其他服务器进行通信的服务器的数量。
}
