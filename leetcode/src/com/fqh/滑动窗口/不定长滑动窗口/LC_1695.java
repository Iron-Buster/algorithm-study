package com.fqh.滑动窗口.不定长滑动窗口;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author: vq
 * @Date: 2023/12/18 18:17
 * @Version V1.0
 */
public class LC_1695 {

    // 最大得分 = 和最小并且里面没有重复元素的一个子数组）这个minScore可以使用滑动窗口求解
    public int maximumUniqueSubarray(int[] nums) {
        var map = new HashMap<Integer, Integer>();
        int ans = 0, s = 0, j = 0;
        for (int i = 0; i < nums.length; i++) {
            map.merge(nums[i], 1, Integer::sum);
            s += nums[i];
            while (map.get(nums[i]) > 1) {
                map.merge(nums[j], -1, Integer::sum);
                s -= nums[j];
                if (map.get(nums[j]) == 0) map.remove(nums[j]);
                j++;
            }
            ans = Math.max(ans, s);
        }
        return ans;
    }

    //    1695. 删除子数组的最大得分
//    第 220 场周赛
//            Q2
//1529
//    相关标签
//            相关企业
//    提示
//    给你一个正整数数组 nums ，请你从中删除一个含有 若干不同元素 的子数组。删除子数组的 得分 就是子数组各元素之 和 。
//
//    返回 只删除一个 子数组可获得的 最大得分 。
//
//    如果数组 b 是数组 a 的一个连续子序列，即如果它等于 a[l],a[l+1],...,a[r] ，那么它就是 a 的一个子数组。
//
//
//
//    示例 1：
//
//    输入：nums = [4,2,4,5,6]
//    输出：17
//    解释：最优子数组是 [2,4,5,6]

//    输入：nums = [5,2,1,2,5,2,1,2,5]
//    输出：8
//    解释：最优子数组是 [5,2,1] 或 [1,2,5]
}
