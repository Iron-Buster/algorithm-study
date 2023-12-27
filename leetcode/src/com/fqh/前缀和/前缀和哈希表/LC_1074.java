package com.fqh.前缀和.前缀和哈希表;

import java.util.HashMap;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2023/12/27 15:18
 **/
public class LC_1074 {

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int[][] g = matrixSum(matrix);
        int ans = 0;
        for (int top = 1; top <= m; top++) {
            for (int bot = top; bot <= m; bot++) {
                int cur = 0;
                var map = new HashMap<Integer, Integer>();
                for (int r = 1; r <= n; r++) { // 枚举每一列
                    cur = g[bot][r] - g[top-1][r];
                    if (cur == target) ans++;
                    if (map.containsKey(cur - target)) {
                        ans += map.get(cur - target);
                    }
                    map.merge(cur, 1, Integer::sum);
                }
            }
        }
        return ans;
    }

    static int[][] matrixSum(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        int[][] g = new int[n + 1][m + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int x = i + 1;
                int y = j + 1;
                g[x][y] = a[i][j] + g[x-1][y] + g[x][y-1] - g[x-1][y-1];
            }
        }
        return g;
    }

//    1074. 元素和为目标值的子矩阵数量
//            已解答
//    第 139 场周赛
//            Q4
//2189
//    相关标签
//            相关企业
//    提示
//    给出矩阵 matrix 和目标值 target，返回元素总和等于目标值的非空子矩阵的数量。
//
//    子矩阵 x1, y1, x2, y2 是满足 x1 <= x <= x2 且 y1 <= y <= y2 的所有单元 matrix[x][y] 的集合。
//
//    如果 (x1, y1, x2, y2) 和 (x1', y1', x2', y2') 两个子矩阵中部分坐标不同（如：x1 != x1'），那么这两个子矩阵也不同。
}
