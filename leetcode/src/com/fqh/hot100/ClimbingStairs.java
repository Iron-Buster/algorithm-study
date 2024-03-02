package com.fqh.hot100;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/2 17:45
 **/
public class ClimbingStairs {

    public int climbStairs(int n) {
        int[] f = new int[n+1];
        f[0] = f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i-1] + f[i-2];
         }
        return f[n];
    }
}
