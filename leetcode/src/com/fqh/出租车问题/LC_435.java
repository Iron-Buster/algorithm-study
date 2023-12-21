package com.fqh.出租车问题;

import com.fqh.BisectTemplate;

import java.util.Arrays;

/**
 * @Author: vq
 * @Date: 2023/12/21 22:53
 * @Version V1.0
 */
public class LC_435 {

    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        int[][] a = new int[n][3];
        for (int i = 0; i < n; i++) {
            a[i][0] = intervals[i][0];
            a[i][1] = intervals[i][1];
            a[i][2] = 1;
        }
        // 因为每个区间的权值都是1，求出无重叠区间的最大长度mx
        // 需要移除的区间最小数量 = n - mx
        return n - weightedIntervalScheduling(a, true);
    }

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



//    435. 无重叠区间
//            中等
//    相关标签
//            相关企业
//    给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重叠 。
}
