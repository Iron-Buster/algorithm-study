package com.fqh.滑动窗口.不定长滑动窗口.求子数组个数;

/**
 * @Author: vq
 * @Date: 2023/12/21 12:13
 * @Version V1.0
 */
public class LC_2302 {


    public long countSubarrays(int[] nums, long k) {
        long sum = 0, ans = 0;
        int j = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            while (sum * (i - j + 1) >= k) {
                sum -= nums[j++];
            }
            ans += i - j + 1;
        }
        return ans;
    }


//    2302. 统计得分小于 K 的子数组数目
//            已解答
//    第 80 场双周赛
//            Q4
//1808
//    相关标签
//            相关企业
//    提示
//    一个数组的 分数 定义为数组之和 乘以 数组的长度。
//
//    比方说，[1, 2, 3, 4, 5] 的分数为 (1 + 2 + 3 + 4 + 5) * 5 = 75 。
//    给你一个正整数数组 nums 和一个整数 k ，请你返回 nums 中分数 严格小于 k 的 非空整数子数组数目。
//
//    子数组 是数组中的一个连续元素序列。
}
