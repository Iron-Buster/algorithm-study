package com.fqh.单调栈.单调栈求贡献;

import java.util.ArrayDeque;

/**
 * @Author: vq
 * @Date: 2023/11/27 11:07
 * @Version V1.0
 */
public class LC_907 {
//    907. 子数组的最小值之和
//                尝试过
//        第 102 场周赛
//                Q3
//    1976
//    相关标签
//            相关企业
//    给定一个整数数组 arr，找到 min(b) 的总和，其中 b 的范围为 arr 的每个（连续）子数组。
//
//    由于答案可能很大，因此 返回答案模 10^9 + 7 。
//
//
//
//    示例 1：
//
//    输入：arr = [3,1,2,4]
//    输出：17
//    解释：
//    子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。
//    最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。

    static final int MOD = 1000000007;
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        var left = new int[n + 1];  // left[i] 表示左边第一个小于 arr[i]的下标
        var right = new int[n + 1]; // right[i] 表示右边第一个小于 arr[i]的下标
        var stk = new ArrayDeque<Integer>();
        stk.push(-1);
        for (int i = 0; i < n; ++i) {
            while (stk.size() > 1 && arr[stk.peek()] >= arr[i]) {
                stk.pop();
            }
            left[i] = stk.peek();
            stk.push(i);
        }
        stk.clear();
        stk.push(n);
        for (int i = n - 1; i >= 0; --i) {
            while (stk.size() > 1 && arr[stk.peek()] > arr[i]) { // 这里取 > 避免重复统计
                stk.pop();
            }
            right[i] = stk.peek();
            stk.push(i);
        }
        long ans = 0;
        for (int i = 0; i < n; ++i) {
            // arr[i] 左边的贡献是 (i - left[i]) 记作 x
            // arr[i] 右边的贡献是 (right[i] - i) 记作 y
            // 根据乘法原理 arr[i]的贡献 = arr[i] * x * y
            ans += (long) arr[i] * (i - left[i]) * (right[i] - i);
            ans %= MOD;
        }
        return (int) ans;
    }

    public static void main(String[] args) {

    }
}
