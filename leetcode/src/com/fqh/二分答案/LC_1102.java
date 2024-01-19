package com.fqh.二分答案;

import java.util.ArrayDeque;
import java.util.Map;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/19 15:43
 **/
public class LC_1102 {

//    1102. 得分最高的路径
//    第 3 场双周赛
//            Q4
//2011
//    相关标签
//            相关企业
//    提示
//    给定一个 m x n 的整数矩阵 grid，返回从 (0,0) 开始到 (m - 1, n - 1) 在四个基本方向上移动的路径的最大 分数 。
//
//    一条路径的 分数 是该路径上的最小值。
//
//    例如，路径 8 → 4 → 5 → 9 的得分为 4 。

    static final int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public boolean check(int[][] g, long mid) {
        int m = g.length;
        int n = g[0].length;
        var q = new ArrayDeque<int[]>();
        var vis = new boolean[m][n];
        vis[0][0] = true;
        q.offer(new int[]{0, 0});
        if (g[0][0] < mid) return false;
        while (!q.isEmpty()) {
            var p = q.poll();
            int x = p[0], y = p[1];
            if (x == m - 1 && y == n - 1) {
                return true;
            }
            for (int[] dir : DIRS) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || vis[nx][ny]) {
                    continue;
                }
                if (g[nx][ny] < mid) continue;
                q.offer(new int[]{nx, ny});
                vis[nx][ny] = true;
            }
        }
        return false;
    }

    // 二分答案，然后跑bfs
    public int maximumMinimumPath(int[][] grid) {
        long l = 0;
        long r = 1000000001;
        while (l < r) {
            long mid = l + r + 1 >> 1;
            if (check(grid, mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return (int) l;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0,1,0,0,0,1},
                {0,1,1,0,0,0},
                {0,0,1,1,0,1},
                {0,1,1,1,1,0},
                {1,1,1,1,1,1}};
        System.out.println(new LC_1102().maximumMinimumPath(grid));
    }
}
