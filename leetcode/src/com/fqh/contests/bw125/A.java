package com.fqh.contests.bw125;

import java.util.Arrays;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/3 12:16
 **/
public class A {

    public int minOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0;
        for (int x : nums) {
            if (x < k) ans++;
        }
        return ans;
    }
}
