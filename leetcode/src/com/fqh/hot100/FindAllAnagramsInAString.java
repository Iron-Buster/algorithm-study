package com.fqh.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/2 12:11
 **/
public class FindAllAnagramsInAString {

    //https://leetcode.cn/problems/find-all-anagrams-in-a-string/?envType=study-plan-v2&envId=top-100-liked
    boolean check(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        int[] a = new int[26], b = new int[26];
        var ans = new ArrayList<Integer>();
        for (char c : p.toCharArray()) b[c-'a']++;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i)-'a']++;
            if (i - j + 1 == p.length()) {
                if (check(a, b)) ans.add(j);
                a[s.charAt(j)-'a']--;
                j++;
            }
        }
        return ans;
    }
}
