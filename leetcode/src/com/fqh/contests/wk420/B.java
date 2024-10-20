package com.fqh.contests.wk420;

public class B {

    public int numberOfSubstrings(String s, int k) {
        int ans = 0;
        int[] cnt = new int[26];
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            cnt[c-'a']++;
            while (cnt[c-'a'] >= k) {
                cnt[s.charAt(j)-'a']--;
                j++;
            }
            ans += j;
        }
        return ans;
    }
}
