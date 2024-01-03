package com.fqh.单调栈;

import java.util.ArrayDeque;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/3 14:13
 **/
public class LC_1856 {
    static final int MOD = (int) (1e9 + 7);

    // 对于每一个nums[i]
    // 用单调栈求出nums[i]能够作为最小值的最长区间 [L,R]
    // 然后预处理出前缀和数组sum
    // 然后枚举每一个nums[i]作为 min(nums[i:j]) * sum[i:j] 的答案，取一个最大的
    public int maxSumMinProduct(int[] a) {
        int n = a.length;
        int[] left = new int[n+1];
        int[] right = new int[n+1];
        long[] s = new long[n+1];
        for (int i = 0; i < n; i++) {
            s[i+1] = s[i] + a[i];
        }
        var stk = new ArrayDeque<Integer>();
        stk.push(-1);
        for (int i = 0; i < n; i++) {
            while (stk.size() > 1 && a[stk.peek()] >= a[i]) {
                stk.pop();
            }
            left[i] = stk.peek();
            stk.push(i);
        }
        stk.clear();
        stk.push(n);
        for (int i = n - 1; i >= 0; i--) {
            while (stk.size() > 1 && a[stk.peek()] >= a[i]) {
                stk.pop();
            }
            right[i] = stk.peek();
            stk.push(i);
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int l = left[i];
            int r = right[i];
            ans = Math.max(ans, a[i] * (s[r] - s[l+1]));
        }
        return (int) (ans % MOD);
    }

//    1856. 子数组最小乘积的最大值
//    第 240 场周赛
//            Q3
//    2051
//    相关标签
//            相关企业
//    提示
//    一个数组的 最小乘积 定义为这个数组中 最小值 乘以 数组的 和 。
//
//    比方说，数组 [3,2,5] （最小值是 2）的最小乘积为 2 * (3+2+5) = 2 * 10 = 20 。
//    给你一个正整数数组 nums ，请你返回 nums 任意 非空子数组 的最小乘积 的 最大值 。由于答案可能很大，请你返回答案对  109 + 7 取余 的结果。
//
//    请注意，最小乘积的最大值考虑的是取余操作 之前 的结果。题目保证最小乘积的最大值在 不取余 的情况下可以用 64 位有符号整数 保存。
//
//    子数组 定义为一个数组的 连续 部分。
//
//
//
//    示例 1：
//
//    输入：nums = [1,2,3,2]
//    输出：14
//    解释：最小乘积的最大值由子数组 [2,3,2] （最小值是 2）得到。
//            2 * (2+3+2) = 2 * 7 = 14 。

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 2};
        System.out.println(new LC_1856().maxSumMinProduct(a));
    }
}
