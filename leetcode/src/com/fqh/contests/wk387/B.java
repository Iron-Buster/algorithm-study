package com.fqh.contests.wk387;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/3 12:14
 **/
public class B {

    static int[][] matrixSum(int[][] a) {
        int m = a.length;
        int n = a[0].length;
        int[][] g = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int x = i + 1;
                int y = j + 1;
                g[x][y] = a[i][j] + g[x-1][y] + g[x][y-1] - g[x-1][y-1];
            }
        }
        return g;
    }

    static int query(int x1, int y1, int x2, int y2, int[][] g) {
        x1++; y1++; x2++; y2++;
        return g[x2][y2] - g[x1-1][y2] - g[x2][y1-1] + g[x1-1][y1-1];
    }

    public int countSubmatrices(int[][] grid, int k) {
        int[][] s = matrixSum(grid);
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int t = query(0, 0, i, j, s);
                if (t <= k) ans++;
            }
        }
        return ans;
    }
}
