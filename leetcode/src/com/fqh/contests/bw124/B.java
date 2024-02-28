package com.fqh.contests.bw124;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/28 23:09
 **/
public class B {

    public String lastNonEmptyString(String s) {
        int[] map = new int[26];
        int mx = 0;
        char[] cs = s.toCharArray();
        int[] last = new int[26];
        for (int i = 0; i < cs.length; i++) {
            map[cs[i]-'a']++;
            mx = Math.max(mx, map[cs[i]-'a']);
            last[cs[i]-'a'] = i;
        }
        var ans = new StringBuilder();
        for (int i = 0; i < cs.length; i++) {
            if (last[cs[i]-'a'] == i && map[cs[i]-'a'] == mx) {
                ans.append(cs[i]);
            }
        }
        return ans.toString();
    }
}
