package com.fqh.位运算;

import java.util.Arrays;

public class LC_3309 {

    //https://leetcode.cn/problems/maximum-possible-number-by-binary-concatenation/description/
    public int maxGoodNumber(int[] nums) {
        Integer[] arr = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }
        Arrays.sort(arr, (a, b) -> {
            int lenA = 32 - Integer.numberOfLeadingZeros(a);
            int lenB = 32 - Integer.numberOfLeadingZeros(b);
            return (b << lenA | a) - (a << lenB | b);
        });
        int ans = 0;
        for (int x : arr) {
            ans = ans << (32 - Integer.numberOfLeadingZeros(x)) | x;
        }
        return ans;
    }
}
