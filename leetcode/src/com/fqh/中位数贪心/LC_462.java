package com.fqh.中位数贪心;

import java.util.Arrays;

/**
 * @Author: vq
 * @Date: 2023/12/17 13:52
 * @Version V1.0
 */
public class LC_462 {


//    462. 最小操作次数使数组元素相等 II
//    中等
//            相关标签
//    相关企业
//    给你一个长度为 n 的整数数组 nums ，返回使所有数组元素相等需要的最小操作数。
//
//    在一次操作中，你可以使数组中的一个元素加 1 或者减 1 。
//
//
//
//    示例 1：
//
//    输入：nums = [1,2,3]
//    输出：2
//    解释：
//    只需要两次操作（每次操作指南使一个元素加 1 或减 1）：
//            [1,2,3]  =>  [2,2,3]  =>  [2,2,2]

    // 中位数贪心
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int mid = nums[n / 2];
        int ans = 0;
        for (int x : nums) {
            ans += Math.abs(x - mid);
        }
        return ans;
    }
}
