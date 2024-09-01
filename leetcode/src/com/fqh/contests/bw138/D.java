package com.fqh.contests.bw138;

import java.util.Arrays;

public class D {

    public static long minDamage(int power, int[] damage, int[] health) {
        int n = damage.length;
        int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = damage[i];
            a[i][1] = (health[i] + power - 1) / power;
        }
        Arrays.sort(a, (x, y) -> x[0] * y[1] - y[0] * x[1]);
        long ans = 0;
        long s = 0;
        for (int[] p : a) {
            s += p[1];
            ans += s * p[0];
        }
        return ans;
    }
}
