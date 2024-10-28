package com.fqh.动态规划.树形DP;

import java.util.*;

public class LC_3331 {



    // https://leetcode.cn/problems/find-subtree-sizes-after-changes/description/
    int[] size;
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        size = new int[n];
        Arrays.fill(size, 1);
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, v -> new ArrayList<>());
        for (int i = 1; i < n; i++) {
            g[parent[i]].add(i);
        }
        dfs(0, s.toCharArray(), g, new HashMap<>());
        return size;
    }

    void dfs(int x, char[] s, List<Integer>[] g, Map<Character, Integer> map) {
        int old = map.getOrDefault(s[x], -1);
        map.put(s[x], x);
        for (int y : g[x]) {
            dfs(y, s, g, map);
            int anc = map.getOrDefault(s[y], -1);
            if (anc < 0) {
                size[x] += size[y];
            } else {
                size[anc] += size[y];
            }
        }
        map.put(s[x], old); // 恢复现场
    }
}
