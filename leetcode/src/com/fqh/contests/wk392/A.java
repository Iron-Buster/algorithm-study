package com.fqh.contests.wk392;

import java.util.Arrays;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/4/7 20:22
 **/
public class A {

    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int[] s = new int[n];
        s[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i-1]) {
                s[i] = s[i-1] + 1;
            } else {
                s[i] = 1;
            }
        }
        int ans = Arrays.stream(s).max().getAsInt();
        s = new int[n];
        s[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i-1]) {
                s[i] = s[i-1] + 1;
            } else {
                s[i] = 1;
            }
        }
        return Math.max(ans, Arrays.stream(s).max().getAsInt());
    }
}
