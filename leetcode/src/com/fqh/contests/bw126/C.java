package com.fqh.contests.bw126;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/17 01:00
 **/
public class C {

    public String minimizeStringValue(String s) {
        int n = s.length();
        int[] map = new int[26];
        List<Integer> list = new ArrayList<>();
        List<Character> a = new ArrayList<>();
        char[] ss = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if (ss[i] == '?') list.add(i);
            else map[ss[i]-'a']++;
        }
        for (int i = 0; i < n; i++) {
            if (ss[i] == '?') {
                int min = Integer.MAX_VALUE, k = 0;
                for (int j = 0; j < 26; j++) {
                    if (map[j] < min) {
                        min = map[j];
                        k = j;
                    }
                }
                map[k]++;
                a.add((char) ('a' + k));
            }
        }
        Collections.sort(a);
        for (int i = 0; i < list.size(); i++) {
            ss[list.get(i)] = a.get(i);
        }
        return String.valueOf(ss);
    }
}
