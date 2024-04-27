package com.fqh.动态规划;

import java.util.TreeSet;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/4/27 14:51
 **/
public class LC_363 {


//    https://leetcode.cn/problems/max-sum-of-rectangle-no-larger-than-k/description/

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

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int[][] g = matrixSum(matrix);
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = Integer.MIN_VALUE;
        for (int top = 1; top <= m; top++) {
            for (int bot = top; bot <= m; bot++) {
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                for (int r = 1; r <= n; r++) {
                    int right = g[bot][r] - g[top-1][r];
                    if (right == k) return k;
                    Integer left = set.ceiling(right - k);
                    if (left != null) {
                        ans = Math.max(ans, right - left);
                    }
                    set.add(right);
                }
            }
        }
        return ans;
    }
}
