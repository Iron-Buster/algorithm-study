package com.fqh.contests.bw121;

import java.util.HashSet;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/6 20:11
 **/
public class A {

    public int missingInteger(int[] nums) {
        var set = new HashSet<Integer>();
        for (int x : nums) set.add(x);
        int s = nums[0];
        int mx = 1;
        int len = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == s + 1) {
                s += nums[i];
                mx++;
            } else {
                if (mx > len) {
                    for (int j = s; j <= 2500; j++) {
                        if (!set.contains(j)) {
                            return j;
                        }
                    }
                }
                len = Math.max(len, mx);
                mx = 1;
                s = nums[i];
            }
        }
        if (mx > len) {
            for (int j = s; j <= 2500; j++) {
                if (!set.contains(j)) {
                    return j;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
