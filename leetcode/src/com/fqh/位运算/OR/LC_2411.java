package com.fqh.位运算.OR;

import java.util.Arrays;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/4/19 22:59
 **/
public class LC_2411 {


//    https://leetcode.cn/problems/smallest-subarrays-with-maximum-bitwise-or/description/

    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = 1;
            int x = nums[i];
            for (int j = i - 1; j >= 0; j--) {
                if ((nums[j] | x) == nums[j]) { // nums[j] | x 不会变大了
                    break;
                }
                nums[j] |= x;
                ans[j] = i - j + 1;
            }
        }
        return ans;
    }
}
