package com.fqh.contests.bw124;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/28 23:10
 **/
public class C {

    int[] a;
    Integer[][] f;
    public int maxOperations(int[] nums) {
        a = nums;
        int n = a.length;
        f = new Integer[n+1][n+1];
        int res1 = dfs(2, n - 1, a[0] + a[1]);
        int res2 = dfs(0, n - 3, a[n-1] + a[n-2]);
        int res3 = dfs(1, n - 2, a[0] + a[n-1]);
        return Math.max(res1, Math.max(res2, res3)) + 1;
    }

    int dfs(int i, int j, int v) {
        if (i >= j) return 0;
        if (f[i][j] != null) return f[i][j];
        int ans = 0;
        if (a[i] + a[i+1] == v) {
            ans = Math.max(ans, dfs(i + 2, j, v) + 1);
        }
        if (a[j] + a[j-1] == v) {
            ans = Math.max(ans, dfs(i, j - 2, v) + 1);
        }
        if (a[i] + a[j] == v) {
            ans = Math.max(ans, dfs(i + 1, j - 1, v) + 1);
        }
        return f[i][j] = ans;
    }
}
