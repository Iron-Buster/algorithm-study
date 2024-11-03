package com.fqh.图论.单源最短路;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LC_3342 {
    // https://leetcode.cn/problems/find-minimum-time-to-reach-last-room-ii/description/
    static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        var q = new PriorityQueue<int[]>((a, b) -> Integer.compare(a[2], b[2]));
        q.offer(new int[]{0, 0, 0, 0});
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int x = p[0], y = p[1], cur = p[2], cnt = p[3];
            if (cur > dp[x][y]) continue;
            for (int[] d : dirs) {
                int nx = x + d[0], ny = y + d[1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                int wait = Math.max(0, moveTime[nx][ny] - cur); // 需要等待多久
                int nxt = cur + wait + (cnt % 2 == 0 ? 1 : 2);  // 奇偶判断
                if (nxt < dp[nx][ny]) {
                    dp[nx][ny] = nxt;
                    q.offer(new int[]{nx, ny, nxt, cnt ^ 1});
                }
            }
        }
        return dp[n-1][m-1];
    }
}
