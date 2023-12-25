package com.fqh.图论.最短路;


import java.util.PriorityQueue;

/**
 * @Author: vq
 * @Date: 2023/12/11 10:41
 * @Version V1.0
 */
public class LC_1631 {
//    1631. 最小体力消耗路径
//    第 212 场周赛
//            Q3
//    1948
//    相关标签
//            相关企业
//    提示
//    你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，其中 heights[row][col] 表示格子 (row, col) 的高度。
//    一开始你在最左上角的格子 (0, 0) ，且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。
//    你每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。
//
//    一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。
//
//    请你返回从左上角走到右下角的最小 体力消耗值 。

    boolean[][] vis;
    static final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

//    Dijkstra-最短路
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        vis = new boolean[m][n];
        var pq = new PriorityQueue<int[]>((o1, o2) -> o1[2] - o2[2]);
        pq.offer(new int[]{0, 0, 0});
        while (pq.size() > 0) {
            var p = pq.poll();
            int x = p[0], y = p[1], mx = p[2];
            if (vis[x][y]) continue;
            vis[x][y] = true;
            if (x == m - 1 && y == n - 1) {
                return mx;
            }
            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                pq.offer(new int[]{nx, ny, Math.max(mx, Math.abs(heights[x][y] - heights[nx][ny]))});
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        int[][] heights = {
                {1,2,2},
                {3,8,2},
                {5,3,5}
        };
        System.out.println(new LC_1631().minimumEffortPath(heights));
    }
}
