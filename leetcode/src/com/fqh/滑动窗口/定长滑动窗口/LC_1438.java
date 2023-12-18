package com.fqh.滑动窗口.定长滑动窗口;

import java.util.*;

/**
 * @Author: vq
 * @Date: 2023/12/18 18:32
 * @Version V1.0
 */
public class LC_1438 {

    // 使用平衡数来维护滑动窗口，可以在O(logN)的时间求出当前窗口的最大，最小值
    public int longestSubarray(int[] nums, int limit) {
        var tset = new TreeMap<Integer, Integer>();
        int ans = 0, j = 0;
        for (int i = 0; i < nums.length; i++) {
            tset.merge(nums[i], 1, Integer::sum);
            while (Math.abs(tset.firstKey() - tset.lastKey()) > limit) {
                tset.merge(nums[j], -1, Integer::sum);
                if (tset.get(nums[j]) == 0) tset.remove(nums[j]);
                j++;
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }

//    1438. 绝对差不超过限制的最长连续子数组
//    第 187 场周赛
//            Q3
//1672
//    相关标签
//            相关企业
//    提示
//    给你一个整数数组 nums ，和一个表示限制的整数 limit，请你返回最长连续子数组的长度，该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit 。
//
//    如果不存在满足条件的子数组，则返回 0 。
}
