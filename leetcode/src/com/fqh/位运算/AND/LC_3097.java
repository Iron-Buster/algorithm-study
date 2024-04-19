package com.fqh.位运算.AND;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/4/19 23:01
 **/
public class LC_3097 {

//    https://leetcode.cn/problems/shortest-subarray-with-or-at-least-k-ii/description/

    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            if (x >= k) return 1;
            for (int j = i - 1; j >= 0; j--) {
                if ((nums[j] | x) == nums[j]) { // nums[j] | x 不会变大了
                    break;
                }
                nums[j] |= x;
                if (nums[j] >= k) {
                    ans = Math.min(ans, i - j + 1);
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
