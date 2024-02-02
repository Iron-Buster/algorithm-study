package com.fqh.单调栈;

import java.util.ArrayDeque;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/2 21:47
 **/
public class LC_2334 {

    // 用单调栈求出nums[i]能够作为最小值的最长区间 [L,R]
    // 然后枚举 threashold / (R-L-1) 如果满足 < nums[i]
    // 题目要求返回任意子数组大小，则直接返回 R-L-1
    public int validSubarraySize(int[] nums, int threshold) {
        int n = nums.length;
        int[] left = new int[n+1];
        int[] right = new int[n+1];
        var stk = new ArrayDeque<Integer>();
        stk.push(-1);
        for (int i = 0; i < n; ++i) {
            while (stk.size() > 1 && nums[stk.peek()] >= nums[i]) {
                stk.pop();
            }
            left[i] = stk.peek();
            stk.push(i);
        }
        stk.clear();
        stk.push(n);
        for (int i = n - 1; i >= 0; --i) {
            while (stk.size() > 1 && nums[stk.peek()] >= nums[i]) {
                stk.pop();
            }
            right[i] = stk.peek();
            stk.push(i);
        }
        for (int i = 0; i < n; i++) {
            int l = left[i];
            int r = right[i];
            int k = r - l - 1;
            if (nums[i] > (threshold /  k)) {
                return k;
            }
        }
        return -1;
    }

//    2334. 元素值大于变化阈值的子数组
//    第 82 场双周赛
//            Q4
//    2381
//    相关标签
//            相关企业
//    提示
//    给你一个整数数组 nums 和一个整数 threshold 。
//
//    找到长度为 k 的 nums 子数组，满足数组中 每个 元素都 大于 threshold / k 。
//
//    请你返回满足要求的 任意 子数组的 大小 。如果没有这样的子数组，返回 -1 。
//
//    子数组 是数组中一段连续非空的元素序列。
}
