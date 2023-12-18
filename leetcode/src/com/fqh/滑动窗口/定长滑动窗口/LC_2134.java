package com.fqh.滑动窗口.定长滑动窗口;

import java.util.Arrays;

/**
 * @Author: vq
 * @Date: 2023/12/18 16:18
 * @Version V1.0
 */
public class LC_2134 {

//    定长滑动窗口
    // 先破环成链
    // 最少交换次数 = nums中所有1的个数 - 链中最大连续1的个数 （这个可以使用滑动窗口求解）
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[] a = new int[n * 2];
        a = Arrays.copyOfRange(nums, 0, a.length);
        for (int i = n, j = 0; i < a.length; i++, j++) {
            a[i] = nums[j];
        }
        int k = 0;  // 窗口大小
        for (int x : nums) k += x;
        int ans = 0, cnt = 0, j = 0;
        for (int i = 0; i < a.length; i++) {
            cnt += a[i];
            if (i - j + 1 > k) {
                cnt -= a[j++];
            }
            if (i - j + 1 == k) {
                ans = Math.max(ans, cnt);
            }
        }
        return k - ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,0,0,1};
        System.out.println(new LC_2134().minSwaps(nums));
    }

//    2134. 最少交换次数来组合所有的 1 II
//    第 275 场周赛
//            Q2
//    1748
//    相关标签
//            相关企业
//    提示
//    交换 定义为选中一个数组中的两个 互不相同 的位置并交换二者的值。
//
//    环形 数组是一个数组，可以认为 第一个 元素和 最后一个 元素 相邻 。
//
//    给你一个 二进制环形 数组 nums ，返回在 任意位置 将数组中的所有 1 聚集在一起需要的最少交换次数。
//
//
//
//    示例 1：
//
//    输入：nums = [0,1,0,1,1,0,0]
//    输出：1
//    解释：这里列出一些能够将所有 1 聚集在一起的方案：
//            [0,0,1,1,1,0,0] 交换 1 次。
//            [0,1,1,1,0,0,0] 交换 1 次。
//            [1,1,0,0,0,0,1] 交换 2 次（利用数组的环形特性）。
//    无法在交换 0 次的情况下将数组中的所有 1 聚集在一起。
//    因此，需要的最少交换次数为 1 。

    /**
     * 0 1 0 1 1 0 0 1 0 1 1 0 0
     *
     */
}
