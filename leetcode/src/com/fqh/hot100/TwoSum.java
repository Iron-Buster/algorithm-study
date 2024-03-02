package com.fqh.hot100;

import java.util.HashMap;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/2 11:48
 **/
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int v = target - nums[i];
            if (map.containsKey(v)) {
                return new int[]{map.get(v), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
