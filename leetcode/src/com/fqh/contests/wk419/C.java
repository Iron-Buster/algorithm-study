package com.fqh.contests.wk419;

import java.util.Arrays;

public class C {

    int[][][] f;
    static final int MOD = (int) (1e9 + 7);
    int BIG = 0;
    char[] al;

    public int countWinningSequences(String s) {
        int n = s.length();
        al = s.toCharArray();
        BIG = n + 1;
        int m = 'W'-'A';
        f = new int[n][n+BIG][m];
        for (int[][] arr : f) {
            for (int[] row : arr) {
                Arrays.fill(row, -1);
            }
        }
        return dfs(0, 0, 'A');
    }

    public int dfs(int i, int val, char prev) {
        if (i >= al.length) return val > 0 ? 1 : 0;
        if (f[i][val+BIG][prev-'A'] != -1) return f[i][val+BIG][prev-'A'];
        int ret = 0;
        if (al[i] == 'F') {
            if (prev != 'E')  ret += dfs(i + 1, val - 1, 'E');  ret %= MOD;
            if (prev != 'F') ret += dfs(i + 1, val, 'F');           ret %= MOD;
            if (prev != 'W') ret += dfs(i + 1, val + 1, 'W');   ret %= MOD;
        } else if (al[i] == 'W') {
            if (prev != 'F') ret += dfs(i + 1, val - 1, 'F');    ret %= MOD;
            if (prev != 'W') ret += dfs(i + 1, val, 'W');            ret %= MOD;
            if (prev != 'E') ret += dfs(i + 1, val + 1, 'E');    ret %= MOD;
        } else {
            if (prev != 'W') ret += dfs(i + 1, val - 1, 'W');     ret %= MOD;
            if (prev != 'E') ret += dfs(i + 1, val, 'E');             ret %= MOD;
            if (prev != 'F') ret += dfs(i + 1, val + 1, 'F');     ret %= MOD;
        }
        f[i][val+BIG][prev-'A'] = ret;
        return ret;
    }
}
