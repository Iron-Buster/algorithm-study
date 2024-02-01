package com.fqh.图论.BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/1 15:45
 **/
public class LC_1034 {

    //https://leetcode.cn/problems/coloring-a-border/

    static final int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int m = grid.length;
        int n = grid[0].length;
        var uf = new UnionFind(m * n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int p1 = i * n + j;
                for (int[] dir : dirs) {
                    int nx = i + dir[0];
                    int ny = j + dir[1];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] != grid[i][j]) {
                        continue;
                    }
                    int p2 = nx * n + ny;
                    uf.merge(p1, p2);
                }
            }
        }
        int fa = uf.find(row * n + col);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (uf.find(i * n + j) != fa) { // 不连通
                    continue;
                }
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    grid[i][j] = color;
                } else { // 在上、下、左、右任意一个方向上与不属于同一连通分量的网格块相邻
                    if (uf.find((i-1)*n+j) != fa ||
                            uf.find((i+1)*n+j) != fa ||
                            uf.find(i*n+(j-1)) != fa ||
                            uf.find(i*n+(j+1)) != fa) {
                        grid[i][j] = color;
                    }
                }
            }
        }
        return grid;
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

    public static void main(String[] args) {
        int[][] grid = {
                {2,2,1},
                {1,2,1},
                {1,1,1}
        };
        int row = 1, col = 1, color = 2;
        System.out.println(Arrays.deepToString(new LC_1034().colorBorder(grid, row, col, color)));
    }
}
