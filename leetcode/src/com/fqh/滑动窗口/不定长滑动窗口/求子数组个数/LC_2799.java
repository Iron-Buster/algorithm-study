package com.fqh.滑动窗口.不定长滑动窗口.求子数组个数;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author: vq
 * @Date: 2023/12/21 10:43
 * @Version V1.0
 */
public class LC_2799 {


    public int countCompleteSubarrays(int[] nums) {
        var set = new HashSet<Integer>();
        for (int x : nums) set.add(x);
        var map = new HashMap<Integer, Integer>();
        int ans = 0, j = 0;

        // 枚举右端点
        for (int i = 0; i < nums.length; i++) {
            map.merge(nums[i], 1, Integer::sum);
            while (map.size() == set.size()) {
                map.merge(nums[j], -1, Integer::sum);
                if (map.get(nums[j]) == 0) map.remove(nums[j]);
                j++;
            }
            ans += j;
        }
        return ans;
    }




//    2799. 统计完全子数组的数目
//            已解答
//    第 356 场周赛
//            Q2
//1398
//    相关标签
//            相关企业
//    提示
//    给你一个由 正 整数组成的数组 nums 。
//
//    如果数组中的某个子数组满足下述条件，则称之为 完全子数组 ：
//
//    子数组中 不同 元素的数目等于整个数组不同元素的数目。
//    返回数组中 完全子数组 的数目。
//
//    子数组 是数组中的一个连续非空序列。
}
