package com.fqh.滑动窗口.定长滑动窗口;

import java.security.Key;
import java.util.Arrays;

/**
 * @Author: vq
 * @Date: 2023/12/18 14:05
 * @Version V1.0
 */
public class LC_2090 {

//    2090. 半径为 k 的子数组平均值
//    第 269 场周赛
//            Q2
//1358
//    相关标签
//            相关企业
//    提示
//    给你一个下标从 0 开始的数组 nums ，数组中有 n 个整数，另给你一个整数 k 。
//
//    半径为 k 的子数组平均值 是指：nums 中一个以下标 i 为 中心 且 半径 为 k 的子数组中所有元素的平均值，
//    即下标在 i - k 和 i + k 范围（含 i - k 和 i + k）内所有元素的平均值。如果在下标 i 前或后不足 k 个元素，那么 半径为 k 的子数组平均值 是 -1 。
//
//    构建并返回一个长度为 n 的数组 avgs ，其中 avgs[i] 是以下标 i 为中心的子数组的 半径为 k 的子数组平均值 。
//
//    x 个元素的 平均值 是 x 个元素相加之和除以 x ，此时使用截断式 整数除法 ，即需要去掉结果的小数部分。
//
//    例如，四个元素 2、3、1 和 5 的平均值是 (2 + 3 + 1 + 5) / 4 = 11 / 4 = 2.75，截断后得到 2

//    输入：nums = [7,4,3,9,1,8,5,2,6], k = 3
//23 + 14 = 37 / 7 = 6
//    输出：[-1,-1,-1,5,4,4,-1,-1,-1]

    // 前缀和
    public static long[] prefixSum(int[] a) {
        long[] sum = new long[a.length + 1];
        for (int i = 0; i < a.length; i++) {
            sum[i + 1] = sum[i] + a[i];
        }
        return sum;
    }

    // 后缀和
    public static long[] suffixSum(int[] a) {
        long[] sum = new long[a.length + 1];
        for (int i = a.length - 1; i >= 0; i--) {
            sum[i] = sum[i + 1] + a[i];
        }
        return sum;
    }

    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        long[] pre = prefixSum(nums);
        long[] suf = suffixSum(nums);
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if (i - k < 0 || i + k + 1 > n) {
                ans[i] = -1;
            } else {
                long left = pre[i + 1] - pre[i - k];
                long right = suf[i + 1] - suf[i + k + 1];
                ans[i] = (int) ((left + right) / (2 * k + 1));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {7,4,3,9,1,8,5,2,6};
        System.out.println(Arrays.toString(new LC_2090().getAverages(nums, 3)));
    }
}
