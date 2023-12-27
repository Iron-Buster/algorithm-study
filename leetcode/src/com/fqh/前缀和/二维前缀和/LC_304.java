package com.fqh.前缀和.二维前缀和;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2023/12/27 14:18
 **/
public class LC_304 {


    class NumMatrix {
        int[][] g;
        public NumMatrix(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            g = new int[m + 1][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int x = i + 1;
                    int y = j + 1;
                    g[x][y] = matrix[i][j] + g[x-1][y] + g[x][y-1] - g[x-1][y-1];
                }
            }
        }

        public int sumRegion(int x1, int y1, int x2, int y2) {
            // 求某一段区域和 [i, j] 的模板是 sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1];（模板部分）
            x1++; y1++; x2++; y2++;
            return g[x2][y2] - g[x1-1][y2] - g[x2][y1-1] + g[x1-1][y1-1];
        }
    }

//    304. 二维区域和检索 - 矩阵不可变
//            尝试过
//    中等
//            相关标签
//    相关企业
//    给定一个二维矩阵 matrix，以下类型的多个请求：
//
//    计算其子矩形范围内元素的总和，该子矩阵的 左上角 为 (row1, col1) ，右下角 为 (row2, col2) 。
//    实现 NumMatrix 类：
//
//    NumMatrix(int[][] matrix) 给定整数矩阵 matrix 进行初始化
//    int sumRegion(int row1, int col1, int row2, int col2) 返回 左上角 (row1, col1) 、右下角 (row2, col2) 所描述的子矩阵的元素 总和 。
}
