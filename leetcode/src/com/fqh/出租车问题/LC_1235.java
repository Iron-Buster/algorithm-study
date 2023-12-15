package com.fqh.出租车问题;

import com.fqh.BisectTemplate;

import java.util.Arrays;

/**
 * @Author: vq
 * @Date: 2023/12/15 15:55
 * @Version V1.0
 */
public class LC_1235 {

//    1235. 规划兼职工作
//            已解答
//    第 159 场周赛
//            Q4
//2023
//    相关标签
//            相关企业
//    提示
//    你打算利用空闲时间来做兼职工作赚些零花钱。
//
//    这里有 n 份兼职工作，每份工作预计从 startTime[i] 开始到 endTime[i] 结束，报酬为 profit[i]。
//
//    给你一份兼职工作表，包含开始时间 startTime，结束时间 endTime 和预计报酬 profit 三个数组，请你计算并返回可以获得的最大报酬。
//
//    注意，时间上出现重叠的 2 份工作不能同时进行。
//
//    如果你选择的工作在时间 X 结束，那么你可以立刻进行在时间 X 开始的下一份工作。

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] intervals = new int[n][3];
        for (int i = 0; i < n; i++) {
            intervals[i][0] = startTime[i];
            intervals[i][1] = endTime[i];
            intervals[i][2] = profit[i];
        }
        // WeightedIntervalScheduling模板，允许端点重合
        return weightedIntervalScheduling(intervals, true);
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
                pre[i] = bisectRight1(intervals, start, 1);
            } else {
                pre[i] = bisectLeft1(intervals, start, 1);
            }
        }
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            dp[i + 1] = Math.max(dp[i], dp[pre[i]] + intervals[i][2]);
        }
        return dp[n];
    }

    /**
     * a = [start, end, score]
     * @param a         二维数组
     * @param target    搜索的值
     * @param key       搜索的key
     * @return
     */
    public static int bisectLeft1(int[][] a, int target, int key) {
        int left = 0, right = a.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (a[mid][key] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }


    /**
     * a = [start, end, score]
     * @param a         二维数组
     * @param target    搜索的值
     * @param key       搜索的key
     * @return
     */
    public static int bisectRight1(int[][] a, int target, int key) {
        int left = 0, right = a.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (a[mid][key] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
