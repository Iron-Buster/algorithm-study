package com.fqh.contests.bw121;

import java.util.ArrayDeque;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/6 20:11
 **/
public class C {
    boolean[] vis = new boolean[100001];
    public int minimumOperationsToMakeEqual(int x, int y) {
        var q = new ArrayDeque<int[]>();
        q.add(new int[]{x, 0});
        vis[x] = true;
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int u = p[0], step = p[1];
            if (u == y) return step;
            if (u % 11 == 0) {
                int v = u / 11;
                if (!vis[v]) {
                    q.offer(new int[]{v, step+1});
                    vis[v] = true;
                }
            }
            if (u % 5 == 0) {
                int v = u / 5;
                if (!vis[v]) {
                    q.offer(new int[]{v, step+1});
                    vis[v] = true;
                }
            }
            if (u-1 > 0 && !vis[u-1]) {
                q.offer(new int[]{u-1, step+1});
                vis[x-1] = true;
            }
            if (!vis[u+1]) {
                q.offer(new int[]{u+1, step+1});
                vis[u+1] = true;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
