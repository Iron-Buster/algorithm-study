package com.fqh.滑动窗口.不定长滑动窗口.求最长最大;

/**
 * @Author: vq
 * @Date: 2023/12/20 18:08
 * @Version V1.0
 */
public class LC_2401 {

//    2401. 最长优雅子数组
//            已解答
//    第 309 场周赛
//            Q3
//1750
//    相关标签
//            相关企业
//    提示
//    给你一个由 正 整数组成的数组 nums 。
//
//    如果 nums 的子数组中位于 不同 位置的每对元素按位 与（AND）运算的结果等于 0 ，则称该子数组为 优雅 子数组。
//
//    返回 最长 的优雅子数组的长度。
//
//    子数组 是数组中的一个 连续 部分。
//
//    注意：长度为 1 的子数组始终视作优雅子数组。


    // 二进制位上有交集的数字 AND 一定不为零（转化为滑动窗口求 二进制位上最大的没有交集的子数组长度）
    public int longestNiceSubarray(int[] nums) {
        int ans = 0, mask = 0, j = 0;
        for (int i = 0; i < nums.length; i++) {
            while ((mask & nums[i]) > 0) {
                mask ^= nums[j];
                j++;
            }
            mask |= nums[i];
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }
}
