package com.fqh.分组循环;

/**
 * @Author: vq
 * @Date: 2023/11/28 17:41
 * @Version V1.0
 */
public class LC_2765 {

//    2765. 最长交替子序列
//                已解答
//        第 108 场双周赛
//                Q1
//    1581
//    相关标签
//            相关企业
//    提示
//    给你一个下标从 0 开始的整数数组 nums 。如果 nums 中长度为 m 的子数组 s 满足以下条件，我们称它是一个 交替子序列 ：
//
//    m 大于 1 。
//    s1 = s0 + 1 。
//    下标从 0 开始的子数组 s 与数组 [s0, s1, s0, s1,...,s(m-1) % 2] 一样。也就是说，s1 - s0 = 1 ，s2 - s1 = -1 ，s3 - s2 = 1 ，s4 - s3 = -1 ，以此类推，直到 s[m - 1] - s[m - 2] = (-1)m 。
//    请你返回 nums 中所有 交替 子数组中，最长的长度，如果不存在交替子数组，请你返回 -1 。
//
//    子数组是一个数组中一段连续 非空 的元素序列。
//
//
//
//    示例 1：
//
//    输入：nums = [2,3,4,3,4]
//    输出：4
//    解释：交替子数组有 [3,4] ，[3,4,3] 和 [3,4,3,4] 。最长的子数组为 [3,4,3,4] ，长度为4 。

    public int alternatingSubarray(int[] nums) {
        return f(nums);
    }

    int f(int[] a) {
        int n = a.length;
        int mx = -1, i = 0;
        while (i < n - 1) {
            if (a[i + 1] - a[i] != 1) {
                i += 1;
                continue;
            }
            int st = i;
            for (i++; i < n && a[i] == a[st] + (i - st) % 2; i++);
            mx = Math.max(mx, i - st);
            i -= 1;
        }
        return mx;
    }

    public static void main(String[] args) {
        System.out.println(new LC_2765().f(new int[]{2, 3, 4, 3, 4}));
    }
}
