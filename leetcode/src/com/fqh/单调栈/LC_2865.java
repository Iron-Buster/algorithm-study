package com.fqh.单调栈;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/24 11:00
 **/
public class LC_2865 {

    // 单调栈先求出以i为最小值，左右能够到达的最远下标。
    // 前后缀分解
    // a[i]表示以i结尾的前缀贡献，如果i前面没有比它小的数，那么a[i] = i * h[i]，否则a[i] = (i-l) * h[i] + a[l];
    // b[i]表示以i结尾的后缀贡献，如果i后面没有比它小的数，那么b[i] = i * h[i]，否则b[i] = (r-i) * h[i] + b[r];
    // a[l]和b[r]在前面都是被算出来过的。最后算贡献的时候要减去一个h[i]，因为h[i]被加了两次
    public long maximumSumOfHeights(List<Integer> h) {
        int n = h.size();
        int[] left = new int[n+1];
        int[] right = new int[n+1];
        var stk = new ArrayDeque<Integer>();
        stk.push(-1);
        for (int i = 0; i < n; i++) {
            while (stk.size() > 1 && h.get(stk.peek()) > h.get(i)) {
                stk.pop();
            }
            left[i] = stk.peek();
            stk.push(i);
        }
        stk.clear();
        stk.push(n);
        for (int i = n - 1; i >= 0; i--) {
            while (stk.size() > 1 && h.get(stk.peek()) > h.get(i)) {
                stk.pop();
            }
            right[i] = stk.peek();
            stk.push(i);
        }
        // 前后缀分解
        long[] a = new long[n];
        long[] b = new long[n];
        a[0] = h.get(0);
        for (int i = 1; i < n; i++) {
            int l = left[i];
            a[i] = (long) (i - l) * h.get(i);
            if (l != -1) a[i] += a[left[i]];
        }
        b[n-1] = h.get(n-1);
        for (int i = n - 2; i >= 0; i--) {
            int r = right[i];
            b[i] = (long) (r - i) * h.get(i);
            if (r != n) b[i] += b[right[i]];
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, a[i] + b[i] - h.get(i)); // h[i]被加了两次，这里减去1次
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LC_2865().maximumSumOfHeights(List.of(3, 2, 5, 5, 2, 3)));
    }

//    2866. 美丽塔 I
//    已解答
//    第 364 场周赛
//            Q2
//
//    相关标签
//            相关企业
//    提示
//    给你一个长度为 n 下标从 0 开始的整数数组 maxHeights 。
//
//    你的任务是在坐标轴上建 n 座塔。第 i 座塔的下标为 i ，高度为 heights[i] 。
//
//    如果以下条件满足，我们称这些塔是 美丽 的：
//
//            1 <= heights[i] <= maxHeights[i]
//    heights 是一个 山脉 数组。
//    如果存在下标 i 满足以下条件，那么我们称数组 heights 是一个 山脉 数组：
//
//    对于所有 0 < j <= i ，都有 heights[j - 1] <= heights[j]
//    对于所有 i <= k < n - 1 ，都有 heights[k + 1] <= heights[k]
//    请你返回满足 美丽塔 要求的方案中，高度和的最大值 。
}
