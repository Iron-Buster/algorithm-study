package com.fqh.贪心.排序后贪心;

import java.util.Arrays;

//https://leetcode.cn/problems/find-the-value-of-the-partition/description/
public class LC_2740 {
  
    public int findValueOfPartition(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            ans = Math.min(ans, nums[i] - nums[i - 1]);
        }
        return ans;
    }
}
