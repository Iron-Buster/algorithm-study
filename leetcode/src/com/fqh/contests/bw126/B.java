package com.fqh.contests.bw126;

import java.util.PriorityQueue;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/17 23:53
 **/
public class B {

    public long[] unmarkedSumArray(int[] nums, int[][] queries) {
        long s = 0;
        var pq = new PriorityQueue<int[]>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        for (int i = 0; i < nums.length; i++) {
            pq.offer(new int[]{i, nums[i]});
            s += nums[i];
        }
        int m = queries.length;
        long[] ans = new long[m];
        var vis = new boolean[nums.length];
        for (int i = 0; i < m; i++) {
            int index = queries[i][0];
            int k = queries[i][1];
            if (!vis[index]) {
                vis[index] = true;
                s -= nums[index];
            }
            while (k > 0 && !pq.isEmpty()) {
                var p = pq.poll();
                if (!vis[p[0]]) {
                    vis[p[0]] = true;
                    s -= p[1];
                    k--;
                }
            }
            ans[i] = s;
        }
        return ans;
    }
}
