package com.fqh.并查集;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2023/12/27 09:52
 **/
public class LC_1559 {

    public boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        var uf = new UnionFind(m * n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int idx1 = i * n + j;
                if (i + 1 < m && grid[i + 1][j] == grid[i][j]) {
                    int idx2 = (i + 1) * n + j;
                    if (uf.isConnected(idx1, idx2)) return true;
                    uf.merge(idx1, idx2);
                }
                if (j + 1 < n && grid[i][j + 1] == grid[i][j]) {
                    int idx2 = i * n + (j + 1);
                    if (uf.isConnected(idx1, idx2)) return true;
                    uf.merge(idx1, idx2);
                }
            }
        }
        return false;
    }

    class UnionFind {
        int[] fa;

        public UnionFind(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) {
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

        public boolean isConnected(int a, int b) {
            return find(a) == find(b);
        }
    }



//    1559. 二维网格图中探测环
//    第 33 场双周赛
//            Q4
//1838
//    相关标签
//            相关企业
//    提示
//    给你一个二维字符网格数组 grid ，大小为 m x n ，你需要检查 grid 中是否存在 相同值 形成的环。
//
//    一个环是一条开始和结束于同一个格子的长度 大于等于 4 的路径。对于一个给定的格子，你可以移动到它上、下、左、右四个方向相邻的格子之一，可以移动的前提是这两个格子有 相同的值 。
//
//    同时，你也不能回到上一次移动时所在的格子。比方说，环  (1, 1) -> (1, 2) -> (1, 1) 是不合法的，因为从 (1, 2) 移动到 (1, 1) 回到了上一次移动时的格子。
//
//    如果 grid 中有相同值形成的环，请你返回 true ，否则返回 false 。

    public static void main(String[] args) {
        char[][] g = {
                {'b','a','c'},
                {'c','a','c'},
                {'d','d','c'},
                {'b','c','c'}
        };
        System.out.println(new LC_1559().containsCycle(g));
    }
}
