package com.fqh.滑动窗口.恰好k个模型;

import java.util.HashMap;
import java.util.HashSet;

public class LC_3306 {

    // https://leetcode.cn/problems/count-of-substrings-containing-every-vowel-and-k-consonants-ii/description/
    static final HashSet<Character> set = new HashSet<>() {
        {
            add('a');
            add('e');
            add('i');
            add('o');
            add('u');
        }
    };

    public int countOfSubstrings(String word, int k) {
        char[] s = word.toCharArray();
        return f(s, k) - f(s, k + 1);
    }

    int f(char[] s, int k) {
        var cnt = new HashMap<Character, Integer>();
        int fcnt = 0;
        int j = 0;
        int ans = 0;
        for (int i = 0; i < s.length; i++) {
            char c = s[i];
             if (set.contains(c)) {
                 cnt.merge(c, 1, Integer::sum);
             } else {
                 fcnt++;
             }
            while (cnt.size() == 5 && fcnt >= k) {
                c = s[j];
                if (set.contains(c)) {
                    cnt.merge(c, -1, Integer::sum);
                    if (cnt.get(c) == 0) cnt.remove(c);
                } else {
                    fcnt--;
                }
                j++;
            }
            ans += j;
        }
        return ans;
    }


    public static void main(String[] args) {
        String word = "aeiou";
        System.out.println(new LC_3306().countOfSubstrings(word, 0));
    }
}
