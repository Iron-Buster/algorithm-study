package com.fqh.前缀和.二维前缀和;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2023/12/27 16:07
 **/
public class LC_1314 {

    public int[][] matrixBlockSum(int[][] mat, int k) {
        int[][] g = matrixSum(mat);
        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = query(
                        Math.max(i - k, 0),
                        Math.max(j - k, 0),
                        Math.min(i + k, m - 1),
                        Math.min(j + k, n - 1), g);
            }
        }
        return mat;
    }

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
        // 求某一段区域和 [i, j] 的模板是 sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1];（模板部分）
        x1++; y1++; x2++; y2++;
        return g[x2][y2] - g[x1-1][y2] - g[x2][y1-1] + g[x1-1][y1-1];
    }

//    1314. 矩阵区域和
//    第 17 场双周赛
//            Q2
//    1484
//    相关标签
//            相关企业
//    提示
//    给你一个 m x n 的矩阵 mat 和一个整数 k ，请你返回一个矩阵 answer ，其中每个 answer[i][j] 是所有满足下述条件的元素 mat[r][c] 的和：
//
//    i - k <= r <= i + k,
//    j - k <= c <= j + k 且
//            (r, c) 在矩阵内。
}
