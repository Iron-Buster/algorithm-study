package com.fqh.出租车问题;

import com.fqh.BisectTemplate;

import java.util.*;

/**
 * @Author: vq
 * @Date: 2023/12/8 9:31
 * @Version V1.0
 */
public class LC_2008 {


//    2008. 出租车的最大盈利
//            已解答
//    第 61 场双周赛
//            Q3
//    1872
//    相关标签
//            相关企业
//    提示
//    你驾驶出租车行驶在一条有 n 个地点的路上。这 n 个地点从近到远编号为 1 到 n ，你想要从 1 开到 n ，通过接乘客订单盈利。你只能沿着编号递增的方向前进，不能改变方向。
//
//    乘客信息用一个下标从 0 开始的二维数组 rides 表示，其中 rides[i] = [starti, endi, tipi] 表示第 i 位乘客需要从地点 starti 前往 endi ，愿意支付 tipi 元的小费。
//
//    每一位 你选择接单的乘客 i ，你可以 盈利 endi - starti + tipi 元。你同时 最多 只能接一个订单。
//
//    给你 n 和 rides ，请你返回在最优接单方案下，你能盈利 最多 多少元。
//
//    注意：你可以在一个地点放下一位乘客，并在同一个地点接上另一位乘客。

    public long maxTaxiEarnings(int n, int[][] rides) {
        for (int[] ride : rides) {
            int start = ride[0], end = ride[1], tipi = ride[2];
            ride[2] = end - start + tipi;
        }
        //WeightedIntervalScheduling模板，允许端点重合
        return weightedIntervalScheduling(rides, true);
    }

    /**
     * @param intervals 区间列表,每个区间为[left,right,score].
     * @param overlap   是否允许选择的区间端点重合.默认为False.
     * @return
     */
    static int weightedIntervalScheduling(int[][] intervals, boolean overlap) {
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
