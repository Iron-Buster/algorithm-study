package com.fqh.杂项;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/2 15:41
 **/
public class LC_764 {

    public int orderOfLargestPlusSign(int n, int[][] mines) {
        // 暴力 O(n^3)
        int[][] a = new int[n][n];
        int cnt0 = n * n;
        for (int[] m : mines) {
            int x = m[0], y = m[1];
            a[x][y] = 1;
            cnt0--;
        }
        if (cnt0 == 0) {
            return 0;
        }
        int ans = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (a[i][j] == 1) continue;
                int up_mx = 0, down_mx = 0;
                int left_mx = 0, right_mx = 0;
                for (int k = i; k >= 0 && a[k][j] == 0; k--) up_mx++;
                for (int k = i; k < n && a[k][j] == 0; k++) down_mx++;
                for (int k = j; k >= 0 && a[i][k] == 0; k--) left_mx++;
                for (int k = j; k < n && a[i][k] == 0; k++) right_mx++;
                ans = Math.max(ans, Math.min(Math.min(up_mx, down_mx), Math.min(left_mx, right_mx)));
            }
        }
        return ans;
    }

    // 前缀和解法O(n^2)
    // 用前缀和预处理每个方向能够到达的最大长度
    // cur = a[i][j] = min(up[i][j], down[i][j], left[i][j], right[i][j])
    // ans = max(ans, cur)
    public int orderOfLargestPlusSign2(int n, int[][] mines) {
        int[][] a = new int[n][n];
        int[][] up = new int[n][n], down = new int[n][n];
        int[][] left = new int[n][n], right = new int[n][n];
        for (int[] m : mines) {
            int x = m[0], y = m[1];
            a[x][y] = 1;
        }
        // [left, right]
        for (int i = 0; i < n; i++) {
            // left
            left[i][0] = a[i][0] == 0 ? 1 : 0;
            for (int j = 1; j < n; j++) {
                left[i][j] = a[i][j] == 0 ? left[i][j-1] + 1 : 0;
            }
            // right
            right[i][n-1] = a[i][n-1] == 0 ? 1 : 0;
            for (int j = n-2; j >= 0; j--) {
                right[i][j] = a[i][j] == 0 ? right[i][j+1] + 1 : 0;
            }
        }
        // [up, down]
        for (int j = 0; j < n; j++) {
            // up
            up[0][j] = a[0][j] == 0 ? 1 : 0;
            for (int i = 1; i < n; i++) {
                up[i][j] = a[i][j] == 0 ? up[i-1][j] + 1 : 0;
            }
            // down
            down[n-1][j] = a[n-1][j] == 0 ? 1 : 0;
            for (int i = n-2; i >= 0; i--) {
                down[i][j] = a[i][j] == 0 ? down[i+1][j] + 1 : 0;
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, Math.min(Math.min(up[i][j], down[i][j]), Math.min(left[i][j], right[i][j])));
            }
        }
        return ans;
    }

    //764. 最大加号标志
//    第 67 场周赛
//            Q3
//1753
//    相关标签
//            相关企业
//    提示
//    在一个 n x n 的矩阵 grid 中，除了在数组 mines 中给出的元素为 0，其他每个元素都为 1。mines[i] = [xi, yi]表示 grid[xi][yi] == 0
//
//    返回  grid 中包含 1 的最大的 轴对齐 加号标志的阶数 。如果未找到加号标志，则返回 0 。
//
//    一个 k 阶由 1 组成的 “轴对称”加号标志 具有中心网格 grid[r][c] == 1 ，以及4个从中心向上、向下、向左、向右延伸，长度为 k-1，由 1 组成的臂。注意，只有加号标志的所有网格要求为 1 ，别的网格可能为 0 也可能为 1 。


    public static void main(String[] args) {
        int n = 2;

    }
}
