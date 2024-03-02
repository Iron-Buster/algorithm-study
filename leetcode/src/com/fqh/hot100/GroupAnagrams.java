package com.fqh.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/2 11:50
 **/
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        var map = new HashMap<String, List<String>>();
        for (var s : strs) {
            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            String k = String.valueOf(cs);
            map.computeIfAbsent(k, v -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
