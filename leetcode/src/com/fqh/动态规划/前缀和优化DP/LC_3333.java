package com.fqh.动态规划.前缀和优化DP;

import java.util.ArrayList;
import java.util.List;

public class LC_3333 {

    // https://leetcode.cn/problems/find-the-original-typed-string-ii/description/

    public int possibleStringCount(String word, int k) {
        // k很小，ans=总方案数-小于k的方案数
        int n = word.length();
        if (n < k) return 0;

        final int MOD = 1000000007;
        List<Integer> cnts = new ArrayList<>();
        long ans = 1;
        int cnt = 0;
        // 计算总方案数
        for (int i = 0; i < n; i++) {
            cnt++;
            if (i == n - 1 || word.charAt(i) != word.charAt(i + 1)) {
                if (cnts.size() < k) {
                    cnts.add(cnt);
                }
                ans = ans * cnt % MOD;
                cnt = 0;
            }
        }
        System.out.println(cnts);
        int m = cnts.size();
        if (m >= k) return (int) ans;

        int[][] f = new int[m+1][k];
        f[0][0] = 1;
        int[] s = new int[k+1];
        // 计算小于k的方案数
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < k; j++) {
                s[j+1] = (s[j] + f[i][j]) % MOD;
            }
            int c = cnts.get(i);
            for (int j = i + 1; j < k; j++) {
                f[i+1][j] = (s[j] - s[Math.max(j-c, 0)]) % MOD;
            }
        }

        for (int j = m; j < k; j++) {
            ans -= f[m][j];
        }
        return (int) ((ans % MOD + MOD) % MOD);
    }
}
