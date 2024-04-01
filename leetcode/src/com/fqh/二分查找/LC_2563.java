package com.fqh.二分查找;

import java.util.Arrays;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/4/1 21:15
 **/
public class LC_2563 {

//    https://leetcode.cn/problems/count-the-number-of-fair-pairs/description/

    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int l = bisectLeft(nums, i + 1, lower - nums[i]);
            int r = bisectRight(nums, i + 1, upper - nums[i]);
            if (l == -1 || r == -1) continue;
            ans += r - l;
        }
        return ans;
    }

    public static int bisectLeft(int[] a, int start, int target) {
        int left = start, right = a.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (a[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static int bisectRight(int[] a, int start, int target) {
        int left = start, right = a.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (a[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
