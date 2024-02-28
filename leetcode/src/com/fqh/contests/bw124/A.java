package com.fqh.contests.bw124;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/28 23:08
 **/
public class A {

    public int maxOperations(int[] nums) {
        int n = nums.length;
        int s = nums[0] + nums[1];
        int ans = 1;
        for (int i = 2; i + 1 < n && nums[i] + nums[i+1] == s; i += 2) {
            ans++;
        }
        return ans;
    }
}
