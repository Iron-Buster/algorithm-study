package com.fqh.contests.wk392;

import java.util.Arrays;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/4/7 20:23
 **/
public class C {

    public long minOperationsToMakeMedianK(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        long ans = 0;
        if (nums[n/2] > k) {
            for (int i = n/2; i >= 0 && nums[i] > k; i--) {
                ans += nums[i] - k;
            }
        } else {
            for (int i = n/2; i < n && nums[i] < k; i++) {
                ans += k - nums[i];
            }
        }
        return ans;
    }
}
