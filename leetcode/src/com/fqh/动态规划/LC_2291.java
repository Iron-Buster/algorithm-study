package com.fqh.动态规划;

import java.util.Arrays;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/19 23:41
 **/
public class LC_2291 {
//    2291. 最大股票收益
//            已解答
//    中等
//            相关标签
//    相关企业
//            提示
//    给你两个下标从 0 开始的数组 present 和 future ，
//    present[i] 和 future[i] 分别代表第 i 支股票现在和将来的价格。每支股票你最多购买 一次 ，你的预算为 budget 。
//
//    求最大的收益。

//    示例 1：
//
//    输入：present = [5,4,6,2,3], future = [8,5,4,3,5], budget = 10
//    输出：6
//    解释：你可以选择购买第 0,3,4 支股票获得最大收益：6 。总开销为：5 + 2 + 3 = 10 , 总收益是: 8 + 3 + 5 - 10 = 6 。

    int[] vv;
    int[][] f = new int[1001][1001];
    public int maximumProfit(int[] a, int[] b, int budget) {
        vv = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            vv[i] = b[i] - a[i];
            Arrays.fill(f[i], -1);
        }
        return dfs(0, budget, a);
    }

    int dfs(int i, int remain, int[] a) {
        if (i >= vv.length) return 0;
        if (f[i][remain] != -1) {
            return f[i][remain];
        }
        int ans = dfs(i + 1, remain, a); // 不选
        if (remain - a[i] >= 0) {
            ans = Math.max(ans, dfs(i + 1, remain - a[i], a) + vv[i]); // 选
        }
        return f[i][remain] = ans;
    }
}
