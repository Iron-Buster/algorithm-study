package com.fqh.滑动窗口.定长滑动窗口;

import java.util.Arrays;

/**
 * @Author: vq
 * @Date: 2023/12/17 20:58
 * @Version V1.0
 */
public class LC_1984 {

//    1984. 学生分数的最小差值
//            已解答
//    第 256 场周赛
//            Q1
//1306
//    相关标签
//            相关企业
//    提示
//    给你一个 下标从 0 开始 的整数数组 nums ，其中 nums[i] 表示第 i 名学生的分数。另给你一个整数 k 。
//
//    从数组中选出任意 k 名学生的分数，使这 k 个分数间 最高分 和 最低分 的 差值 达到 最小化 。
//
//    返回可能的 最小差值 。

    //定长滑动窗口
    public int minimumDifference(int[] a, int k) {
        Arrays.sort(a);
        int j = 0, ans = Integer.MAX_VALUE;
        int mx = Integer.MIN_VALUE;
        int mn = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            mx = Math.max(mx, a[i]);
            mn = Math.min(mn, a[i]);
            if (i - j + 1 > k) {
                mn = a[++j];
            }
            if (i - j + 1 == k) {
                ans = Math.min(ans, mx - mn);
            }
        }
        return ans;
    }
}
