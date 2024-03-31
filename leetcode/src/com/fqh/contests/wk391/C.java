package com.fqh.contests.wk391;

import java.util.Arrays;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/31 12:44
 **/
public class C {

    public long countAlternatingSubarrays(int[] nums) {
        int n = nums.length;
        long[] s = new long[n];
        Arrays.fill(s, 1L);
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i-1]) {
                s[i] += s[i-1];
            }
        }
        return Arrays.stream(s).sum();
    }
}
