package com.fqh.单调栈;

import java.util.ArrayDeque;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/1 16:06
 **/
public class LC_84 {

    public int largestRectangleArea(int[] h) {
        int n = h.length;
        int[] left = new int[n + 1];
        int[] right = new int[n + 1];
        var stk = new ArrayDeque<Integer>();
        stk.push(-1);
        for (int i = 0; i < n; i++) {
            while (stk.size() > 1 && h[stk.peek()] >= h[i]) {
                stk.pop();
            }
            left[i] = stk.peek();
            stk.push(i);
        }
        stk.clear();
        stk.push(n);
        for (int i = n - 1; i >= 0; i--) {
            while (stk.size() > 1 && h[stk.peek()] >= h[i]) {
                stk.pop();
            }
            right[i] = stk.peek();
            stk.push(i);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int l = left[i] + 1;
            int r = right[i] - 1;
            ans = Math.max(ans, (r - l + 1) * h[i]);
        }
        return ans;
    }


//    84. 柱状图中最大的矩形
//            已解答
//    困难
//            相关标签
//    相关企业
//    给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
//
//    求在该柱状图中，能够勾勒出来的矩形的最大面积。
}
