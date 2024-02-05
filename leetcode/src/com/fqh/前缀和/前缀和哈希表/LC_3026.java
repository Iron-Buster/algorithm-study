package com.fqh.前缀和.前缀和哈希表;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/5 18:11
 **/
public class LC_3026 {

//    3026. 最大好子数组和
//            中等
//    相关企业
//            提示
//    给你一个长度为 n 的数组 nums 和一个 正 整数 k 。
//
//    如果 nums 的一个子数组中，第一个元素和最后一个元素 差的绝对值恰好 为 k ，我们称这个子数组为 好 的。
//    换句话说，如果子数组 nums[i..j] 满足 |nums[i] - nums[j]| == k ，那么它是一个好子数组。
//
//    请你返回 nums 中 好 子数组的 最大 和，如果没有好子数组，返回 0

    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long[] s = new long[n+1];
        for (int i = 0; i < n; i++) s[i+1] = s[i] + nums[i];
        var tmap = new HashMap<Integer, Pair>();
        long ans = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (tmap.containsKey(nums[i] - k)) {
                ans = Math.max(ans, s[i+1] - tmap.get(nums[i] - k).sum);
            }
            if (tmap.containsKey(nums[i] + k)) {
                ans = Math.max(ans, s[i+1] - tmap.get(nums[i] + k).sum);
            }
            if (tmap.containsKey(nums[i])) {
                Pair mx = tmap.get(nums[i]);
                if (s[i] < mx.sum) {
                    tmap.put(nums[i], new Pair(i, s[i]));
                }
                continue;
            }
            tmap.put(nums[i], new Pair(i, s[i]));
        }
        return ans == Long.MIN_VALUE ? 0 : ans;
    }

    class Pair {
        int index;
        long sum;

        public Pair(int index, long sum) {
            this.index = index;
            this.sum = sum;
        }
    }
}
