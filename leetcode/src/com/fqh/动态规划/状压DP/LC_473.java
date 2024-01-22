package com.fqh.动态规划.状压DP;

import java.util.Arrays;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/22 21:13
 **/
public class LC_473 {
    int n;
    int avg;
    int[] a;
    Boolean[] f;
    public boolean makesquare(int[] matchsticks) {
        n = matchsticks.length;
        a = matchsticks;
        int sum = Arrays.stream(a).sum();
        if (sum % 4 != 0) return false;
        avg = sum / 4;
        f = new Boolean[1<<n];
        return false;
    }
//    记忆化搜索 + 状态压缩
    public boolean dfs(int s, int t) {
        if (s == (1<<n)-1) return true;
        if (f[s] != null) return f[s];
        for (int i = 0; i < n; i++) {
            if ((s >> i & 1) == 1) continue;
            if (t + a[i] > avg) break;
            if (dfs(s|(1<<i), (t+a[i]) % avg)) {
                return f[s] = true;
            }
        }
        return f[s] = false;
    }

//    473. 火柴拼正方形
//            尝试过
//    中等
//            相关标签
//    相关企业
//            提示
//    你将得到一个整数数组 matchsticks ，其中 matchsticks[i] 是第 i 个火柴棒的长度。你要用 所有的火柴棍 拼成一个正方形。你 不能折断 任何一根火柴棒，但你可以把它们连在一起，而且每根火柴棒必须 使用一次 。
//
//    如果你能使这个正方形，则返回 true ，否则返回 false 。
}
