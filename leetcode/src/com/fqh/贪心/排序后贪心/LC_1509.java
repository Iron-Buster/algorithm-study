package com.fqh.贪心.排序后贪心;

import java.util.Arrays;

/**
 * @Author: vq
 * @Date: 2023/12/17 18:40
 * @Version V1.0
 */
public class LC_1509 {

//    1509. 三次操作后最大值与最小值的最小差
//            已解答
//    第 30 场双周赛
//            Q3
//1653
//    相关标签
//            相关企业
//    提示
//    给你一个数组 nums 。
//
//    每次操作你可以选择 nums 中的任意一个元素并将它改成 任意值 。
//
//    在 执行最多三次移动后 ，返回 nums 中最大值与最小值的最小差值。

    public int minDifference(int[] a) {
        int n = a.length;
        if (n - 1 <= 3) return 0;
        Arrays.sort(a);
        // 0 1 5 10 14
        // 20 75 81 82 95
        // 82 82 81 82 82
        // 81 81 81 82 81
        // case1: 将左边3个，或右边3个连续数字修改的最小答案
        int ans1 = Math.min(a[n-4] - a[0], a[n-1] - a[3]);
        // case2: 左边修改1个右边修改2个，左边修改2个右边修改1个
        int ans2 = Math.min(a[n-3] - a[1], a[n-2] - a[2]);
        return Math.min(ans1, ans2);
    }
}
