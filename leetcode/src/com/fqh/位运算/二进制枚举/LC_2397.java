package com.fqh.位运算.二进制枚举;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/4 09:36
 **/
public class LC_2397 {

    public int maximumRows(int[][] matrix, int numSelect) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] mask = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    mask[i] |= (1 << j); // 将每一行转为一个二进制数字
                }
            }
        }
        int ans = 0;
        for (int sub = 0; sub < (1 << n); sub++) {    // 枚举1-n列的子集
            if (Integer.bitCount(sub) == numSelect) { // 最多选择numSelect列
                int mx = 0; // 最大覆盖的行数
                for (int row : mask) {
                    if ((row & sub) == row) { // 判断sub是不是完全覆盖row的1
                        mx++;
                    }
                }
                ans = Math.max(ans, mx);
            }
        }
        return ans;
    }

//    2397. 被列覆盖的最多行数
//    第 86 场双周赛
//            Q3
//1719
//    相关标签
//            相关企业
//    提示
//    给你一个下标从 0 开始、大小为 m x n 的二进制矩阵 matrix ；另给你一个整数 numSelect，表示你必须从 matrix 中选择的 不同 列的数量。
//
//    如果一行中所有的 1 都被你选中的列所覆盖，则认为这一行被 覆盖 了。
//
//    形式上，假设 s = {c1, c2, ...., cnumSelect} 是你选择的列的集合。对于矩阵中的某一行 row ，如果满足下述条件，则认为这一行被集合 s 覆盖：
//
//对于满足 matrix[row][col] == 1 的每个单元格 matrix[row][col]（0 <= col <= n - 1），col 均存在于 s 中，或者
//row 中 不存在 值为 1 的单元格。
//你需要从矩阵中选出 numSelect 个列，使集合覆盖的行数最大化。
//
//返回一个整数，表示可以由 numSelect 列构成的集合 覆盖 的 最大行数 。

//    输入：matrix = [[0,0,0],[1,0,1],[0,1,1],[0,0,1]], numSelect = 2
//    输出：3
//    解释：
//    图示中显示了一种覆盖 3 行的可行办法。
//    选择 s = {0, 2} 。
//            - 第 0 行被覆盖，因为其中没有出现 1 。
//            - 第 1 行被覆盖，因为值为 1 的两列（即 0 和 2）均存在于 s 中。
//            - 第 2 行未被覆盖，因为 matrix[2][1] == 1 但是 1 未存在于 s 中。
//            - 第 3 行被覆盖，因为 matrix[2][2] == 1 且 2 存在于 s 中。
//    因此，可以覆盖 3 行。
//    另外 s = {1, 2} 也可以覆盖 3 行，但可以证明无法覆盖更多行。

    public static void main(String[] args) {
        int[][] matrix = {{0, 0, 0}, {1, 0, 1}, {0, 1, 1}, {0, 0, 1}};
        int numSelect = 2;
        System.out.println(new LC_2397().maximumRows(matrix, numSelect));
    }
}
