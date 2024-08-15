package com.fqh.单调栈;

import java.util.ArrayDeque;

public class LC_739 {

    //https://leetcode.cn/problems/daily-temperatures/description/

    public int[] dailyTemperatures(int[] t) {
        var stk = new ArrayDeque<Integer>();
        int n = t.length;
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!stk.isEmpty() && t[i] >= t[stk.peek()]) {
                stk.pop();
            }
            ans[i] = stk.isEmpty() ? 0 : stk.peek() - i;
            stk.push(i);
        }
        return ans;
    }
}
