package com.fqh.分组循环;

/**
 * @Author: vq
 * @Date: 2023/11/29 9:34
 * @Version V1.0
 */
public class LC_2110 {

//    2110. 股票平滑下跌阶段的数目
//            已解答
//    第 272 场周赛
//            Q3
//    1408
//    相关标签
//            相关企业
//    提示
//    给你一个整数数组 prices ，表示一支股票的历史每日股价，其中 prices[i] 是这支股票第 i 天的价格。
//
//    一个 平滑下降的阶段 定义为：对于 连续一天或者多天 ，每日股价都比 前一日股价恰好少 1 ，这个阶段第一天的股价没有限制。
//
//    请你返回 平滑下降阶段 的数目。
//
//
//
//    示例 1：
//
//    输入：prices = [3,2,1,4]
//    输出：7
//    解释：总共有 7 个平滑下降阶段：
//            [3], [2], [1], [4], [3,2], [2,1] 和 [3,2,1]
//    注意，仅一天按照定义也是平滑下降阶段。

    public long getDescentPeriods(int[] prices) {
        return f(prices);
    }

    long f(int[] a) {
        int n = a.length;
        long ans = 0;
        int i = 0;
        while (i < n) {
            int st = i;
            for (i++; i < n && a[i-1] - a[i] == 1; i++) {
                ans += i - st;
            }
            ans += i - st;
        }
        return ans;
    }
}
