package com.fqh.单调栈;

import java.util.ArrayDeque;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/1 16:06
 **/
public class LC_84 {

    int[] left = new int[100010];  // left[i]保存左边第一个比h[i]小的元素下标
    int[] right = new int[100010]; // right[i]保存右边第一个比h[i]小的元素下标
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        var h = new int[n + 2];
        h[0] = h[n + 1] = -1; // 哨兵节点 不用考虑边界问题
        for (int i = 1; i <= n; ++i) h[i] = heights[i - 1];
        var stack = new ArrayDeque<Integer>();
        stack.push(0);
        for (int i = 1; i <= n; ++i) {
            while (h[stack.peek()] >= h[i]) stack.pop();
            left[i] = stack.peek() + 1;
            stack.push(i);
        }
        stack.clear();
        stack.push(n + 1);
        for (int i = n; i >= 1; --i) {
            while (h[stack.peek()] >= h[i]) stack.pop();
            right[i] = stack.peek() - 1;
            stack.push(i);
        }
        int ans = 0;
        for (int i = 1; i <= n; ++i) {
            ans = Math.max(ans, h[i] * (right[i] - left[i] + 1));
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
