package com.fqh.contests.wk381;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/21 00:22
 **/
public class B {


    public int[] countOfPairs(int n, int x, int y) {
        x--;
        y--;
        long[][] dist = new long[n][n];
        for (long[] d : dist) {
            Arrays.fill(d, Long.MAX_VALUE);
        }
        for (int i = 0; i < n - 1; i++) {
            dist[i][i+1] = 1;
            dist[i+1][i] = 1;
        }
        dist[x][y] = 1;
        dist[y][x] = 1;
        long[][] f = floyd(dist);
        for (long[] ff : f) {
            System.out.println(Arrays.toString(ff));
        }
        int[] ans = new int[n];
        for (int k = 1; k <= n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][j] == k) ans[k-1]++;
                }
            }
        }
        return ans;
    }

    static long[][] floyd(long[][] dist) {
        int n = dist.length;
        for (int k = 0; k < n; ++k) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    // 不选 k，选 k
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int n = 3;
        int x = 1;
        int y = 3;
        System.out.println(Arrays.toString(new B().countOfPairs(n, x, y)));
    }
}
