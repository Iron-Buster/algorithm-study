package com.fqh.动态规划.状态机DP;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/4/9 23:23
 **/
public class LC_2222 {

//    https://leetcode.cn/problems/number-of-ways-to-select-buildings/description/



    Long[][][] dp;
    char[] s;
    public long numberOfWays(String str) {
        int n = str.length();
        s = str.toCharArray();
        dp = new Long[n+1][3][3];
        return dfs(0, 2, 0);
    }

    public long dfs(int i, int pre, int cnt) {
        if (cnt == 3) return 1;
        if (i >= s.length) return 0;
        if (dp[i][pre][cnt] != null) return dp[i][pre][cnt];
        long ans = 0;
        // 不选
        ans += dfs(i + 1, pre, cnt);
        // 选
        if (s[i] - '0' != pre) {
            ans += dfs(i + 1, s[i] - '0', cnt + 1);
        }
        return dp[i][pre][cnt] = ans;
    }
}
