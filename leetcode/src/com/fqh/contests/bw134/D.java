package com.fqh.contests.bw134;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/7/10 22:55
 **/
public class D {

    //https://leetcode.cn/problems/number-of-subarrays-with-and-value-of-k/description/

    public long countSubarrays(int[] nums, int k) {
        long ans = 0, cnt = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            if (x == k) cnt++;
            for (int j = i - 1; j >= 0; j--) {
                if ((nums[j] & x) == nums[j]) break;
                if (nums[j] == k) cnt--;
                nums[j] &= x;
                if (nums[j] == k) cnt++;
            }
            ans += cnt;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
