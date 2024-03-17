package com.fqh.contests.bw126;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/17 23:53
 **/
public class A {

    public int sumOfEncryptedInt(int[] nums) {
        int ans = 0;
        for (int x : nums) {
            String s = String.valueOf(x);
            int mx = 0;
            for (int j = 0; j < s.length(); j++) {
                mx = Math.max(mx, s.charAt(j) - '0');
            }
            int v = mx;
            for (int j = 1; j < s.length(); j++) {
                v = v * 10 + mx;
            }
            ans += v;
        }
        return ans;
    }
}
