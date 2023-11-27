package com.fqh.分组循环;

/**
 * @Author: vq
 * @Date: 2023/11/26 23:19
 * @Version V1.0
 */
public class LC_2760 {

//    2760. 最长奇偶子数组
//    第 352 场周赛
//            Q1
//    1420
//    相关标签
//            相关企业
//    提示
//    给你一个下标从 0 开始的整数数组 nums 和一个整数 threshold 。
//
//    请你从 nums 的子数组中找出以下标 l 开头、下标 r 结尾 (0 <= l <= r < nums.length) 且满足以下条件的 最长子数组 ：
//
//    nums[l] % 2 == 0
//    对于范围 [l, r - 1] 内的所有下标 i ，nums[i] % 2 != nums[i + 1] % 2
//    对于范围 [l, r] 内的所有下标 i ，nums[i] <= threshold
//    以整数形式返回满足题目要求的最长子数组的长度。
//
//    注意：子数组 是数组中的一个连续非空元素序列。

    public int longestAlternatingSubarray(int[] nums, int threshold) {
        return f(nums, threshold);
    }
    //分组循环
    int f(int[] a, int threshold) {
        int n = a.length;
        int mx = 0, i = 0;
        while (i < n) {
            if (a[i] > threshold || a[i] % 2 != 0) {
                i++;    // 跳过
                continue;
            }
            int st = i;
            for (i++; i < n && a[i] <= threshold && a[i] % 2 != a[i - 1] % 2; i++);
            mx = Math.max(mx, i - st);
        }
        return mx;
    }
}
