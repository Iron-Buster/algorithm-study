package com.fqh.competition.bw119;

import java.util.HashMap;

/**
 * @Author: vq
 * @Date: 2023/12/9 15:41
 * @Version V1.0
 */
public class C {
    public int maxSubarrayLength(int[] nums, int k) {
        var map = new HashMap<Integer, Integer>();
        int j = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; ++i) {
            map.merge(nums[i], 1, Integer::sum);
            while (j < i && map.get(nums[i]) > k) {
                int left = nums[j];
                map.merge(left, -1, Integer::sum);
                j++;
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
