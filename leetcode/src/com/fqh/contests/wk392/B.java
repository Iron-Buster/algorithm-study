package com.fqh.contests.wk392;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/4/7 20:22
 **/
public class B {


    public String getSmallestString(String str, int k) {
        char[] s = str.toCharArray();
        for (int i = 0; i < s.length && k > 0; i++) {
            for (int j = 0; j < 26; j++) {
                int d1 = s[i] - 'a' - j;
                int d2 = 26 - (s[i] - 'a') + j;
                int mn = Math.min(d1, d2);
                if (k - mn >= 0) {
                    k -= mn;
                    s[i] = (char) ('a' + j);
                    break;
                }
            }
        }

        return String.valueOf(s);
    }
}
