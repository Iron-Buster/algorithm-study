package com.fqh.哈希表;

public class LC_3335 {

    // https://leetcode.cn/problems/total-characters-in-string-after-transformations-i/description/
    static final int MOD = (int) (1e9 + 7);
    public int lengthAfterTransformations(String s, int t) {
        int[] cnt = new int[26];
        for (char c: s.toCharArray()) {
            cnt[c-'a']++;
        }
        while (t-- > 0) {
            int[] v = new int[26];
            for (int i = 0; i < 26; i++) {
                if (cnt[i] == 0) continue;
                if (i == 25) {
                    v[0] += cnt[i];
                    v[1] += cnt[i];
                } else {
                    v[i+1] += cnt[i];
                }
                cnt[i] = 0;
            }
            for (int i = 0; i < 26; i++) {
                cnt[i] = (cnt[i] + v[i]) % MOD;
            }
        }
        long ans = 0;
        for (int c : cnt) {
            ans = (ans + c) % MOD;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        System.out.println(new LC_3335().lengthAfterTransformations("abcyy", 2));
    }
}
