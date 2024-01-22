package com.fqh.动态规划.状压DP.子集型;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/22 14:46
 **/
public class LC_1723 {

//    1723. 完成所有工作的最短时间
//            已解答
//    第 223 场周赛
//            Q4
//2284
//    相关标签
//            相关企业
//    提示
//    给你一个整数数组 jobs ，其中 jobs[i] 是完成第 i 项工作要花费的时间。
//
//    请你将这些工作分配给 k 位工人。所有工作都应该分配给工人，且每项工作只能分配给一位工人。
//    工人的 工作时间 是完成分配给他们的所有工作花费时间的总和。请你设计一套最佳的工作分配方案，使工人的 最大工作时间 得以 最小化 。
//
//    返回分配方案中尽可能 最小 的 最大工作时间 。
//
//
//
//    示例 1：
//
//    输入：jobs = [3,2,3], k = 3
//    输出：3
//    解释：给每位工人分配一项工作，最大工作时间是 3 。

    public int minimumTimeRequired(int[] jobs, int k) {
        int n = jobs.length;
        int[][] f = new int[k][1<<n];
        int[] cost = new int[1<<n];
        for (int s = 0; s < 1<<n; s++) {
            for (int j = 0; j < n; j++) {
                if ((s >> j & 1) == 1) { // 第j项工作在集合s中
                    cost[s] += jobs[j];
                }
            }
        }
        // 初始化
        for (int s = 0; s < 1<<n; s++) {
            f[0][s] = cost[s];
        }
        for (int i = 1; i < k; i++) {
            for (int s = 0; s < 1<<n; s++) {
                f[i][s] = Integer.MAX_VALUE;
                for (int sub = s; sub > 0; sub=(sub-1)&s) { // 枚举决策
                    f[i][s] = Math.min(f[i][s], Math.max(f[i-1][s^sub], cost[sub]));
                }
            }
        }
        return f[k-1][(1<<n)-1];
    }
}
