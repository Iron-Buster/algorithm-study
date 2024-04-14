package com.fqh.contests.bw128;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/4/14 10:25
 **/
public class A {

    public int scoreOfString(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) ans += Math.abs(s.charAt(i) - s.charAt(i+1));
            else if (i == n - 1) ans += Math.abs(s.charAt(i) - s.charAt(i-1));
            else ans += Math.min(Math.abs(s.charAt(i) - s.charAt(i-1)), Math.abs(s.charAt(i) - s.charAt(i+1)));
        }
        return ans;
    }
}
