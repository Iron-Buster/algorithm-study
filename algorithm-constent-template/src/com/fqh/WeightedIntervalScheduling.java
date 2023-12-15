package com.fqh;

/**
 * @Author: vq
 * @Date: 2023/12/15 12:27
 * @Version V1.0
 */

import java.util.Arrays;

/**
 * 带权区间问题
 *
 * 带权区间选择问题 线性 dp+二分查找优化
 * 每个区间选还是不选(to jump or not to jump)
 *
 * 按结束时间排序,dp[i]表示前 i 个区间的最优解
 * 遍历，如果不选当前区间，dp[i] = dp[i-1]
 * //如果选当前区间，bisectRight 找到之前的最右区间 j，dp[i] = dp[j] + w[i]，其中 j 是最后一个不相交的区间，w[i]是当前区间的权重
 */
public class WeightedIntervalScheduling {

//# Interval Scheduling (weighted)
//# 安排会议问题
//# 不重叠区间的最大和(出租车问题)
//# 给定 N 个闭区间 [ai,bi,scorei]，请你在数轴上选择若干区间，
//            # !使得选中的区间之间互不相交（端点不可重合）。
//            # 输出可选取区间的最大权值和。

//    给定 n 个闭区间 [left_i,right_i,score_i].
//    请你在数轴上选择若干区间,使得选中的区间之间互不相交.
//    返回可选取区间的最大权值和.

//    Args:
//        intervals: 区间列表,每个区间为[left,right,score].
//        overlapping: 是否允许选择的区间端点重合.默认为False.
//    """
    /**
     * @param intervals 区间列表,每个区间为[left,right,score].
     * @param overlap   是否允许选择的区间端点重合.默认为False.
     * @return
     */
    public static int weightedIntervalScheduling(int[][] intervals, boolean overlap) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int[] pre = new int[n];
//        f = bisect_right if overlap else bisect_left
        for (int i = 0; i < n; i++) {
            int start = intervals[i][0];
//            pre[i] = f(intervals, start, key=lambda x: x[1])
            if (overlap) {
                pre[i] = BisectTemplate.bisectRight1(intervals, start, 1);
            } else {
                pre[i] = BisectTemplate.bisectLeft1(intervals, start, 1);
            }
        }
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            dp[i + 1] = Math.max(dp[i], dp[pre[i]] + intervals[i][2]);
        }
        return dp[n];
    }


}


