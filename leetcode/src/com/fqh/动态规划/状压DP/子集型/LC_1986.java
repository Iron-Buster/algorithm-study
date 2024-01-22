package com.fqh.动态规划.状压DP.子集型;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/22 15:32
 **/
public class LC_1986 {

//    1986. 完成任务的最少工作时间段
//    第 256 场周赛
//            Q3
//1995
//    相关标签
//            相关企业
//    提示
//    你被安排了 n 个任务。任务需要花费的时间用长度为 n 的整数数组 tasks 表示，第 i 个任务需要花费 tasks[i] 小时完成。
//    一个 工作时间段 中，你可以 至多 连续工作 sessionTime 个小时，然后休息一会儿。
//
//    你需要按照如下条件完成给定任务：
//
//    如果你在某一个时间段开始一个任务，你需要在 同一个 时间段完成它。
//    完成一个任务后，你可以 立马 开始一个新的任务。
//    你可以按 任意顺序 完成任务。
//    给你 tasks 和 sessionTime ，请你按照上述要求，返回完成所有任务所需要的 最少 数目的 工作时间段 。
//
//    测试数据保证 sessionTime 大于等于 tasks[i] 中的 最大值 。
//
//
//
//    示例 1：
//
//    输入：tasks = [1,2,3], sessionTime = 3
//    输出：2
//    解释：你可以在两个工作时间段内完成所有任务。
//            - 第一个工作时间段：完成第一和第二个任务，花费 1 + 2 = 3 小时。
//            - 第二个工作时间段：完成第三个任务，花费 3 小时。
    public int minSessions(int[] tasks, int sessionTime) {
        int n = tasks.length;
        int[] f = new int[1<<n];
        boolean[] ok = new boolean[1<<n]; // 标识合法的状态
        for (int s = 0; s < 1<<n; s++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if ((s >> j & 1) == 1) {
                    sum += tasks[j];
                }
            }
            if (sum <= sessionTime) {
                ok[s] = true;
            }
        }
        for (int s = 1; s < 1<<n; s++) {
            f[s] = Integer.MAX_VALUE;
            for (int sub = s; sub > 0; sub=(sub-1)&s) {
                if (ok[sub]) {
                    f[s] = Math.min(f[s], f[s^sub]+1);
                }
           }
        }
        return f[(1<<n)-1];
    }

    public static void main(String[] args) {
        int[] tasks = {1,2,3};
        int k = 3;
        System.out.println(new LC_1986().minSessions(tasks, k));
    }
}
