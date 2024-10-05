package com.fqh.动态规划.单调队列优化;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/7 17:39
 **/
public class LC_1425 {

//    1425. 带限制的子序列和
//    第 186 场周赛
//            Q4
//    2032
//    相关标签
//            相关企业
//    提示
//    给你一个整数数组 nums 和一个整数 k ，请你返回 非空 子序列元素和的最大值，子序列需要满足：
//    子序列中每两个 相邻 的整数 nums[i] 和 nums[j] ，它们在原数组中的下标 i 和 j 满足 i < j 且 j - i <= k 。
//
//    数组的子序列定义为：将数组中的若干个数字删除（可以删除 0 个数字），剩下的数字按照原本的顺序排布。
//
//
//
//    示例 1：
//
//    输入：nums = [10,2,-10,5,20], k = 2
//    输出：37
//    解释：子序列为 [10, 2, 5, 20] 。

    public int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        Deque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            dp[i] = nums[i];
            // 维护差值小于k
            while (!q.isEmpty() && i - q.getFirst()[0] > k) {
                q.removeFirst();
            }
            // 计算状态转移
            if (!q.isEmpty()) {
                dp[i] = Math.max(dp[i], q.getFirst()[1] + nums[i]);
            }
            // 维护单调性
            while (!q.isEmpty() && q.getLast()[1] <= dp[i]) {
                q.removeLast();
            }
            // 入队
            q.addLast(new int[]{i, dp[i]});
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        int[] nums = {-7609,249,-1699,2385,9125,-9037,1107,-8228,856,-9526};
        int k = 9;
        System.out.println(new LC_1425().constrainedSubsetSum(nums, k));
    }
}
