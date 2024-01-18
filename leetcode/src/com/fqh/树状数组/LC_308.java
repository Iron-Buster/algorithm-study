package com.fqh.树状数组;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/18 23:03
 **/
public class LC_308 {

//    308. 二维区域和检索 - 可变
//            已解答
//    困难
//            相关标签
//    相关企业
//    给你一个二维矩阵 matrix ，处理以下类型的多个查询:
//
//    更新 matrix 中单元格的值。
//    计算由 左上角 (row1, col1) 和 右下角 (row2, col2) 定义的 matrix 内矩阵元素的 和。
//    实现 NumMatrix 类：
//
//    NumMatrix(int[][] matrix) 用整数矩阵 matrix 初始化对象。
//    void update(int row, int col, int val) 更新 matrix[row][col] 的值到 val 。
//    int sumRegion(int row1, int col1, int row2, int col2) 返回矩阵 matrix 中指定矩形区域元素的 和 ，
//    该区域由 左上角 (row1, col1) 和 右下角 (row2, col2) 界定。

    class NumMatrix {

        FenwickTree3 ft;
        int[][] mat;

        public NumMatrix(int[][] matrix) {
            int n = matrix.length;
            int m = matrix[0].length;
            mat = matrix;
            ft = new FenwickTree3(n, m);
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    int v = mat[i - 1][j - 1];
                    ft.change(i, j, v);
                }
            }
        }

        public void update(int row, int col, int val) {
            int x = row + 1;
            int y = col + 1;
            int incr = val - mat[row][col];
            ft.change(x, y, incr);
            mat[row][col] = val;
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int x1 = row1 + 1, y1 = col1 + 1, x2 = row2 + 1, y2 = col2 + 1;
            return ft.query(x2, y2) - ft.query(x1 - 1, y2)
                    - ft.query(x2, y1 - 1) + ft.query(x1 - 1, y1 - 1);
        }
    }

    /**
     * 二维树状数组
     */
    class FenwickTree3 {
        int n, m;
        int[][] s = new int[300][300]; // 各权值在矩阵出现的次数

        public FenwickTree3(int n, int m) {
            this.n = n;
            this.m = m;
        }

        public int lowbit(int x) {
            return x & -x;
        }

        public void change(int x, int y, int v) {
            for (int i = x; i <= n; i += lowbit(i)) {
                for (int j = y; j <= m; j += lowbit(j)) {
                    s[i][j] += v;
                }
            }
        }

        public int query(int x, int y) {
            int t = 0;
            for (int i = x; i > 0; i -= lowbit(i)) {
                for (int j = y; j > 0; j -= lowbit(j)) {
                    t += s[i][j];
                }
            }
            return t;
        }
    }

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */

}
