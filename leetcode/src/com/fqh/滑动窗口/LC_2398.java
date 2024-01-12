package com.fqh.滑动窗口;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/12 22:55
 **/
public class LC_2398 {

    // 滑动窗口 + 有序集合
    public int maximumRobots(int[] time, int[] run, long budget) {
        var tset = new TreeSet<Integer>((a, b) -> b.compareTo(a));
        var map = new HashMap<Integer, Integer>();
        int j = 0, ans = 0;
        long s = 0;
        for (int i = 0; i < time.length; i++) {
            s += run[i];
            tset.add(time[i]);
            map.merge(time[i], 1, Integer::sum);
            while (tset.first() + (i - j + 1) * s > budget) {
                s -= run[j];
                map.merge(time[j], -1, Integer::sum);
                if (map.get(time[j]) == 0) {
                    map.remove(time[j]);
                    tset.remove(time[j]); // 从有序集合中移除
                }
                j++;
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }
//    2398. 预算内的最多机器人数目
//            尝试过
//    第 86 场双周赛
//            Q4
//    1917
//    相关标签
//            相关企业
//    提示
//    你有 n 个机器人，给你两个下标从 0 开始的整数数组 chargeTimes 和 runningCosts ，两者长度都为 n 。第 i 个机器人充电时间为 chargeTimes[i] 单位时间，花费 runningCosts[i] 单位时间运行。再给你一个整数 budget 。
//
//    运行 k 个机器人 总开销 是 max(chargeTimes) + k * sum(runningCosts) ，其中 max(chargeTimes) 是这 k 个机器人中最大充电时间，sum(runningCosts) 是这 k 个机器人的运行时间之和。
//
//    请你返回在 不超过 budget 的前提下，你 最多 可以 连续 运行的机器人数目为多少。
//
//
//
//    示例 1：
//
//    输入：chargeTimes = [3,6,1,3,4], runningCosts = [2,1,3,4,5], budget = 25
//    输出：3
//    解释：
//    可以在 budget 以内运行所有单个机器人或者连续运行 2 个机器人。
//    选择前 3 个机器人，可以得到答案最大值 3 。总开销是 max(3,6,1) + 3 * sum(2,1,3) = 6 + 3 * 6 = 24 ，小于 25 。
//    可以看出无法在 budget 以内连续运行超过 3 个机器人，所以我们返回 3 。
}
