package com.fqh.动态规划.单调队列优化;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC_1696 {


    // https://leetcode.cn/problems/jump-game-vi/description/

    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        Deque<int[]> q = new ArrayDeque<>();
        dp[0] = nums[0];
        q.addLast(new int[]{0, nums[0]});
        for (int i = 1; i < n; i++) {
            dp[i] = nums[i];
            // 维护差值小于k
            while (!q.isEmpty() && i - q.getFirst()[0] > k) {
                q.removeFirst();
            }
            // 计算状态转移
            if (!q.isEmpty()) {
                dp[i] = q.getFirst()[1] + nums[i];
            }
            // 维护单调性
            while (!q.isEmpty() && q.getLast()[1] <= dp[i]) {
                q.removeLast();
            }
            // 入队
            q.addLast(new int[]{i, dp[i]});
        }
        return dp[n-1];
    }

    public static void main(String[] args) {

    }
}
