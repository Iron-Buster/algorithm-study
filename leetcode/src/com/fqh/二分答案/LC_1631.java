package com.fqh.二分答案;

import java.util.ArrayDeque;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/3 23:27
 **/
public class LC_1631 {

    static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public boolean check(int mid, int[][] g) {
        int m = g.length;
        int n = g[0].length;
        var vis = new boolean[m][n];
        var q = new ArrayDeque<int[]>();
        q.offer(new int[]{0, 0});
        vis[0][0] = true;
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int x = p[0], y = p[1];
            if (x == m - 1 && y == n - 1) {
                return true;
            }
            for (int[] dir : DIRS) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if (!vis[nx][ny]) {
                    int v = Math.abs(g[nx][ny] - g[x][y]);
                    if (v > mid) continue;
                    q.offer(new int[]{nx, ny});
                    vis[nx][ny] = true;
                }
            }
        }
        return false;
    }

    public int minimumEffortPath(int[][] g) {
        int l = 0;
        int r = (int) 1e6;
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

//    1631. 最小体力消耗路径
//            已解答
//    第 212 场周赛
//            Q3
//1948
//    相关标签
//            相关企业
//    提示
//    你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，其中 heights[row][col] 表示格子 (row, col) 的高度。一开始你在最左上角的格子 (0, 0) ，且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。你每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。
//
//    一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。
//
//    请你返回从左上角走到右下角的最小 体力消耗值 。
}
