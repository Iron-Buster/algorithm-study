package com.fqh.数学.筛质数;

import java.util.ArrayDeque;
import java.util.HashMap;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/18 16:31
 **/
public class LC_100217 {


//    https://leetcode.cn/problems/most-frequent-prime/submissions/502691417/

    int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, -1}, {-1, 1}, {1, 1}, {1, -1}};

    public int mostFrequentPrime(int[][] a) {
        int m = a.length;
        int n = a[0].length;
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                bfs(i, j, a, map);
            }
        }
        long ans = -1;
        int cnt = 0;
        for (int x : map.keySet()) {
            if (x > 10 && isPrime(x)) {
                if (map.get(x) > cnt) {
                    cnt = map.get(x);
                    ans = x;
                } else if (map.get(x) == cnt) {
                    ans = Math.max(ans, x);
                }
            }
        }
        return (int) ans;
    }

    public void bfs(int i, int j, int[][] a, HashMap<Integer, Integer> map) {
        var q = new ArrayDeque<int[]>();
        q.offer(new int[]{i, j, a[i][j], -1});
        int m = a.length;
        int n = a[0].length;
        map.merge(a[i][j], 1, Integer::sum);
        while (q.size() > 0) {
            var p = q.poll();
            int x = p[0], y = p[1], num = p[2], d = p[3];
            if (d != -1) {
                int nx = x + DIRS[d][0];
                int ny = y + DIRS[d][1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                int nx_num = num * 10 + a[nx][ny];
                q.offer(new int[]{nx, ny, nx_num, d});
                map.merge(nx_num, 1, Integer::sum);
            } else {
                for (int k = 0; k < DIRS.length; k++) {
                    int nx = x + DIRS[k][0];
                    int ny = y + DIRS[k][1];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                    int nx_num = num * 10 + a[nx][ny];
                    q.offer(new int[]{nx, ny, nx_num, k});
                    map.merge(nx_num, 1, Integer::sum);
                }
            }
        }
    }

    static boolean isPrime(long n) {
        if (n < 2 || n >= 4 && n % 2 == 0) {
            return false;
        }
        for (int i = 2; (long) i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
