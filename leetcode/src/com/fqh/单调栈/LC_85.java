package com.fqh.单调栈;

import java.util.ArrayDeque;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/6 19:34
 **/
public class LC_85 {

    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] h = new int[m];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    h[j] += 1; // 累加上列的高度
                } else {
                    h[j] = 0;
                }
            }
            ans = Math.max(ans, largestRectangleArea(h));
        }
        return ans;
    }

    // LC84. 柱状图中最大的矩形
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

//    85. 最大矩形
//            困难
//    相关标签
//            相关企业
//    给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
}
