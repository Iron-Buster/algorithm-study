package com.fqh.滑动窗口.定长滑动窗口;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: vq
 * @Date: 2023/12/18 16:13
 * @Version V1.0
 */
public class LC_2461 {

    public long maximumSubarraySum(int[] nums, int k) {
        var map = new HashMap<Integer, Integer>();
        long ans = 0, sum = 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            map.merge(nums[i], 1, Integer::sum);
            sum += nums[i];
            if (i - j + 1 > k) {
                sum -= nums[j];
                map.merge(nums[j], -1, Integer::sum);
                if (map.get(nums[j]) == 0) map.remove(nums[j]);
                j++;
            }
            if (i - j + 1 == k && map.size() == k) {
                ans = Math.max(ans, sum);
            }
        }
        return ans;
    }

//    2461. 长度为 K 子数组中的最大和
//    第 318 场周赛
//            Q2
//    1553
//    相关标签
//            相关企业
//    提示
//    给你一个整数数组 nums 和一个整数 k 。请你从 nums 中满足下述条件的全部子数组中找出最大子数组和：
//
//    子数组的长度是 k，且
//    子数组中的所有元素 各不相同 。
//    返回满足题面要求的最大子数组和。如果不存在子数组满足这些条件，返回 0 。
//
//    子数组 是数组中一段连续非空的元素序列。
}
