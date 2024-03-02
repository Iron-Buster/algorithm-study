package com.fqh.hot100;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/2 12:09
 **/
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[26];
        int j = 0, ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map[ch-'a']++;
            while (map[ch-'a'] > 1) {
                map[s.charAt(j)-'a']--;
                j++;
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }
}
