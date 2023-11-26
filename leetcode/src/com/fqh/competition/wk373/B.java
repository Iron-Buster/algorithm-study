package com.fqh.competition.wk373;

/**
 * @Author: vq
 * @Date: 2023/11/25 23:36
 * @Version V1.0
 */
public class B {

    boolean check(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public int beautifulSubstrings(String s, int k) {
        int n = s.length();
        var ss = s.toCharArray();
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int cnt1 = 0;
            int cnt2 = 0;
            for (int j = i; j < n; ++j) {
                if (check(ss[j])) {
                    ++cnt1;
                } else {
                    ++cnt2;
                }
                if (cnt1 > 0 && cnt1 == cnt2 && ((cnt1 * cnt2) % k == 0)) {
                    ans++;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {

    }
}
