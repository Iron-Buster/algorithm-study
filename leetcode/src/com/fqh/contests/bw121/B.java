package com.fqh.contests.bw121;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/6 20:11
 **/
public class B {

    public int minOperations(int[] nums, int k) {
        int[] cnt = new int[32];
        for (int num : nums) {
            for (int i = 31; i >= 0; i--) {
                if (((num >> i) & 1) == 1) {
                    cnt[i]++;
                }
            }
        }
        int ans = 0;
        // 每位1的个数
        for (int i = 31; i >= 0; i--) {
            if (((k >> i) & 1) == 1) {
                if (cnt[i] % 2 == 0) { // 偶数个1
                    ans++;
                }
            } else {
                if (cnt[i] % 2 == 1) { // 奇数个1
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
