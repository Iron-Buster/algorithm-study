package com.fqh.hot100;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/8 16:47
 **/
public class CourseSchedule {

    // https://leetcode.cn/problems/course-schedule/description/?envType=study-plan-v2&envId=top-100-liked
    // 207. 课程表
    public boolean canFinish(int n, int[][] prerequisites) {
        int[] deg = new int[n];
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, v -> new ArrayList<>());
        for (int[] p : prerequisites) {
            g[p[1]].add(p[0]);
            deg[p[0]]++;
        }
        var q = new ArrayDeque<Integer>();
        for (int i = 0; i < n; i++) {
            if (deg[i] == 0) q.add(i);
        }
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : g[u]) {
                deg[v]--;
                if (deg[v] == 0) q.offer(v);
            }
            n--;
        }
        return n == 0;
    }
}
