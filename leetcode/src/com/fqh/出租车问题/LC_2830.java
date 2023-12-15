package com.fqh.出租车问题;

import com.fqh.BisectTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: vq
 * @Date: 2023/12/15 15:30
 * @Version V1.0
 */
public class LC_2830 {


//    2830. 销售利润最大化
//            已解答
//    第 359 场周赛
//            Q3
//1851
//    相关标签
//            相关企业
//    提示
//    给你一个整数 n 表示数轴上的房屋数量，编号从 0 到 n - 1 。
//
//    另给你一个二维整数数组 offers ，其中 offers[i] = [starti, endi, goldi] 表示第 i 个买家想要以 goldi 枚金币的价格购买从 starti 到 endi 的所有房屋。
//
//    作为一名销售，你需要有策略地选择并销售房屋使自己的收入最大化。
//
//    返回你可以赚取的金币的最大数目。
//
//    注意 同一所房屋不能卖给不同的买家，并且允许保留一些房屋不进行出售。
//
//
//
//    示例 1：
//
//    输入：n = 5, offers = [[0,0,1],[0,2,2],[1,3,2]]
//    输出：3
//    解释：
//    有 5 所房屋，编号从 0 到 4 ，共有 3 个购买要约。
//    将位于 [0,0] 范围内的房屋以 1 金币的价格出售给第 1 位买家，并将位于 [1,3] 范围内的房屋以 2 金币的价格出售给第 3 位买家。
//    可以证明我们最多只能获得 3 枚金币。
public int maximizeTheProfit(int n, List<List<Integer>> offers) {
    int[][] intervals = new int[offers.size()][3];
    for (int i = 0; i < offers.size(); i++) {
        intervals[i][0] = offers.get(i).get(0);
        intervals[i][1] = offers.get(i).get(1);
        intervals[i][2] = offers.get(i).get(2);
    }
    // 这题区间端点不能重复
    return weightedIntervalScheduling(intervals, false);
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

    public static void main(String[] args) {
    }

}
