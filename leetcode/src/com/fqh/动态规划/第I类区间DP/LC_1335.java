package com.fqh.动态规划.第I类区间DP;

/**
 * @Author: vq
 * @Date: 2023/12/21 22:33
 * @Version V1.0
 */
public class LC_1335 {


    int[] a;
    public int minDifficulty(int[] job, int d) {
        int N = job.length;
        int K = d;
        if (N < K) return -1;
        a = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            a[i] = job[i - 1];
        }
        int[][] f = new int[N + 1][K + 1];
        for (int i = 1; i <= N; i++) {
            f[i][1] = calc(1, i);
        }
        for (int i = 1; i <= N; i++) {
            for (int k = 2; k <= Math.min(i, K); k++) {
                f[i][k] = 0x3f3f3f;
                for (int j = i; j >= k; j--) {
                    f[i][k] = Math.min(f[i][k], f[j - 1][k - 1] + calc(j, i));
                }
            }
        }
        return f[N][K];
    }

    // 计算出a[j:i]的工作最大难度
    int calc(int j, int i) {
        int mx = 0;
        for (; j <= i; j++) mx = Math.max(mx, a[j]);
        return mx;
    }


//    1335. 工作计划的最低难度
//            已解答
//    第 173 场周赛
//            Q4
//    2035
//    相关标签
//            相关企业
//    提示
//    你需要制定一份 d 天的工作计划表。工作之间存在依赖，要想执行第 i 项工作，你必须完成全部 j 项工作（ 0 <= j < i）。
//
//    你每天 至少 需要完成一项任务。工作计划的总难度是这 d 天每一天的难度之和，而一天的工作难度是当天应该完成工作的最大难度。
//
//    给你一个整数数组 jobDifficulty 和一个整数 d，分别代表工作难度和需要计划的天数。第 i 项工作的难度是 jobDifficulty[i]。
//
//    返回整个工作计划的 最小难度 。如果无法制定工作计划，则返回 -1 。
}
