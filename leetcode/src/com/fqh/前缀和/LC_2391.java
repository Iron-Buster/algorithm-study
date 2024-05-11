package com.fqh.前缀和;

import java.util.HashMap;

public class LC_2391 {

    // 前缀和O(N)做法
    public int garbageCollection(String[] garbage, int[] travel) {
        int n = travel.length;
        var cnt = new HashMap<Character, Integer>();
        var map = new HashMap<Character, Integer>();
        for (int i = 0; i < garbage.length; i++) {
            for (var c : garbage[i].toCharArray()) {
                map.put(c, i);
                cnt.merge(c, 1, Integer::sum);
            }
        }
        int ans = 0;
        int[] s = new int[n+1];
        for (int i = 0; i < n; i++) s[i+1] = s[i] + travel[i];
        for (var c : map.keySet()) {
            int pos = map.get(c);
            ans += s[pos];
            ans += cnt.getOrDefault(c, 0);
        }
        return ans;
    }
}
