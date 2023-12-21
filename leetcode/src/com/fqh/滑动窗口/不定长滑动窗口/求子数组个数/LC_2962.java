package com.fqh.滑动窗口.不定长滑动窗口.求子数组个数;

import java.security.Key;
import java.util.Arrays;

/**
 * @Author: vq
 * @Date: 2023/12/20 18:40
 * @Version V1.0
 */
public class LC_2962 {

    // 枚举右端点
    public long countSubarrays(int[] nums, int k) {
        int mx = Arrays.stream(nums).max().getAsInt();
        int maxCnt = 0, j = 0;
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == mx) maxCnt++;
            // 取小于等于 i，而不是小于 i的原因是 k可能等于1，然后j=i并且nums[i]=mx
            while (j <= i && maxCnt >= k) {
                if (nums[j] == mx) maxCnt--;
                j++;
            }
            ans += j; // j-1就是合法的最大左端点的长度
        }
        return ans;
    }

//    2962. 统计最大元素出现至少 K 次的子数组
//            已解答
//    第 375 场周赛
//            Q3
//1701
//    相关标签
//            相关企业
//    给你一个整数数组 nums 和一个 正整数 k 。
//
//    请你统计有多少满足 「 nums 中的 最大 元素」至少出现 k 次的子数组，并返回满足这一条件的子数组的数目。
//
//    子数组是数组中的一个连续元素序列。
//
//
//
//    示例 1：
//
//    输入：nums = [1,3,2,3,3], k = 2
//    输出：6
//    解释：包含元素 3 至少 2 次的子数组为：[1,3,2,3]、[1,3,2,3,3]、[3,2,3]、[3,2,3,3]、[2,3,3] 和 [3,3] 。
}
