package com.fqh.二分答案;

import java.util.ArrayDeque;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/3 17:39
 **/
public class LC_778 {

    static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public boolean check(int mid, int[][] g) {
        int n = g.length;
        var vis = new boolean[n][n];
        var q = new ArrayDeque<int[]>();
        q.offer(new int[]{0, 0, g[0][0]});
        if (g[0][0] > mid) return false;
        vis[0][0] = true;
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int x = p[0], y = p[1], time = p[2];
            if (x == n - 1 && y == n - 1) {
                return time <= mid;
            }
            for (int[] dir : DIRS) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (!vis[nx][ny]) {
                    vis[nx][ny] = true;

                    int v = time + (g[nx][ny] - time);
                    if (v > mid) continue;
                    q.offer(new int[]{nx, ny, v});
                }
            }
        }
        return false;
    }
    // 二分答案 time，然后bfs判断能否在time内到达终点
    public int swimInWater(int[][] g) {
        int l = 0, r = 15000;
        while (l < r) {
            int mid = l + r >> 1;
            if (check(mid, g)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

//    778. 水位上升的泳池中游泳
//    第 70 场周赛
//            Q4
//    2097
//    相关标签
//            相关企业
//    提示
//    在一个 n x n 的整数矩阵 grid 中，每一个方格的值 grid[i][j] 表示位置 (i, j) 的平台高度。
//
//    当开始下雨时，在时间为 t 时，水池中的水位为 t 。你可以从一个平台游向四周相邻的任意一个平台，但是前提是此时水位必须同时淹没这两个平台。
//    假定你可以瞬间移动无限距离，也就是默认在方格内部游动是不耗时的。当然，在你游泳的时候你必须待在坐标方格里面。
//
//    你从坐标方格的左上平台 (0，0) 出发。返回 你到达坐标方格的右下平台 (n-1, n-1) 所需的最少时间 。

    public static void main(String[] args) {
        int[][] g = {{3,2},{0,1}};
        System.out.println(new LC_778().swimInWater(g));
    }
}
