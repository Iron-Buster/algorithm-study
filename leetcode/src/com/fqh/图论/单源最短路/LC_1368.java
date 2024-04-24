package com.fqh.图论.单源最短路;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/4/24 22:55
 **/
public class LC_1368 {

    //dijkstra
    //https://leetcode.cn/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/description/
    static final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        var dist = new int[m][n];
        for (int[] dis : dist) {
            Arrays.fill(dis, 0x3f3f3f);
        }
        var pq = new PriorityQueue<int[]>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{0, 0, 0});
        dist[0][0] = 0;
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int x = p[0], y = p[1], w = p[2];
            if (x == m - 1 && y == n - 1) break;
            for (int i = 1; i <= 4; i++) {
                int[] dir = dirs[i-1];
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                // 如果上一步的direction是指向当前方向的 则不需要花费1
                int cost = (i == grid[x][y] ? 0 : 1);
                if (dist[nx][ny] > w + cost) {
                    dist[nx][ny] = w + cost;
                    pq.offer(new int[]{nx, ny, dist[nx][ny]});
                }
            }
        }
        return dist[m-1][n-1];
    }
}
