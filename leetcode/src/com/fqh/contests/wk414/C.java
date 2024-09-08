package com.fqh.contests.wk414;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class C {

    // https://leetcode.cn/contest/weekly-contest-414/problems/reach-end-of-array-with-max-score/
    // 单调栈优化dp
    public static long findMaximumScore(List<Integer> nums) {
        int n = nums.size();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = nums.get(i);
        Deque<Integer> stk = new ArrayDeque<>();
        long[] dp = new long[n];
        for (int i = n - 1; i >= 0; i--) {
            while (stk.size() > 1 && a[stk.peek()] < a[i]) {
                stk.pop();
            }
            if (stk.isEmpty()) {
                dp[i] = 0;
            } else {
                dp[i] = dp[stk.peek()] + (long) (stk.peek() - i) * a[i];
            }
            stk.push(i);
        }
        return dp[0];
    }
}
