package com.fqh.hot100;

import java.util.HashMap;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/2 12:15
 **/
public class SubarraySumEqualsK {
    //https://leetcode.cn/problems/subarray-sum-equals-k/description/?envType=study-plan-v2&envId=top-100-liked
    public int subarraySum(int[] nums, int k) {
        var map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        int s = 0, ans = 0;
        for (int i = 0; i < nums.length; i++) {
            s += nums[i];
            ans += map.getOrDefault(s - k, 0);
            map.merge(s, 1, Integer::sum);
        }
        return ans;
    }
}
